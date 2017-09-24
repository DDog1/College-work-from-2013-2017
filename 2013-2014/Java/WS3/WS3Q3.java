/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 7 March 2014 */
/* Program Name: WS3Q3.java */
/* */
/* Description: Prints the array out in reverse */
/*
/* */
/***************************************************************************/

class WS3Q3
{
	public static void main(String[]args)
	{
		String array[]={"s","i","x","n","a","t","i","o","n","s"};//string type array
		System.out.println("Printed out normal");
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]);
		}
		System.out.println("\n");
		reverseArray(array);
	}//end of main

	static void reverseArray(String[]array)
	{
		int i=array.length;
		System.out.println("Printed out reversed");
		do
		{
			i--;
			System.out.print(array[i]);
		}
		while(i!=0);

		System.out.println("\n");
	}
}//end of class