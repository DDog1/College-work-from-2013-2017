class MethodExample
{
	public static void main (String args[])
	{
		double val = 3;
		double result;
		result = cube(val);

		System.out.println("The cube of " + val + " is " + cube(result));

		System.out.println("The sum of all integers between 10 and 20 is " + sum(10,20));
	}

	public static double cube(double x)
	{
		return x*x*x;
	}

	public static int sum(int num1, int num2)
	{
		int sum = 0;

		for (int i=num1; i<=num2;i++)
		{
			sum = sum + i;
		}

		return sum;

	}
}