class TestDList
{
	public static void main(String [] args)
	{
		ADTSList dList = new ADTSList();

		dList.add(1, new Integer(5));
		//dList.add(2, new Integer(10));

		System.out.println(dList.isEmpty());
		System.out.println(dList.size());
	}
}