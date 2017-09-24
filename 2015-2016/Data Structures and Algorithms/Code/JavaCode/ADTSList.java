class ADTSList implements DListInterface
{
	Node head;
	Node tail;
	int numItems=1;
	public boolean isEmpty()
	{
		if(numItems==0)
		{
			return true;
		}
		else
		return false;
	}
	public int size()
	{
		return numItems;
	}
	public Node find(int index)
	{
		Node curr = head;
		for(int i=1; i<index; i++)
		{
			curr = curr.getNext();
		}
		return curr;
	}
	public void add(int index, Object item) throws ListIndexOutOfBoundsException
	{

		Node newNode = new Node(item);
		if(numItems == 0)//Empty list
		{
			head = newNode;
			tail = newNode;
		}
		else if(numItems+1 == index && !isEmpty())//inserting  at the end of the list
		{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		else
		{
			Node curr= find(index);
			newNode.setNext(curr);
			newNode.setPrev(curr.getPrev());
			curr.setPrev(newNode);
			newNode.getPrev().setNext(newNode);
			numItems++;
		}
	}
	public void remove(int index) throws ListIndexOutOfBoundsException
	{

	}
	public Object get(int index) throws ListIndexOutOfBoundsException
	{
		return null;
	}
	public void removeAll()
	{
		head = null;
		tail = null;
		numItems =0;
	}
}