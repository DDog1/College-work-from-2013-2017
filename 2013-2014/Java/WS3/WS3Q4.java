/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 14 February 2014 */
/* Program Name: WS3Q4.java */
/* */
/* Description: the program askes the user to enter in the size of the array they would like and fills it with random numbers */
/*
/* */
/***************************************************************************/

class WS3Q4
{
	public static void main(String[]args)
	{
		int i;

		System.out.println("Please enter the size of the array you would like to have:");

		i=Keyboard.readInt();

		int array[]=new int[i];

		for(i=0;i<array.length;i++)
		{
			array[i]=(int)(Math.random()*21);//puts a random number in the array from 0 to 20
		}

		line(array);
	}//end of main

	static void line(int[]array)
	{
		for(int i=0;i<array.length;i++)
		{
			for (int j=0;j<array[i];j++)
			{
				System.out.print("*");//used to print out the *
			}
			System.out.println(" ");
		}
	}
}//end of class