/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 February 2014 */
/* Program Name: counties2.java */
/* */
/* Description: Prints out the county when the area code is entered*/
/*
/* */
/***************************************************************************/

class counties2
	{
		public static void main (String[]args)
			{
				int area;
				String area1=("Dublin"), area2=("Westmeath"), area3=("Cork"), area4=("Donegal");//string

				do{//start of the do while loop
					System.out.println("Please enter the area code you are looking for:");
					System.out.println("Enter 0 to exit");
					area=Keyboard.readInt();

					switch(area)//switch
						{
							case 1: System.out.println(area1); break;
							case 44: System.out.println(area2); break;
							case 21: System.out.println(area3); break;
							case 74: System.out.println(area4); break;
							case 0: System.out.println("Goodbye"); break;
							default: System.out.println("Sorry we are not sure what you are looking for");
						}//end switch
				}while(area!=0);//end of the do while loop
			}//end main

	}//end class