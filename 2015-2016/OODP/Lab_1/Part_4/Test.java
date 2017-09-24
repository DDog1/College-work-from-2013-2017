class Test
{
	public static void main(String[] args)
	{
		Pet[] p = new Pet[5];
		p[0] = new Cat("Chris", 19);
		p[1] = new Dog("Darren", 21);
		p[2] = new Dog("PJ", 15);
		p[3] = new Cat("James", 14);
		p[4] = new Dog("Dina", 10);
		/*p2.setTricks("Sit","Run","Hop");
		p4.setTricks("Jump","Sit","Barke");*/
		p[0].setFood("Fish");
		p[1].setFood("Slop");
		p[2].setFood("Meat");
		p[3].setFood("Chunks");
		p[4].setFood("Treats");

		for(int i=0; i<=4; i++)
		{
			System.out.println("+-------------------------------+");
			System.out.println("|Name of pet 4 \t: \t" + p[i].getName()+"\t|");
			System.out.println("|Age of pet  4 \t: \t" + p[i].getAge()+"\t|");
			System.out.println("|Favourite food\t: \t" + p[i].getFood()+"\t|");
			p[i].feeding();
		}
		System.out.println("+-------------------------------+");
	}
}