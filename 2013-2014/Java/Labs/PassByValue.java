class PassByValue
{
	public static void main(String args[])
	{
		int [] num = new int[1];
		num[0] = 5;
		System.out.println(num[0]);//what is printed?
		square(num);
		System.out.println(num[0]);//what is printed?
	}

	public static void square(int [] x)
	{
		x[0] = x[0] * x[0];
	}
}