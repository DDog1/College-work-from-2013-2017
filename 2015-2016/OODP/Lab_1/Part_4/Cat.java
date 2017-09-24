class Cat extends Pet
{
	Cat()
	{

	}

	Cat(String Name_input)
	{
		super(Name_input);
	}

	Cat(int Age_input)
	{
		super(Age_input);
	}

	Cat(String Name_input, int Age_input)
	{
		super(Name_input, Age_input);
	}
	public void feeding()
	{
		System.out.println("|Feeding cat\t\t\t|");
	}
}