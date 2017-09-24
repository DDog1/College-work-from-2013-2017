/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : Myframe									*/
/*	Task : 2-1												*/
/*	Description : Makes a blank frame						*/
/************************************************************/

import javax.swing.*;

class Myframe extends JFrame
{
	public static void main(String[]args)
	{
		Myframe frame1 = new Myframe("First Java GUI Window");//Frame being called
		//frame1.setSize(440,380);
		//frame1.setLocation(100,300);
		//frame1.setResizable(false);
	}//End of main

	public Myframe(String myTitle)//Just shows a blank window
	{
		super(myTitle);	//Sets the title
		setVisible(true);//Makes it visible to see on the frame
		setSize(440,380);//Sets the size of the frame
		setLocation(100,300);//Sets the location of the frame
		setResizable(false);//Sets the resize to false so u can't resize
	}
}//End of class