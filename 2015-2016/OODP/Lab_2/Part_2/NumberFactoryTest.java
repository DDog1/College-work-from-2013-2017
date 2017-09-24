public class NumberFactoryTest
{
	public static void main(String[]args)
	{
		String list1 = new String("1 2 3 4 5 6 7 8 9 10");
		String list2 = new String("1.1 2.1 3.1 4.1 5.1 6.1 7.1 8.1 9.1 10.1");
		String list3 = new String("A B C D E F");

		NumberFactory nfactory = new NumberFactory();

		nfactory.getNumberList(list1).display();

		System.out.println("");

		NumberList numberlist2 = nfactory.getNumberList(list2);
		numberlist2.display();

		System.out.println("");
		System.out.println("Sum of list 2 : " + numberlist2.sum());

		System.out.println("");

		NumberList numberlist3 = nfactory.getNumberList(list3);
		numberlist3.display();
	}
}