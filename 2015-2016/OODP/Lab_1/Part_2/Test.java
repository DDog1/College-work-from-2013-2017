class Test
{
	public static void main(String[] args)
	{
		Pet p1,p2,p3,p4;
		p1 = new Pet();
		p2 = new Pet("Darren");
		p3 = new Pet(15);
		p4 = new Pet("James", 14);

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 1 \t: \t" + p1.getName()+"\t|\tBlank");
		System.out.println("|Age of pet  1 \t: \t" + p1.getAge()+"\t|");

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 2 \t: \t" + p2.getName()+"\t|\tName only");
		System.out.println("|Age of pet  2 \t: \t" + p2.getAge()+"\t|");

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 3 \t: \t" + p3.getName()+"\t|\tAge only");
		System.out.println("|Age of pet  3 \t: \t" + p3.getAge()+"\t|");

		System.out.println("+-------------------------------+");
		System.out.println("|Name of pet 4 \t: \t" + p4.getName()+"\t|\tName and Age");
		System.out.println("|Age of pet  4 \t: \t" + p4.getAge()+"\t|");
		System.out.println("+-------------------------------+");
	}
}