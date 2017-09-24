/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 14 February 2014 */
/* Program Name: WS2Q5.java */
/* */
/* Description: Prints out the array of random numbers for the lotto */
/*
/* */
/***************************************************************************/

class WS2Q5
{
	public static int[]array=new int[6];//array declared

	public static void main(String[]args)
	{
		int array[]= new int[6];
		array();
	}//end of main


	public static void array()//array method
	{
		for(int i=0;i<6;i++)
		{
			array[i]=(int)(Math.random()*10);//random generate lotto numbers
		}
		print(array);
	}//end of array

	public static void print(int[]array)//print method
	{
		for(int i=0;i<6;i++)
		{
			System.out.println(array[i]);
		}
	}//end of print

}//end of class