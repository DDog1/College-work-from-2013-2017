class arraytest
{
	public static void main (String[]args)
	{
		int [] array = new int [5];
		int swap;
		array[0] = 2;
		array[1] = 4;
		array[2] = 1;
		array[3] = 3;
		array[4] = 5;

        for(int i=0; i < array.length; i++)
 		{
			System.out.print(array[i]);
		}
		System.out.println();
 		for(int i=0; i < array.length; i++)
 		{
			for(int j=1; j < array.length; j++)
			{
				if(array[j-1] > array[j])
				{
					//swap the elements!
					swap = array[j-1];
					array[j-1] = array[j];
					array[j] = swap;
                 }
             }
         }
        for(int i=0; i < array.length; i++)
 		{
			System.out.print(array[i]);
		}
		System.out.println();
	}
}
