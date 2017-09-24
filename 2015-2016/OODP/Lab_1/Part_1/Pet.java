class Pet
{
	private String Name;
	private int Age;

	Pet()
	{
		Name = null;
		Age = 0;
	}

	Pet(String Name_input, int Age_input)
	{
		Name = Name_input;
		Age = Age_input;
	}

	public void setName(String Name_input)
	{
		Name = Name_input;
	}

	public String getName()
	{
		return Name;
	}

	public void setAge(int Age_input)
	{
		Age = Age_input;
	}

	public int getAge()
	{
		return Age;
	}
}