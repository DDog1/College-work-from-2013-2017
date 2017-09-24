class Pet
{
	private String Name;
	private int Age;
	private String favFood;

	Pet()
	{
		Name = null;
		Age = 0;
		favFood = null;
	}

	Pet(String Name_input)
	{
		this.Name = Name_input;
		Age = 0;
		favFood = null;
	}

	Pet(int Age_input)
	{
		Name = null;
		this.Age = Age_input;
		favFood = null;
	}

	Pet(String Name_input, int Age_input)
	{
		this.Name = Name_input;
		this.Age = Age_input;
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

	public void setFood(String food)
	{
		favFood = food;
	}

	public String getFood()
	{
		return favFood;
	}

	public void feeding()
	{
		System.out.println("|Feeding pet\t\t\t|");
	}
}