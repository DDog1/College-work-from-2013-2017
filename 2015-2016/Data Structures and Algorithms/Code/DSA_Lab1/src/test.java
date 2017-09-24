/**
 * @author Darren Cosgrave
 *
 */
import java.util.Scanner;
public class test 
{
	static Scanner user_input = new Scanner (System.in);//Sets User_input to read in the users input
	static boolean empty;
	static boolean full;
	static int space_left;
	static int size;
	static int index_value;
	public static void main(String[]args)
	{
		display();
	}
	
	static void display()
	{
		String pick;
		System.out.println("+----------------------+");
		System.out.println("|1 | Empty list        |");
		System.out.println("|----------------------|");
		System.out.println("|2 | Check Space       |");
		System.out.println("|----------------------|");
		System.out.println("|3 | Check size        |");
		System.out.println("|----------------------|");
		System.out.println("|4 | Add value         |");
		System.out.println("|----------------------|");
		System.out.println("|5 | Get value         |");
		System.out.println("|----------------------|");
		System.out.println("|6 | Remove value      |");
		System.out.println("|----------------------|");
		System.out.println("|7 | Remove all        |");
		System.out.println("+----------------------+");	
		
		System.out.print("Please pick an option :");
		pick= user_input.next();
		
		if(pick.equals("1"))
		{
			ArrayList.isEmpty();
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
			ArrayList.isFull();
			if(full==true)
			{
				System.out.println("\nThe array is full\n");
				display();
			}
			else
			{
				System.out.println("\nThe array has "+space_left+"\n");
				display();
			}
		}
		else if(pick.equals("3"))
		{
			ArrayList.size();
			System.out.println("\nThe number of items in that array is : \n"+size);
			display();
		}
		else if(pick.equals("4"))
		{
			int x,y;
			System.out.println("Please select the index you want to add an item to :");
			x= user_input.nextInt();
			System.out.println("Please enter in the value int that you want in the array :");
			y= user_input.nextInt();
			
			System.out.println("Is index "+x+" ,with value "+y+" ,right? y/n");
			char yesNo=user_input.next().charAt(0);
			if(yesNo=='y')
			{
			ArrayList.add(x,y);
			display();
			}	
			else if(yesNo=='n')
			{
				display();
			}
			else
			{
				System.out.println("This is not an option please pick again\n");
				display();
			}
		}
		else if(pick.equals("5"))
		{
			int i;
			System.out.println("Please select the index you want to see : ");
			i= user_input.nextInt();
			
			ArrayList.get(i);
			System.out.println("Value at index "+i+" is : "+index_value);
			display();
		}
		else if(pick.equals("6"))
		{
			int i;
			System.out.println("Please select the index you want to remove : ");
			i= user_input.nextInt();
			ArrayList.remove(i);
			display();
		}
		else if(pick.equals("7"))
		{
			ArrayList.removeAll();
			System.out.println();
			display();
		}
		else//If the used enters in something other than 1-6
		{
			System.out.println("This is not an option please pick again\n");
			display();
		}
	}
}
