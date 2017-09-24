/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 February 2014 */
/* Program Name: counties3.java */
/* */
/* Description: Prints out the area code when a county is entered*/
/*
/* */
/***************************************************************************/

class counties3
	{
		public static void main (String[]args)
			{
				String area;
				String area1=("Dublin"), area2=("Westmeath"), area3=("Cork"), area4=("Donegal"), area5=("q");//string

					do{//start of the do while loop

					System.out.println("Please enter the area code you are looking for:");
					System.out.println("Enter Q to exit");
					area=Keyboard.readString();
					System.out.println("");
							if(area.equals(area1))
							{
								System.out.println("The area code is 1");
								System.out.println("");
							}
							else if(area.equals(area2))
							{
								System.out.println("The area code is 44");
								System.out.println("");
							}
							else if(area.equals(area3))
							{
								System.out.println("The area code is 21");
								System.out.println("");
							}
							else if(area.equals(area4))
							{
								System.out.println("The area code is 74");
								System.out.println("");
							}
							else if(area.equals(area5))
							{
								System.out.println("Goodbye");
								System.out.println("");
							}
							else
							{
								System.out.println("Sorry we are not sure what you are looking for");
								System.out.println("");
							}
				}while((area.equals(area1)) || (area.equals(area2)) || (area.equals(area3)) || (area.equals(area4)));//end of the do while loop
			}//end main

	}//end class