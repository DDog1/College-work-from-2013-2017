class Hobby
{
	private String hobbyName;

	Hobby()
	{
		hobbyName = "";
	}

	Hobby(String hobby)
	{
		hobbyName = hobby;
	}

	public void setHobby(String hobby)
	{
		hobbyName = hobby;
	}

	public String getHobby(String hobby)
	{
		return hobbyName;
	}
}