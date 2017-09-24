/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 March 2014 */
/* Program Name: WS3Q6.java */
/* */
/* Description: Prints out an 2D array and adds 1.0 to it */
/*
/* */
/***************************************************************************/

class WS3Q6
{
	public static void main(String[]args)
	{
		double [][] twodarray= new double [][]
		{
			{1.2,1.5,1.6},
			{1.7,3.0,3.5},
			{5.7,9.2,1.0}
		};
		for(int i=0;i<3;i++)//for loop for the index
		{
			for(int j=0;j<3;j++)//for loop for the contents of the array
			{
				twodarray[i][j]=twodarray[i][j]+1.0;
				System.out.print(twodarray[i][j]+", ");
			}
			System.out.println();
		}
	}//end of main
}//end of class