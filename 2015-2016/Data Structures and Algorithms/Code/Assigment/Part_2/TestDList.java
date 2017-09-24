import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java. util.Scanner;

class TestDList
{
	public static void main (String args[])
	{
		ADTDList dList= new ADTDList();//ref to ADTAList

		Scanner user_input = new Scanner (System.in);
		String file;//name of the file
		System.out.print("Filename : ");
		file=user_input.next();
		try(BufferedReader in = new BufferedReader(new FileReader(file)))
		{
			int i=1;
			for(String line; (line = in.readLine()) != null; )
			{
				//System.out.println(line);
				dList.add(i, new String(line));
				i++;
			}
		}
		catch(Exception x)
		{
			System.out.println(x);//can't find the file
		}

		while(dList.size()!=1)//prints out the list while size does != 1
		{

			for(int j=1; j<dList.size();j++)
			{
				System.out.print(dList.get(j)+"\t");//prints the user and tabs

				int l= (int)(Math.random()*2);//random picks a number from 0 and 1

				if(l==0)// if 0 Logged on
				{
					System.out.print("\tLOGGED ON\n\n");//print tab user stats new line and new line
					time();//slow down
				}
				else if(l==1)//if 1 Logged off
				{
					System.out.print("\tLOOGED OFF\n\n");//print tab user stats new line and new line
					dList.remove(j);//remove user at index j
					time();//slow down
				}
			}
		}
		if(dList.size()!=0)
		{
			System.out.println("All users have logged off");//When size does != 0 print
		}
	}
	public static void time()
	{
		try{
			Thread.sleep(100);//speed of timer 1 sec
		}
		catch(Exception x){
		}
	}
}