/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : list										*/
/*	Task : 3-2												*/
/*	Description : Makes a zoo list							*/
/************************************************************/

import javax.swing.*;
//import java.awt.*;

class list extends JFrame
{
	public static void main(String[]args)
	{
		list list_1 = new list();
	}//End of main

	public list()
	{
		super("My List for the zoo");	//Just setting the title and size of the window
		setSize(400,300);
		setVisible(true);
		setLocation(100,300);

		JPanel panel = new JPanel();

		//Container c = getContentPane();

		//Array with animals in it
		String zoo[] ={"Lion", "Monkey", "Elephant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};

		JList<String> list_1 = new JList<String>(zoo);
		panel.add(list_1);
		JScrollPane pane = new JScrollPane(list_1);
		panel.add(pane);

		getContentPane().add(pane);
	}
}//End of class