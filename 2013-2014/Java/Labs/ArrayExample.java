class ArrayExample
{
	public static void main(String args[])
	{
		//int arrayEg[6]; //C syntax, not good for java
		int arrayEg[] = new int[10];
		int arrayCopy[] = new int[10];
		for (int i=0; i < 10; i++)
		{
			arrayEg[i] = (int)(Math.random()*10);
			arrayCopy[i] = arrayEg[i];
			System.out.println(arrayEg[i]);
		}

		bubbleSort(arrayEg);
		System.out.println("The sorted array is: ");

		for (int i=0; i < 10; i++)
		{
			System.out.println(arrayEg[i]);
		}

		selectionSort(arrayCopy);
		System.out.println("The sorted array is: ");

		for (int i=0; i < 10; i++)
		{
			System.out.println(arrayEg[i]);
		}
	}

	public static void selectionSort(int [] array)
	{
		int count = 0;
		for (int j=0; j< array.length-1; j++)
		{
			int smallest = array[j];
			int smallest_index = j;
			for(int i=j+1;i < array.length; i++)
			{
				count++;
				if (array[i] < smallest)
				{
					smallest = array[i];
					smallest_index = i;
				}
			}

			int temp;
			temp = array[j];
			array[j] = smallest;
			array[smallest_index] = temp;
		}
		System.out.println("Number of comparisons: "+count);

	}


	public static void bubbleSortBoolean(int [] array)
	{
		boolean sorted = false;
		int count = 0;
		for(int j=0; j< array.length-1 && !sorted; j++)
		{
			sorted = true;
			for(int i=0;i<array.length-1-j;i++)
			{
				int temp;
				count++;
				if(array[i] > array[i+1])
				{
					sorted = false;
					//swap them
					temp = array[i];
					array[i] = array[i+1];
					array[i+1]=temp;
				}
			}
		}
		System.out.println("Number of comparisons: "+count);
	}

	public static void bubbleSort(int [] array)
	{
			int count = 0;
			for(int j=0; j< array.length-1; j++)
			{
				for(int i=0;i<array.length-1-j;i++)
				{
					int temp;
					count++;
					if(array[i] > array[i+1])
					{
						//swap them
						temp = array[i];
						array[i] = array[i+1];
						array[i+1]=temp;
					}
				}
			}
			System.out.println("Number of comparisons: "+count);
	}




}