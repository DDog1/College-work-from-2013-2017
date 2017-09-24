class WS4Q1
{
	public static void main(String[]args)
	{
		int array[]=new int [100];
		fill_random(array);
		print_second(array);
		int result = sum_odd(array);
		System.out.println("The sum off all the indexes is "+result);
	}
	static int sum_odd(int[]array)
	{
		int sum=0;
			for(int i=0; i<array.length;i++)
			{

				if(i%2==1 )
				{
					sum+=array[i];

				}
			}
			return sum;
	}



	static void fill_random(int[]array)
	{

		for(int i=0; i<array.length;i++)
		{
			array[i]=(int)((Math.random()*10)+1);
		}

	}



	static void print_second(int[]array)
	{
			for(int i=0; i<array.length;i++)
			{

				if(i%2==1 )
				{
				System.out.println(i+" , "+array[i]);
				}
			}
	}
}