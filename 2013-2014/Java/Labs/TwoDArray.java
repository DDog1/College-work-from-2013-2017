class TwoDArray {

	public static void main(String args[])
	{
		int [][] twodArray = new int[3][4];

		for(int i=0;i<twodArray.length;i++)//loop through the rows
		{
			for(int j=0;j<twodArray[0].length;j++)//loop through the columns
			{
				twodArray[i][j] = (int)(Math.random()*10);
				System.out.print(twodArray[i][j]+" ");
			}
			System.out.println();

		}

		for(int i=0;i<twodArray.length*twodArray[0].length;i++)
		{
			int r=0;
			int c=0;

			r = i/twodArray[0].length;
			c = i-(r*twodArray[0].length);

			System.out.println(twodArray[r][c]);
		}




	}
}