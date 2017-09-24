/****************************************************************************/
/* Name: Darren Cosgrave */
/* Date: 14 February 2014 */
/* Program Name: WS2Q3.java */
/* */
/* Description: Prints out the array of temperatures and the moths */
/*
/* */
/***************************************************************************/

class WS2Q3
{
	public static void main(String[]args)
	{
		int i;
		double total=0;
		double average;

		double temp[]={1.2, 2.3, 8.6, 10.2, 15.7, 19.4, 20, 19.6, 14.2, 10.2, 8.4, 4.5};
		String mounths[]={"January","February","March","April","May","June","July","August","September","October","November","December"};


		for(i=0;i<12;i++)//prints out the months and temperatures
		{
			System.out.println(mounths[i]+" "+temp[i]);
			total=total+temp[i];//adds the temperatures

		}
		average=total/12;//divides the temperatures to get the average
		System.out.println("The average is "+average);
	}//end of main
}//end of class