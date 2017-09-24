class CoordinateGeometry
{
	public static void main(String args[])
	{
		Point p1 = new Point();
		Point p2 = new Point(4,5);

		Circle c1 = new Circle();
		Circle c2 = new Circle(2,2,5);
		Circle c3 = new Circle(p2,10);

		System.out.println("The area of c3 is " + c3.getArea());


	}
}