class OO
{
	public static void main(String args[])
	{
		Person joe = new Person(25,1.6,70);
		Person paul = new Person("paul",50,1.8,80);
		Person jane =  new Person("jane",35,1.5,60);

		//jane.height = 1.7; //illeagal because height is private

		jane.setAge(36);

		jane.eat();
		jane.printDetails();
		jane.run();
		jane.run();
		jane.printDetails();

		paul.run();

		paul.printDetails();

		System.out.println("Your BMI is: " + paul.findBMI());

	}
}