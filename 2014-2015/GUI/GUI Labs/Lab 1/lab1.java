class lab1
{
	public static void main(String[]args)
	{
		Happy();
	}//End of main

	static void Happy()
	{
		boolean test=false;
		while(test==false)//While loop
		{
			char ans;

			System.out.println("Are you happy today? please enter Y/N");//Question asked
			ans=Keyboard.readChar();

			if(ans=='y' || ans=='Y')
			{
				for(int i=0;i<5;i++)//For loop
				{
					System.out.println("Me too :D");//Yes answer
				}
				test=true;
			}
			else
			{
				System.out.println("Cheer up!! :D");//No answer
			}
		}
	}
}