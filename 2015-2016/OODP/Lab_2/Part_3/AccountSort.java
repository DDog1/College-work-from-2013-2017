public class AccountSort
{
	public Account getAccount(String list)
	{
		int i = list.indexOf(".");
		String t = list;
		String value = list;
		if(value.contains("C"))
		{
			return new C(list);
		}
		else if(value.contains("I"))
		{
			return new I(list);
		}
		else
		{
			return null;
		}
	}
}