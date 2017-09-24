public class AtheleticAwardingBody extends AwardingBody
{
	public String message()
	{
		return "Congratulations	you are	a winner";
	}

	public Prize getPrize(int finishPosition)
	{
		if(finishPosition==1)
		{
			return new Medal();
		}
		else if(finishPosition==2)
		{
		    return new Medal();
		}
		else
		{
			return new Medal();
		}
	}

}
