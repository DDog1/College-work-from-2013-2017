class Dog extends Pet
{
	private String[] Tricks = new String[3];
	private boolean full = false;

	Dog()
	{

	}

	Dog(String Name_input)
	{
		super(Name_input);
	}

	Dog(int Age_input)
	{
		super(Age_input);
	}

	Dog(String Name_input, int Age_input)
	{
		super(Name_input, Age_input);
	}

	public void setTricks(String trick_1, String trick_2, String trick_3)
	{
		Tricks[0] = trick_1;
		Tricks[1] = trick_2;
		Tricks[2] = trick_3;
		full = true;
	}

	public boolean getFull()
	{
		return full;
	}

	public void setTrick1(String t)
	{
		Tricks[0] = t;
	}

	public String getTrick1()
	{
		return Tricks[0];
	}

	public void setTrick2(String t)
	{
		Tricks[1] = t;
	}

	public String getTrick2()
	{
		return Tricks[1];
	}

	public void setTrick3(String t)
	{
		Tricks[2] = t;
	}

	public String getTrick3()
	{
		return Tricks[2];
	}

	public void feeding()
	{
		System.out.println("|Feeding dog\t\t\t|");
	}
}