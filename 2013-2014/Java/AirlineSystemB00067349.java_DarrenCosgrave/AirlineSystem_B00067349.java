/****************************************************************************/
/* Name: Darren Cosgrave 													*/
/* Date:  22 March 2014 													*/
/* Program Name: AirlineSystem_B00067349.java 								*/
/* 																			*/
/* An airplane program               										*/
/* an application to implement an Airline Seat Reservation System.			*/
/* The system should maintain who is sitting in each seat.					*/
/* The plane will have 30 rows and 6 columns of seats. 						*/
/* The rows are indexed by a number 1-30 and the columns					*/
/* are indexed with a letter A-F.											*/
/****************************************************************************/

class AirlineSystem_B00067349
{
	static int seats_left=180;//the amount of seats
	static int R;//row
	static int C;//column

	static int cost=150+(180/seats_left);//formula

	static String seats_2[][]=new String[][]//A 2D array to reset the original
	{
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
	};

	static String seats[][]=new String[][]//The main 2D array to store the name of the user
	{
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
		{"A","B","C","D","E","F"},
	};

	public static void main(String[]args)//Main
	{
		options();//calling options
	}

	static void options()
	{
		int options;

		System.out.println(" ");
		System.out.println("Would you like to check one of the following ? : ");
		System.out.println(" ");
		System.out.println("+---------------------+");//Options the user has to pick from
		System.out.println("| 1 | Book Seat       |");
		System.out.println("|---+-----------------|");
		System.out.println("| 2 | Cancel Seat     |");
		System.out.println("|---+-----------------|");
		System.out.println("| 3 | Seats remaining |");
		System.out.println("|---+-----------------|");
		System.out.println("| 4 | Seat map        |");
		System.out.println("|---+-----------------|");
		System.out.println("| 5 | Seat cost       |");
		System.out.println("|---+-----------------|");
		System.out.println("| 6 | Print Ticket    |");
		System.out.println("|---+-----------------|");
		System.out.println("| 7 | Exit            |");
		System.out.println("+---------------------+");
		System.out.println();

		options = Keyboard.readInt();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

		if(options == 1)//Booking the seat
		{
			booking();
		}

		else if(options == 2)//Cancel the Seat
		{
			cancel();
		}

		else if(options == 3)//Shows the seats that are left
		{
			System.out.println("Seats left : "+seats_left);
			options();
		}

		else if(options == 4)//Prints out the seat map
		{
			System.out.println("\t1\t2\t3\t4\t5\t6\n");
			for(int i=0;i<30;i++)//for loop for the index
			{
				System.out.print((i+1+"\t"));
				for(int j=0;j<6;j++)//for loop for the contents of the array
				{
					System.out.print(seats[i][j]+"\t");
				}
				System.out.println("\n");
			}
			options();
		}

		else if(options == 5)//Prints the cost of a seat
		{
			System.out.println("Seat cost = "+cost);
			options();
		}

		else if(options == 6)//Prints the ticket with the name, seat and the cost on it
		{
			ticket();
		}

		else if(options == 7)//prints out message
		{
			System.out.println(" ");
			System.out.println("+------------------------------------------------------+");//A thank you message the user gets is they enter 7
			System.out.println("|--------- Thank you for using this Program -----------|");
			System.out.println("|----------------------- Good bye ---------------------|");
			System.out.println("+------------------------------------------------------+");
			System.out.println(" ");
		}
		else//prints out if, the option != 1-7
		{
			System.out.println("Sorry that is not an option please try again");//Gets the user to reenter the options until he/she enters 1-7
			options();
		}
	}

//************************************** --BOOKING-- ********************************************//

	static void booking()
	{
		String name="";

		System.out.println("\t1\t2\t3\t4\t5\t6\n");//number for the column
		for(int i=0;i<30;i++)//for loop for the index
		{
			System.out.print((i+1+"\t"));//number for row
			for(int j=0;j<6;j++)//for loop for the contents of the array
			{
				System.out.print(seats[i][j]+"\t");//prints out the 2D array
			}
			System.out.println("\n");
		}

		if(1<=seats_left && 1>=1)//if there are still seats left (1-180 seats)
		{
			System.out.println("Please enter your name please : ");
			name=Keyboard.readString();

			for(int i=0;i<1;i++)//repeats until the user get a free seat
			{
				for(int j=0;j<1;j++)
				{
					System.out.println("Which seat do you want to book ? : ");
					System.out.print("Row : ");//for the row
					R=Keyboard.readInt();

					System.out.println("\n");

					if(R>=1&&R<=30)//to make sure that the user enters in a number between 1-30 for row
					{

					}
					else
					{
						System.out.println("Sorry this is not an option please pick again\n");//if they dont enter in 1-30
						j--;
					}
				}

				for(int x=0;x<1;x++)
				{
					System.out.print("Column (A=1,B=2,C=3,D=4,E=5,F=6): ");//for the column
					C=Keyboard.readInt();

					System.out.println("\n");

					if(C>=1&&C<=6)//to make sure that the user enters in a number between 1-6 for column
					{

					}

					else
					{
						System.out.println("Sorry this is not an option please pick again\n");//if they dont enter in 1-6
						x--;
					}
				}

				System.out.println("\n\n");

				//if the seat is free put the user name in the array
				if(seats[R-1][C-1]=="A" || seats[R-1][C-1]=="B" || seats[R-1][C-1]=="C" || seats[R-1][C-1]=="D" || seats[R-1][C-1]=="E" || seats[R-1][C-1]=="F")
				{
					System.out.println("\nYou have booked seat : "+R+seats[R-1][C-1]);
					System.out.println("In row "+R+" column "+C+"\nCost : "+cost);
					seats[R-1][C-1]=name;//puts the name in the 2D array
					seats_left--;//take 1 seat away
				}
				else
				{
					System.out.println("Sorry, but that seat is taken");//if the seat is taking
					i--;
				}
			}
		}

		else//if there are 0 seats left
		{
			System.out.println("Sorry there are "+seats_left+" seats left on the plane");//if there are no seats on the plane
			System.out.println("Sorry but this flight is booked");
			booking();
		}

			options();
	}

//************************************* --CANCEL-- *********************************************//

	static void cancel()
	{
		String name_2="";
		System.out.println("Please enter your name : ");//ask for the name
		name_2=Keyboard.readString();//read in the name


		for(int j=0;j<1;j++)
		{
			System.out.print("Row : ");//for row
			R=Keyboard.readInt();

			System.out.println("\n");

			if(R>=1&&R<=30)//to make sure that the user enters in a number between 1-30 for row
			{

			}
			else
			{
				System.out.println("Sorry this is not an option please pick again\n");//if they dont enter in 1-30
				j--;
			}
		}

		for(int x=0;x<1;x++)
		{
			System.out.print("Column (A=1,B=2,C=3,D=4,E=5,F=6): ");//for the column
			C=Keyboard.readInt();

			System.out.println("\n");

			if(C>=1&&C<=6)//to make sure that the user enters in a number between 1-6 for column
			{

			}

			else
			{
				System.out.println("Sorry this is not an option please pick again\n");//to make sure that the user enters in a number between 1-6 for column
				x--;
			}
		}


		if(name_2.equalsIgnoreCase(seats[R-1][C-1]))
		{
			System.out.println("\nYour seat "+R+seats_2[R-1][C-1]+" will now be canceled, for "+name_2);
			seats[R-1][C-1]=seats_2[R-1][C-1];//makes the array go back to original
			seats_left++;//adds 1 to seat
		}
		else
		{
			System.out.println("\nSorry the name "+name_2+" is not on this flight");//if the name is not in the array
		}
		options();
	}

//*********************************** --TICKET-- *************************************************//

	static void ticket()
	{
		String name_3="";
		System.out.println("Please enter your name please : ");//ask for name
		name_3=Keyboard.readString();//reads in name

		for(int j=0;j<1;j++)
		{
			System.out.print("Row : ");//for the row
			R=Keyboard.readInt();

			System.out.println("\n");

			if(R>=1&&R<=30)//to make sure that the user enters in a number between 1-30 for row
			{

			}
			else
			{
				System.out.println("Sorry this is not an option please pick again\n");//if they dont enter in 1-30
				j--;
			}
		}

		for(int x=0;x<1;x++)
		{
			System.out.print("Column (A=1,B=2,C=3,D=4,E=5,F=6): ");//for the column
			C=Keyboard.readInt();

			System.out.println("\n");

			if(C>=1&&C<=6)//to make sure that the user enters in a number between 1-6 for column
			{

			}

			else
			{
				System.out.println("Sorry this is not an option please pick again\n");//to make sure that the user enters in a number between 1-6 for column
				x--;
			}
		}

		if(name_3.equalsIgnoreCase(seats[R-1][C-1]))//if name is in the array print ticket
		{
			System.out.println("+------------------------------------------------------+");
			System.out.println("|------ Name : "+name_3+" \t------  Seat : "+R+seats_2[R-1][C-1]+" -------------|");
			System.out.println("|-------------------- Cost : "+cost+" ----------------------|");
			System.out.println("+------------------------------------------------------+");
		}
		else
		{
			System.out.println("Sorry we don't have the name "+name_3+" in are System");//if the name is not in the array
		}
		options();
	}

}