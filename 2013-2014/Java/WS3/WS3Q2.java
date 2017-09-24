/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 March 2014 */
/* Program Name: WS3Q2.java */
/* */
/* Description: Prints out the power of 0 to 64 with the power of 2 */
/*
/* */
/***************************************************************************/

class WS3Q2
{
	public static void main(String[]args)
	{
		long array[]=new long[64];//holds 0 to 64
		print(array);
	}//end of main

	public static void print(long[]array)
	{
		for(int i=0;i<array.length;i++)
		{
			array[i]=i;
			array[i]=(long)(Math.pow(array[i],2));//by the power of two
			System.out.println(array[i]);//prints out the array
		}
	}
}//end of class