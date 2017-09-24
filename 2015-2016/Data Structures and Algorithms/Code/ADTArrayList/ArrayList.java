class ArrayList implements ListInterface
{
	private int max_size = 100;
	private int [] arrList = new int[max_size];
	private int numItems = 0;

	public boolean isEmpty()
	{
		if (numItems == 0)
			return true;
		else
			return false;
	}

	public int space()
	{
		int temp=(max_size-numItems);
		return test.space_left=temp;
	}

	public boolean isFull()
	{
		space();
		return (numItems == max_size);
	}

	public int size()
	{
		return numItems;
	}
	public void add(int index, int item)
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
	public int get(int index)
	                    throws ListIndexOutOfBoundsException
	{
		if (index >=1 && index <= numItems)
			return arrList[translate(index)];
		else if(numItems==0)
			return 0;
		else
			throw new ListIndexOutOfBoundsException("Requested index out of List bounds");
	}


	public void remove(int index)
	                     throws ListIndexOutOfBoundsException
	{
		if(arrList[translate(index)]!=0)
		{
			numItems--;
			arrList[translate(index)]=0;
		}
	}
  	public void removeAll()
  	{
		for (int i=numItems; i >= 100; i--)
		{
			arrList[translate(i-1)] =0;
		}
		numItems = 0;
	}

	private int translate(int index)
	{
		return index-1;
	}

}