class game
{
	public static void main(String[]args)
	{
		int r;
		String x;
		char y;
		int wins = 0;
		int losses = 0;
		int ties = 0;

		System.out.print("Please enter the amount of rounds you would like to do :");
		r=Keyboard.readInt();

		for(int i=0;i<r;i++)
		{
			int AI;
			AI=(int)(Math.random()*3);

			if(AI==0)
			{
				x="rock";
			}

			if(AI==1)
			{
				x="paper";
			}

			if(AI==2)
			{
				x="scissors";
			}

			System.out.print("\nPlease pick rock, paper or scissors [r, p, s]: ");
			y=Keyboard.readChar();
			System.out.println();
			if(y=='r' || y=='s' || y=='p')
			{
				if(AI==0 && y=='r')
				{
					System.out.println("Rock Rock = Tie");
					ties++;
				}

				if(AI==1 && y=='r')
				{
					System.out.println("Paper Rock = Lose");
					losses++;
				}

				if(AI==2 && y=='r')
				{
					System.out.println("Scissors Rock = Win");
					wins++;
				}

					if(AI==0 && y=='p')
					{
						System.out.println("Rock Paper = Win");
						wins++;
					}

					if(AI==1 && y=='p')
					{
						System.out.println("Paper Paper = Tie");
						ties++;
					}

					if(AI==2 && y=='p')
					{
						System.out.println("Scissors Paper = Lose");
						losses++;
					}

						if(AI==0 && y=='s')
						{
							System.out.println("Rock Scissors = Lose");
							losses++;
						}

						if(AI==1 && y=='s')
						{
							System.out.println("Paper Scissors = Win");
							wins++;
						}

						if(AI==2 && y=='s')
						{
							System.out.println("Scissors Scissors = Tie");
							ties++;
						}
			}
			else
			{
				System.out.println("Please pick r for rock, p for paper or s for scissors only");
				i--;
			}
		}
		int total=wins+losses+ties;
		double win=(wins*100)/r;
		double loss=(losses*100)/r;
		double tie=(ties*100)/r;
		System.out.println("\n\nYou've Won "+wins+" games. "+win+"% \n\nYou've lost "+losses+" games. "+loss+"% \n\nYou've tied "+ties+" games. "+tie+"% \n\nCongrats!");
	}
}