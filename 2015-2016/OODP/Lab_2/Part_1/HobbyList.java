class HobbyList extends Hobby
{
	public static String[] Hobby = new String[10];

	public static void addHobby(int x, String hobby)
	{
		if (Hobby[0]==null)
		{
			Hobby[0]="";
			Hobby[1]="";
			Hobby[2]="";
			Hobby[3]="";
			Hobby[4]="";
			Hobby[5]="";
			Hobby[6]="";
			Hobby[7]="";
			Hobby[8]="";
			Hobby[9]="";
		}
		Hobby[x] = hobby;
	}

	public String getHobby(int i)
	{
		return Hobby[i];
	}

	public static void display()
	{
		for(int i=0; i <= 9; i++)
		{
			if (Hobby[i]!="")
			{
				System.out.println(Hobby[i]);
			}
		}
	}
}