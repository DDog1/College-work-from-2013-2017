public class HorseShowAwardingBody extends AwardingBody
{
	public String message()
	{
		return "Congratulations	you are	a winner";
	}

	public Prize getPrize(int finishPosition)
	{
		if(finishPosition==1)
		{
			return new Ribbon();
		}
		else if(finishPosition==2)
		{
			return new Ribbon();
		}
		else
		{
			return new Ribbon();
		}
	}

}
