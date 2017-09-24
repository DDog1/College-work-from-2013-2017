class Test
{
	public static void main(String[] args)
	{
		Pet p1,p2;
		p1 = new Pet();
		p2 = new Pet("Darren", 15);

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 1 \t: \t" + p1.getName()+"\t|");
		System.out.println("|Age of pet  1 \t: \t" + p1.getAge()+"\t|");
		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 2 \t: \t" + p2.getName()+"\t|");
		System.out.println("|Age of pet  2 \t: \t" + p2.getAge()+"\t|");
		System.out.println("+-------------------------------+");
	}
}