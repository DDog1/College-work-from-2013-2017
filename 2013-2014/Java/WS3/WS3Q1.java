/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 March 2014 */
/* Program Name: WS3Q1.java */
/* */
/* Description: lets the user enter any size for the array the lets them put in any int in the arrry */
/*
/* */
/***************************************************************************/

class WS3Q1
{
	public static void main(String[]args)
	{
		int i;

		//user input

		System.out.println("Please enter the size you would like for your array:");
		i=Keyboard.readInt();

		int array[]=new int[i];

		System.out.println("Please enter an int you would like to be stored in the array:");

		input(array);
		print(array);
	}//end of main

	static void input(int[]array)//A method to input an int into the array
	{
		for(int i=0;i<array.length;i++)
		{
			array[i]=Keyboard.readInt();
		}
	}

	static void print(int[]array)//A method to print out the array
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+",");
		}
		System.out.println("");
	}
}//end of class