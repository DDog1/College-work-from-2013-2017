// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListReferenceBased implements ListInterface {
  // reference to linked list of items
  private Node head;
  private int numItems; // number of items in list

  public ListReferenceBased() {
	  head = null;
	  numItems = 0;
  }  // end default constructor

  public boolean isEmpty() {

	  return (numItems == 0);
  }  // end isEmpty

  public int size() {
	  return numItems;

  }  // end size

  private Node find(int index) {
  // --------------------------------------------------
  // Locates a specified node in a linked list.
  // Precondition: index is the number of the desired
  // node. Assumes that 1 <= index <= numItems+1
  // Postcondition: Returns a reference to the desired
  // node.
  // --------------------------------------------------

  		Node curr = head;
  		for(int i=1;i<index;i++)
  		{
			curr = curr.getNext();
		}
		return curr;

  } // end find

  public Object get(int index)
                throws ListIndexOutOfBoundsException {

		if (index < 1 || index > numItems+1)
			throw new ListIndexOutOfBoundsException("Index is out of List bounds");
		else
			{
				Node n = find(index);
				return n.getItem();
			}

  } // end get

  public void add(int index, Object item)
                  throws ListIndexOutOfBoundsException {


		Node newNode = new Node(item);

		Node prev = find(index-1);
		Node curr = prev.getNext();

		newNode.setNext(curr);
		prev.setNext(newNode);
  }  // end add

  public void remove(int index)
                   throws ListIndexOutOfBoundsException {
  }   // end remove

  public void removeAll() {
    // setting head to null causes list to be
    // unreachable and thus marked for garbage
    // collection

    head = null;
  } // end removeAll
} // end ListReferenceBased