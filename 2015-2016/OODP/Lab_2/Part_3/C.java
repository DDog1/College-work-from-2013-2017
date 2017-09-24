import java.util.StringTokenizer;
public class C extends Account
{
	int size;
	C(String list)
	{
		size=0;
		StringTokenizer token = new StringTokenizer(list);
		size = token.countTokens();
		// Allocate some space for the array
		C = new String[size];
		C = list.split(" ");
	}

	public void display()
	{
		System.out.println("Current Accounts");
		for(int i = 0; i < size; i++)
		{
			System.out.println("["+i+"] = "+C[i]);
		}
	}

}