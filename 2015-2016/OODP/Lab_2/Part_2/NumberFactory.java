public class NumberFactory
{
	public NumberList getNumberList(String list)
	{
		int i = list.indexOf(".");
		String t = list;
		if(i!=-1)
		{
			return new DoubleList(list);
		}
		else if(t.contains("A"))
		{
			return new AlphaCharaterList(list);
		}
		else
		{
			return new IntList(list);
		}
	}
}