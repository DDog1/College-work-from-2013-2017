class Maximum
{
	public static void main (String args[])
	{
		int [] a = new int[10];
		for (int i=0;i<a.length;i++)
		{
			a[i] = (int) (Math.random()*10);
			System.out.println(a[i]);
		}
		int m = max(a);
		System.out.println("The max is: " + m);
		printArray(a);

		m = min(a);
		System.out.println("The min is: " + m);
		printArray(a);


		int total = sum(a);
		System.out.println("The total is: " + total);
		printArray(a);


		double avg = average(a);
		System.out.println("The average is: " + avg);
		printArray(a);

		int rand = (int)(Math.random()*10);
		int index = search(a,rand);
		System.out.println("The number " + rand + " was found at index " + index);
		printArray(a);
	}

	public static int max(int[] arrayIn)
	{
		int max = arrayIn[0];
		for(int i=1;i<arrayIn.length;i++) {
			if(arrayIn[i]>max) {
				max = arrayIn[i];
			}
		}

		arrayIn[0] = (int)(Math.random()*10);
		return max;
	}

	public static int min(int[] arrayIn)
		{
			int min = arrayIn[0];
			for(int i=1;i<arrayIn.length;i++) {
				if(arrayIn[i]<min) {
					min = arrayIn[i];
				}
			}
			arrayIn[0] = (int)(Math.random()*10);
			return min;
	}

	private static int sum(int[] arrayIn)
	{
		arrayIn[0] = (int)(Math.random()*10);
		int total = 0;
			for(int i=0;i<arrayIn.length;i++) {
				total = total + arrayIn[i];
			}
			return total;
	}
	private static double average(int[] arrayIn)
		{
			arrayIn[0] = (int)(Math.random()*10);
			int total = 0;
			for(int i=0;i<arrayIn.length;i++) {
				total = total + arrayIn[i];
			}
			return (double)total/(double)arrayIn.length;
	}

	private static int search(int[] arrayIn, int valueIn) {
		int index = -1;
		arrayIn[0] = (int)(Math.random()*10);
		for(int i=0; i<arrayIn.length;i++) {
			if(arrayIn[i]==valueIn) {
				index=i;
			}
		}
		return index;
	}

	private static void printArray(int [] arrayIn)
	{
		for (int i=0;i<arrayIn.length;i++)
				{
					System.out.println(arrayIn[i]);
		}
	}
}