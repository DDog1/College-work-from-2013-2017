public class NonLivingThingFactory implements EarthThingsAbstractFactory
{
	int random = (int )(Math.random() * 2 + 1);

	public Thing getThing()
	{
		if(random==1)
		{
			return new Guitar("Guitar","Play");
		}
		else
		{
			return new Clock("Clock","Tic-Toc");
		}
	}
}
