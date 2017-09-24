class ADTDList implements DListInterface
{

	Node head;
	Node tail;
	int numItems;
	// list operations:
	public boolean isEmpty()
	{
		return (numItems==0);

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

		if (isEmpty())//empty list
		{
			head = newNode;
			tail = newNode;
			numItems++;
		}
		else if (index == 1)
		{
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
			numItems++;

		}
		else if(numItems+1 == index && !isEmpty())//inserting at the end of the list
		{
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			numItems++;

		}
		else
		{
			Node curr = find(index);
			newNode.setNext(curr);
			newNode.setPrev(curr.getPrev());
			curr.setPrev(newNode);
			newNode.getPrev().setNext(newNode);
			numItems++;
		}


	}

	public void displayHead2Tail()
	{
		Node curr = head;
		while(curr!=null)
		{
			String x;
			x=(String)(curr.getItem());
			System.out.println("User : "+x+"\t\t");
			curr = curr.getNext();
		}


	}
	public void displayTail2Head()
		{
			Node curr = tail;
			while(curr!=null)
			{
				System.out.println(((Integer)(curr.getItem())).intValue());
				curr = curr.getPrev();
			}


	}
	public void remove(int index) throws ListIndexOutOfBoundsException
	{
		if (index < 1 || index > numItems)
		{
			throw new ListIndexOutOfBoundsException("Index Out of Bounds on remove!");
		}
		else if (index == 1)
		{
			head = head.getNext();
			numItems--;
		}
		else if (index == numItems)
		{
			//remove from tail
			tail = tail.getPrev();
			tail.setNext(null);
			numItems--;
		}
		else
		{
			//general case
			Node curr = find(index);
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
			numItems--;
		}
	}
	public Object get(int index) throws ListIndexOutOfBoundsException
	{
		Node curr = find(index);
		String x;
		x=(String)(curr.getItem());

		return x;
	}
	public void removeAll()
	{
		head = null;
		tail = null;
		numItems = 0;
	}
}