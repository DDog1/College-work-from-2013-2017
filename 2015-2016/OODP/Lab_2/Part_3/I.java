import java.util.StringTokenizer;
public class I extends Account
{
	int size;
	I(String list)
	{
		size=0;
		StringTokenizer token = new StringTokenizer(list);
		size = token.countTokens();
		// Allocate some space for the array
		I = new String[size];
		I = list.split(" ");
	}

	public void display()
	{
		System.out.println("Investment Accounts");
		for(int i = 0; i < size; i++)
		{
			System.out.println("["+i+"] = "+I[i]);
		}
	}

}