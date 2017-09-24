class ArraySearching
{
	public static void main(String args[])
	{
		int [] num = new int[9];
		num[0] = 3;
		num[1] = 6;
		num[2] = 9;
		num[3] = 12;
		num[4] = 15;
		num[5] = 18;
		num[6] = 21;
		num[7] = 24;
		num[8] = 27;

		int [] indexes = linearSearch(num,0);

		int index = binarySearch(num, 27);

		System.out.print("The value 27 is at index ");

		System.out.println(index);

		/*
		int i=0;
		while(i<indexes.length)
		{
			if (indexes[i] != -1)
			{
				System.out.println(indexes[i]);
				i++;
			}
			else
				i=indexes.length;
		}

		*/
		/*for(int i=0;i<indexes.length;i++)
		{
			if (indexes[i] != -1)
				System.out.println(indexes[i]);
			else
				i=indexes.length;

		}*/

	}

	public static int[] linearSearch(int [] values,int sk)
	{
		int [] skArray = new int[values.length];
		int j=0;
		for (int i=0; i < values.length;i++)
		{
			if (values[i] == sk)
			{
				skArray[j] = i;
				j++;
			}
		}
		if (j < skArray.length)
			skArray[j] = -1;

		return skArray;
	}

	public static int binarySearch(int [] values,int sk)
	{
		int low=0;
		int high=values.length-1;
		int mid = (low+high)/2;

		int comparisons = 0;
		while(low < high)
		{
			comparisons++;
			if (values[mid]==sk)
			{
				System.out.println("The number of comparisons performed was " + comparisons);
				return mid;
			}
			else if(values[mid] > sk) //lower half
			{
				high=mid-1;
				mid = (low+high)/2;
			}
			else
			{
				low=mid+1;
				mid = (low+high)/2;
			}
		}

		System.out.println("The number of comparisons performed was " + comparisons);

		return -1;

	}




}