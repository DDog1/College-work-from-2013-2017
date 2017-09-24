/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 February 2014 */
/* Program Name: counties4.java */
/* */
/* Description: Prints out the county or the area code for that area */
/*
/* */
/***************************************************************************/

class counties4
	{
		public static void main (String[]args)
			{
				int ans;
				System.out.println("+----------------------+-+");//open messages
				System.out.println("|Code for County press |1|");
				System.out.println("+----------------------+-+");
				System.out.println("|County for code press |2|");
				System.out.println("+----------------------+-+");
				System.out.println("");
				ans=Keyboard.readInt();

				if(ans==1)
				{
					getCodeForCounty();//gets the code for the county
				}
				if(ans==2)
				{
					getCountyForCode();//gets the county for the code
				}
			}//end main




static void getCodeForCounty()
	{
			int area;
				String area1=("Dublin"), area2=("Westmeath"), area3=("Cork"), area4=("Donegal");//string

				do{//start of the do while loop
					System.out.println("Please enter the area code you are looking for:");
					System.out.println("Enter 0 to exit");
					area=Keyboard.readInt();
					System.out.println("");

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
}


static void getCountyForCode()
	{
		String area;
		String area1=("Dublin"), area2=("Westmeath"), area3=("Cork"), area4=("Donegal"), area5=("q");//string

			do{//start of the do while loop

				System.out.println("Please enter the county you are looking for:");
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
}

}//end class