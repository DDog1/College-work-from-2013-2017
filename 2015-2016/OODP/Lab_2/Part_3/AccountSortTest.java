public class AccountSortTest
{
	public static void main(String[]args)
	{
		String list1 = new String("C10001 C10002 C10003");
		String list2 = new String("I20001 I20002 I20003");

		AccountSort aSort = new AccountSort();

		aSort.getAccount(list1).display();

		System.out.println("");

		Account aSort2 = aSort.getAccount(list2);
		aSort2.display();
	}
}