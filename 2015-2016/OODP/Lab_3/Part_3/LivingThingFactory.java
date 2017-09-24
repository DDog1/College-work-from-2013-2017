public class LivingThingFactory implements EarthThingsAbstractFactory
{
	int random = (int )(Math.random() * 2 + 1);

	public Thing getThing()
	{
		if(random==1)
		{
			return new Dog("Dog","Bark");
		}
		else
		{
			return new Bird("Bird","Fly");
		}
	}
}
