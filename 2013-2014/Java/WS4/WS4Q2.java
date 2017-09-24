class WS4Q2
{
	public static void main(String[]args)
	{
		int []javastudents= getExamMarks();

		results(javastudents);
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
	}
}