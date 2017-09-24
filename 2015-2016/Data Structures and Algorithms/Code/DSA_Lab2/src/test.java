import java.util.Scanner;

import javax.swing.JOptionPane;

public class test
{
	static Scanner user_input = new Scanner (System.in);//Sets User_input to read in the users input
	static boolean empty;
	static int size;
	static int value;
	private static ListReferenceBased t;
	public static void main(String[]args)
	{
		t= new ListReferenceBased();
		display();
	}
	
	public static void display()
	{
		try{
			String pick;
			System.out.println("+----------------------+");
			System.out.println("|1 | Empty list        |");
			System.out.println("|----------------------|");
			System.out.println("|2 | Check size        |");
			System.out.println("|----------------------|");
			System.out.println("|3 | Get value         |");
			System.out.println("|----------------------|");
			System.out.println("|4 | Add value         |");
			System.out.println("|----------------------|");
			System.out.println("|5 | Remove value      |");
			System.out.println("|----------------------|");
			System.out.println("|6 | Remove all        |");
			System.out.println("|----------------------|");
			System.out.println("|7 | Print  all        |");
			System.out.println("|----------------------|");
			System.out.println("|8 | Exit              |");
			System.out.println("+----------------------+");
	
			System.out.print("\nPlease pick an option :");
			pick= user_input.next();
			
			if(pick.equals("1")){
				empty=t.isEmpty();
				if(empty==true)
				{	
					System.out.println("\nThere is space left in the array\n");
					display();
				}
				else
				{
					System.out.println("\nThere is no space left in the array");
					display();
				}	
			}
			else if(pick.equals("2"))
			{
				size=t.size();
				System.out.println("The size is :"+size);
				display();
				
			}
			else if(pick.equals("3"))
			{
				try{
					int x;
					System.out.println("Please enter in index you are looking for :");
					x=user_input.nextInt();
					value=(int) t.get(x);
					System.out.println("The value in index "+x+" is "+value);
				}
				catch(ListIndexOutOfBoundsException x)
				{
					//System.out.println("Value out of bounds"+x);
					System.out.println(x);
					display();
				}
			}
			else if(pick.equals("4"))
			{
				int x,y;
				System.out.println("Please enter in the index value :");
				x=user_input.nextInt();
				System.out.println("Please enter in the value for index "+x+" :");
				y=user_input.nextInt();
				
				//value=t.add(x, y);
			}
			else if(pick.equals("5"))
			{
				
			}
			else if(pick.equals("6"))
			{
				
			}
			else if(pick.equals("7"))
			{
				
			}
			else if(pick.equals("8"))
			{
				
			}
			
			else//If the used enters in something other than 1-n options
			{
				System.out.println("This is not an option please pick again\n");
				display();
			}
		}
		catch(NumberFormatException x)
		{
			JOptionPane.showMessageDialog(null,"Input must be a number.");
		}
	}
}
