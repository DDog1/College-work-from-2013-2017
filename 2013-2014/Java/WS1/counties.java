/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 February 2014 */
/* Program Name: counties.java */
/* */
/* Description: Prints out the county when a area code is entered then stops*/
/*
/* */
/***************************************************************************/

class counties
	{
		public static void main (String[]args)
			{
				int area;
				String area1=("Dublin"), area2=("Westmeath"), area3=("Cork"), area4=("Donegal");//string

				System.out.println("Please enter the area code you are looking for:");
				area=Keyboard.readInt();

				switch(area)//switch
					{
						case 1: System.out.println(area1); break;
						case 44: System.out.println(area2); break;
						case 21: System.out.println(area3); break;
						case 74: System.out.println(area4); break;
						default: System.out.println("Sorry we are not sure what you are looking for");
					}//end switch

			}//end main

	}//end class