class Temp {
	public static void main(String args[])
	{

		int [] temp;

		//double [] temp = new double[10];

		//for (int i=0; i < temp.length; i++)
			//temp[i] = Math.random()*10+30;

		//forward
		for(int i=0; i < temp.length; i++)
			System.out.println(temp[i]);

		System.out.println();

		//backward
		for(int i=temp.length-1; i >= 0; i--)
			System.out.println(temp[i]);
	}
}
