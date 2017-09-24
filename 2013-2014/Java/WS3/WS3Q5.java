/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 March 2014 */
/* Program Name: WS3Q5.java */
/* */
/* Description: Prints out an 2D array that has random numbers */
/*
/* */
/***************************************************************************/

class WS3Q5
{
	public static void main(String[]args)
	{
		int [][] twodarray= new int [10][10];
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				twodarray[i][i]=(int)((Math.random()*20)+1);//random numbers between 1 to 20
				System.out.print(twodarray[i][i]+"\t");
			}
			System.out.println();
		}
	}//end of main
}//end of class