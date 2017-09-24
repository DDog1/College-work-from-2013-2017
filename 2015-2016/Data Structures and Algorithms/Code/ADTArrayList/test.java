import java.util.Scanner;
class test
{
	static Scanner user_input = new Scanner (System.in);//Sets User_input to read in the users input
	private static ArrayList t;
	static int space_left;
	public static void main(String[]args)
	{
		t = new ArrayList();
		t.add(1,6);
		t.add(2,7);
		t.add(3,9);


		display();
	}

	public static void display()
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
		System.out.println("|----------------------|");
		System.out.println("|8 | Print  all        |");
		System.out.println("|----------------------|");
		System.out.println("|9 | Exit              |");
		System.out.println("+----------------------+");

		System.out.print("\nPlease pick an option :");
		pick= user_input.next();


		if(pick.equals("1"))
		{
			if(t.isEmpty()==true)
				System.out.println("\nThe array is empty\n");
			else
				System.out.println("\nThe array is not empty\n");

			display();
		}

		else if(pick.equals("2"))
		{
			if(t.isFull()==true)
				System.out.println("\nThe array is full\n");

			else
				System.out.println("\nThe array has "+space_left+" left in the array\n");

			display();
		}

		else if(pick.equals("3"))
		{
			System.out.println("\nThe size of the array is :"+t.size()+"\n");
			display();
		}

		else if(pick.equals("4"))
		{
			int x,y;
			System.out.println("\nPlease select the index you want to add an item to :");
			x= user_input.nextInt();
			System.out.print("\nPlease enter in the value int that you want in the array :");
			y= user_input.nextInt();

			System.out.print("\nIs index "+x+" ,with value "+y+" ,right? y/n");
			char yesNo=user_input.next().charAt(0);
			if(yesNo=='y')
			{
				System.out.println("The value is being added to the array");
				t.add(x,y);
				display();
			}
			else if(yesNo=='n')
			{
				display();
			}
			else
			{
				System.out.println("\nThis is not an option please pick again\n");
				display();
			}
		}

		else if(pick.equals("5"))
		{
			int i;
			System.out.print("\nPlease select the index you want to see : ");
			i= user_input.nextInt();

			int x = t.get(i);
			System.out.println("\nValue at index "+i+" is : "+x+"\n");
			display();
		}
		else if(pick.equals("6"))
		{
			int i;
			System.out.println("Please select the index you want to remove : ");
			i= user_input.nextInt();
			t.remove(i);
			display();
		}

		else if(pick.equals("7"))
		{
			t.removeAll();
			System.out.println("\nThe array has been wiped clean\n");
			display();
		}

		else if(pick.equals("8"))
		{
			if(t.size()==0)
			{
				System.out.println("\nArray is empty\n");
			}
			for(int i = 1; i<=t.size();i++)
			{
				System.out.println("index "+i+" value "+t.get(i));
			}
			String e;
			System.out.println("\nPress d for display or any key for exit\n");
			e= user_input.next();
			if(e.equals("d"))
			{
				display();
			}
			else
			{
				System.out.println("\nProgram closing\n");
			}

		}

		else if(pick.equals("9"))
		{
			System.out.println("\nProgram closing\n");
		}

		else//If the used enters in something other than 1-8
		{
			System.out.println("This is not an option please pick again\n");
			display();
		}
	}
}