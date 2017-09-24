// ********************************************************
// Interface ListInterface for the ADT list.
// *********************************************************
public interface Listlnterface {
  public static boolean isEmpty() {
	return false;
}
  public static int size() {
	return 0;
}
  public static void add(int index, int item) 
                  throws ListIndexOutOfBoundsException,
                         ListException {
}
  public static int get(int index) 
                    throws ListIndexOutOfBoundsException {
	return 0;
}
  public static void remove(int index) 
                     throws ListIndexOutOfBoundsException {
}
  public static void removeAll() {
}
}  // end ListInterface
