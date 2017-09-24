// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface ListInterface {
  public boolean isEmpty();
  public int size();
  public void add(int index, int item)
                  throws ListIndexOutOfBoundsException,
                         ListException;
  public int get(int index)
                    throws ListIndexOutOfBoundsException;
  public void remove(int index)
                     throws ListIndexOutOfBoundsException;
  public void removeAll();
}  // end ListInterface
