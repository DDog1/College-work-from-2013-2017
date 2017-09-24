class WS4Q3
{
	public static void main(String[]args)
	{
		int []javastudents= getExamMarks();

		results(javastudents);
		selectionSort(javastudents);
		highest_mark(javastudents);
		average(javastudents);
		median(javastudents);
	}

	static int[] getExamMarks()
	{
		int x;
		int []getExamMarks;

		System.out.println("How many exams do you have ? : ");
		x=Keyboard.readInt();
		getExamMarks=new int[x];

		System.out.println("Please enter your exam mark : ");

		for(int i=0;i<getExamMarks.length;i++)
		{
			getExamMarks[i]=Keyboard.readInt();
			if(getExamMarks[i]<=0 || getExamMarks[i]>=100)
			{
				System.out.println("Sorry you can have this "+getExamMarks[i]+" as a value");
				i--;
			}
		}
		return getExamMarks;
	}

	static void results(int[]javastudents)
	{
		for(int i=0;i<javastudents.length;i++)
		{
			System.out.print(javastudents[i]+", ");
		}
		System.out.println();
	}




	static void selectionSort(int[]array)
	{
		for(int j=0;j<array.length-1;j++)
		{
			int smallest=array[j];
			int smallest_index=j;
			for(int i=j+1;i<array.length;i++)
			{
				if(array[i]<smallest)
				{
					smallest=array[i];
					smallest_index=i;
				}
			}
			int temp;
			temp=array[j];
			array[j]=smallest;
			array[smallest_index]=temp;
		}
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+", ");
		}
		System.out.println();
	}



	static void highest_mark(int[]array)
	{
		int highest_mark=0;
		for(int i=0;i<array.length;i++)
		{
			highest_mark=array[i];
		}
		System.out.println("\nHighest mark = "+highest_mark);
	}


	static void average(int[]array)
	{
		int average;
		int total=0;
		for(int i=0;i<array.length;i++)
		{
			total=total+array[i];
		}
		average=total/array.length;
		System.out.println("Average = "+average);
	}


	static void median(int[]array)
	{
		int median;
		int total=0;
		for(int i=0;i<array.length;i++)
		{
			total=i;
		}
		total++;
		median=total/2;
		System.out.println("Median = "+array[median]);
	}



}