class Test
{
	public static void main(String[] args)
	{
		Dog p1,p2,p3,p4;
		p1 = new Dog();
		p2 = new Dog("Darren");
		p3 = new Dog(15);
		p4 = new Dog("James", 14);
		p2.setTricks("Sit","Run","Hop");
		p4.setTricks("Jump","Sit","Barke");

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 1 \t: \t" + p1.getName()+"\t|");
		System.out.println("|Age of pet  1 \t: \t" + p1.getAge()+"\t|");
		if(p1.getFull()==true)
		{
			System.out.println("|Pet 1 tricks \t: \t" + p4.getTrick1()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick2()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick3()+"\t|");
		}

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 2 \t: \t" + p2.getName()+"\t|");
		System.out.println("|Age of pet  2 \t: \t" + p2.getAge()+"\t|");
		if(p2.getFull()==true)
		{
			System.out.println("|Pet 2 tricks \t: \t" + p4.getTrick1()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick2()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick3()+"\t|");
		}

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 3 \t: \t" + p3.getName()+"\t|");
		System.out.println("|Age of pet  3 \t: \t" + p3.getAge()+"\t|");
		if(p3.getFull()==true)
		{
			System.out.println("|Pet 3 tricks \t: \t" + p4.getTrick1()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick2()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick3()+"\t|");
		}

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 4 \t: \t" + p4.getName()+"\t|");
		System.out.println("|Age of pet  4 \t: \t" + p4.getAge()+"\t|");
		if(p4.getFull()==true)
		{
			System.out.println("|Pet 4 tricks \t: \t" + p4.getTrick1()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick2()+"\t|");
			System.out.println("|\t\t\t" + p4.getTrick3()+"\t|");
		}
		System.out.println("+-------------------------------+");
	}
}