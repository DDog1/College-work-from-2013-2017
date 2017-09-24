class ArrayList implements Listlnterface
{
	private static int max_size = 100;
	private static int [] arrList = new int[max_size];
	private static int numItems = 0;

	public static boolean isEmpty()
	{
		if (numItems >= 0 && numItems <= max_size)
			return test.empty=true;
			
		else
			return test.empty=false;
	}

	public static int space()
	{
		int temp=(max_size-numItems);
		return test.space_left=temp;
	}
	
	public static boolean isFull()
	{
		if(numItems == max_size)
			return test.full=true;
		
		else
		{
			space();
			return test.full=false;
			
		}
	}

	public static int size()
	{		
		return test.size=numItems;
	}
	public static void add(int index, int item)
	                  throws ListIndexOutOfBoundsException,
	                         ListException
	{
		//check bounds
		//make room for new item
		//insert new item
		//increase the size var

		//assume index is valid
		if (isFull())
		{
			throw new ListException("List is full!");
		}
		//check bounds
		else if (index >=1 && index <= numItems+1)
		{
			//make room for new item
			for (int i=numItems; i >= index; i--)
			{
				arrList[translate(i+1)] = arrList[translate(i)];
			}
			//insert new item
			arrList[translate(index)] = item;
			numItems++;
		}
		else
			throw new ListIndexOutOfBoundsException("Requested index out of List bounds");


	}
	public static int get(int index)
	                    throws ListIndexOutOfBoundsException
	{
		if (index >=1 && index <= numItems)
			return test.index_value=arrList[translate(index)];
		else
			throw new ListIndexOutOfBoundsException("Requested index out of List bounds");
	}
	public static void remove(int index)
	                     throws ListIndexOutOfBoundsException
	{
		if(arrList[translate(index)]!=0)
		numItems--;
		arrList[translate(index)]=0;
	}
  	public static void removeAll()
  	{
  		for (int i=numItems; i >= 100; i--)
		{
			arrList[translate(i-1)] =0;
		}
		numItems = 0;
	}

	private static int translate(int index)
	{
		return index-1;
	}

}