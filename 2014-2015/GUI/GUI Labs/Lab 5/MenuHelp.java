/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : MenuHelp									*/
/*	Task : 5-1												*/
/*	Description : Makes a menu bar in the frame				*/
/************************************************************/

import javax.swing.*;
import java.awt.*;

class MenuHelp extends JFrame
{
	public MenuHelp()
	{
		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//Item in the menu bar
		JMenu HelpMenu = new JMenu("Help");
		viewMenuBar.add(HelpMenu);

		//Items with in the help Item
		JMenuItem HelpMenuItem = new JMenuItem("Help Topics");
		HelpMenu.add(HelpMenuItem);

		//Adds in a line to space it out
		HelpMenu.addSeparator();

		JMenuItem TechMenuItem = new JMenuItem("Technical Support");
		HelpMenu.add(TechMenuItem);

		JMenuItem FAQMenuItem = new JMenuItem("Frequently Asked Questions");
		HelpMenu.add(FAQMenuItem);

		JMenuItem WebMenuItem = new JMenuItem("TextPad on the Web");
		HelpMenu.add(WebMenuItem);

		JMenuItem LicenseMenuItem = new JMenuItem("Update License");
		HelpMenu.add(LicenseMenuItem);

		JMenuItem InfoMenuItem = new JMenuItem("Ordering Information");
		HelpMenu.add(InfoMenuItem);

		JMenuItem UpdateMenuItem = new JMenuItem("Check for Updates");
		HelpMenu.add(UpdateMenuItem);

		//Adds in a line to space it out
		HelpMenu.addSeparator();

		JMenuItem TipMenuItem = new JMenuItem("Tip of the Day");
		HelpMenu.add(TipMenuItem);

		//Adds in a line to space it out
		HelpMenu.addSeparator();

		JMenuItem AboutMenuItem = new JMenuItem("About TextPad");
		HelpMenu.add(AboutMenuItem);

		setJMenuBar(viewMenuBar);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[]args)
	{
		MenuHelp type1 = new MenuHelp();
	}//End of main
}//End of class