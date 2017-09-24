class PassByReference
{
	public static void main(String args[])
	{
		int [] num = new int[5];
		num[0] = 0;
		num[1] = 1;
		num[2] = 2;
		num[3] = 3;
		num[4] = 4;
		for(int i=0;i<num.length;i++)
			System.out.println(num[i]);//what is printed?
		square(num);
		for(int i=0;i<num.length;i++)
			System.out.println(num[i]);//what is printed?
	}

	public static void square(int [] x)
	{
		for (int i=0; i < x.length;i++)
			x[i] = x[i] * x[i];
	}
}