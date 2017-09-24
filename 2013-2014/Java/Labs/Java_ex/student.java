class student
{
	private String name;
	private String s_n;
	private String course;
	private int gpa;


	public student(String n, String s, String c, int g)
	{
		name=n;
		s_n=s;
		course=c;
		gpa=g;
	}

	public String getName()
	{
		return name;
	}

	public String getStudent_Number()
	{
		return s_n;
	}

	public void display()
	{
		System.out.print("Name: " +name+ "\t");
		System.out.print("Student Number: " +s_n+ "\t");
		System.out.print("Course: " +course+ "\n");
		System.out.print("GPA: " +gpa+ "\n");
	}

}