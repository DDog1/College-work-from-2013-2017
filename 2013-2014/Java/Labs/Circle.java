class Circle
{
	private Point centre;
	private double radius;

	public Circle()
	{
		centre = new Point();
		radius = 1;
	}

	public Circle(double x, double y, double r)
	{
		centre = new Point(x,y);
		radius = r;
	}

	public Circle(Point p, double r)
	{
		centre = p;
		radius = r;
	}

	public double getArea()
	{
		double area = 3.14*radius*radius;
		return area;
	}

	public double getCircumference()
	{
		double circumference = 2*3.14*radius;
		return circumference;
	}

}