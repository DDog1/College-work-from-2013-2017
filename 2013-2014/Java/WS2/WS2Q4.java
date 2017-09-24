/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 14 February 2014 */
/* Program Name: WS2Q4.java */
/* */
/* Description: Prints out the array of random numbers for the lotto */
/*
/* */
/***************************************************************************/

class WS2Q4
{
	public static void main(String[]args)
	{
		int i;
		int math;
		int array[]=new int[6];//array

		System.out.println("Your lotto numbers are.... ");

		for(i=0;i<6;i++)//gives the arrays a random number from 1-9
		{
			array[i] = (int)(Math.random()*10);
			System.out.print(array[i]+", ");
		}


		System.out.println("");
	}//end of main
}//end of class