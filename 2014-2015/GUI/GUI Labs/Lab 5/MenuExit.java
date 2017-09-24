/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : MenuExit									*/
/*	Task : 5-2												*/
/*	Description : Makes the menu item exit exit when clicked*/
/************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MenuExit extends JFrame implements ActionListener
{
	public MenuExit()
	{
		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//An item for the menu bar
		JMenu FileMenu = new JMenu("File");
		viewMenuBar.add(FileMenu);

		//Items for the File item
		JMenuItem NewMenu = new JMenuItem("New");
		FileMenu.add(NewMenu);

		JMenuItem OpenMenu = new JMenuItem("Open");
		FileMenu.add(OpenMenu);

		JMenuItem ExitMenu = new JMenuItem("Exit");
		FileMenu.add(ExitMenu);

		//Adds the exit to action listener
		ExitMenu.addActionListener(this);

		setJMenuBar(viewMenuBar);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[]args)
	{
		MenuExit type1 = new MenuExit();
		type1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}//End of main

	public void actionPerformed(ActionEvent e)
	{
		String message = "";

		//lets check that a menu created the event
		if (e.getSource() instanceof JMenuItem)
		{
			if (e.getActionCommand().equals("Exit"))
			{
				System.exit(0);
			}
		}
	}
}//End of class