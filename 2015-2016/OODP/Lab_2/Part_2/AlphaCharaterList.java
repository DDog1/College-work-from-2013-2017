import java.util.StringTokenizer;
public class AlphaCharaterList extends NumberList {
	int size;
	AlphaCharaterList(String list) {
		size = 0;
		StringTokenizer token = new StringTokenizer(list);
		size = token.countTokens();
		// Allocate some space for the array
		charList = new char[size];
		// Store each list item an the appropriate array
		char[] temp = list.toCharArray();
		char[] temp1 = new char[size];
		int j=0;
		for(int x = 0; x< temp.length;x++)
		{
			if(temp[x]==' ')
			{

			}
			else
			{
				charList[j]=temp[x];
				j++;
			}

		}
	}

	public void display()
	{
		System.out.println("Char List");
		for(int i = 0; i < size; i++)
			System.out.println("[" + i + "] = " + charList[i]);
		}
	}