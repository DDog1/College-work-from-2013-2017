/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 14 February 2014 */
/* Program Name: WS2Q2.java */
/* */
/* Description: Prints out the array of 10 each time as 2+8=10 4+6=10 */
/*
/* */
/***************************************************************************/

class WS2Q2
{
	public static void main(String[]args)
	{
		int i;
		int arrayA[]={2,4,6,8};
		int arrayB[]={8,6,4,2};

		for(i=0;i<4;i++)//prints out the arrays
		{
			System.out.println(arrayA[i] + arrayB[i]);
		}
	}//end of main
}//end of class