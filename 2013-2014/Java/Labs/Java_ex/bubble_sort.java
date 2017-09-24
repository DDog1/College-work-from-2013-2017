class bubble_sort
{
	public static void main (String[]args)
	{

	int [] array = {2,1,4,3,5};
	int swap;

		for(int i = 0; i < array.length-1; i++)
		{

			if( array[i] > array[i+1])
			{
				swap = array[i+1];
				array[i+1] = array[i];
				array[i] = swap;

			}

		System.out.println(array[i]);
		}

	}

}