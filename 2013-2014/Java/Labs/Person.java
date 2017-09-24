class Person {

	private String name;
	private int age;
	private double height;
	private double weight;

	public Person(int a, double h, double w)
	{
		age = a;
		height = h;
		weight = w;
	}


	public Person(String n,int a, double h, double w)
	{
		name = n;
		age = a;
		height = h;
		weight = w;
	}

	public int getAge() //access mthod for age
	{
		return age;
	}

	public boolean setAge(int a) //modifier method for age
	{
		if (age > 0)
		{
			age = a;
			return true;
		}
		return false;
	}


	public boolean validateName(String n)
	{
		//check to make sure name is valid
		return false;
	}
	public boolean setName(String n)
	{

		if(validateName(n))
		{
			name = n;
			return true;
		}
		return false;
	}




	public double findBMI()
	{
		return weight/(height*height);

	}
	public void sleep()
	{
		age = age+1;
	}
	public void eat()
	{
		weight = weight+1;
	}

	public void run()
	{
		weight = weight-1;
	}

	public void printDetails()
	{
		System.out.println("My age is " + age);
		System.out.println("My height is " + height);
		System.out.println("My weight is " + weight);
	}
}