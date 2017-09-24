/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 28 / November / 2014								*/
/*	Program name : CA2										*/
/*	Task : CA												*/
/*	Description : Frame with two internal frames inside and */
/*	get called when the select game_1 or game_2 is clicked.	*/
/*	One game is a pin or password crack game.				*/
/*	The other one is a shape game.							*/
/************************************************************/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CA2 extends JFrame implements ActionListener
{
	 JDesktopPane d = new JDesktopPane();//Makes the JDesktop

	public CA2()
	{
		super("CA2");//Sets the title of the JFrame
		Container c = getContentPane();//Makes the Container
		setVisible(true);//Lets you see the program
		setSize(500,500);//sets the size of the JFrame
		setLocation(400,100);//sets the location of the JFrame
		setResizable(true);//sets the resize to on or off for the JFrame
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel p = new JPanel();//Makes the JPanel

//******************************************************************//

		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//Item in the menu bar
		JMenu SelectMenu = new JMenu("Select");
		viewMenuBar.add(SelectMenu);

		//Items with in the Select Item
		JMenuItem Game_1 = new JMenuItem("Game 1");
		SelectMenu.add(Game_1);

		//Makes a shot cut for Game_1.. alt 1
		Game_1.setMnemonic(KeyEvent.VK_1);
		Game_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));

		//Adding Game_1 to the action command&listener
		Game_1.setActionCommand("Game 1");
		Game_1.addActionListener(this);

		//Adds in a line to space it out
		SelectMenu.addSeparator();

		JMenuItem Game_2 = new JMenuItem("Game 2");
		SelectMenu.add(Game_2);

		//Makes a shot cut for Game_2.. alt 2
		Game_2.setMnemonic(KeyEvent.VK_2);
		Game_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));

		//Adding Game_2 to the action command&listener
		Game_2.setActionCommand("Game 2");
		Game_2.addActionListener(this);

		//Adds in a line to space it out
		SelectMenu.addSeparator();

		//Adds in an Exit JMenu item
		JMenuItem ExitMenu = new JMenuItem("Exit");
		SelectMenu.add(ExitMenu);

		//Adding Exit to the action command&listener
		ExitMenu.setActionCommand("Exit");
		ExitMenu.addActionListener(this);

		//Makes a shot cut for Exit.. alt Q
		ExitMenu.setMnemonic(KeyEvent.VK_2);
		ExitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));

		setJMenuBar(viewMenuBar);
//******************************************************************//
	}

	public void Combination_Lock()
	{
		Combination f = new Combination();
		d.add(f);//Adds the game to the desktop
		f.setVisible(true);//Lets you see the program
		f.setResizable(true);//sets the resize to on or off
		f.setLocation(40,40);//sets the location
		f.setSize(300,300);//sets the size
		f.setClosable(true);//Lets the user close the internal frame
		f.setMaximizable(true);//Lets the user increase size of the internal frame
		f.setIconifiable(true);//Lets the user close the internal frame
		setContentPane(d);//Adds desktop to the content pane
		validate();
	}

	public void Three_language_shape()
	{
		TLS g = new TLS();
		d.add(g);//Adds the game to the desktop
		g.setVisible(true);//Lets you see the program
		g.setResizable(true);//sets the resize to on or off
		g.setLocation(20,20);//sets the location
		g.setSize(400,400);//sets the size
		g.setClosable(true);//Lets the user close the internal frame
		g.setMaximizable(true);//Lets the user increase size of the internal frame
		g.setIconifiable(true);//Lets the user close the internal frame
		setContentPane(d);//Adds desktop to the content pane
		validate();
	}

	public static void main(String[]args)
	{
		//Calls the main frame and show it
		CA2 run = new CA2();

		//Exits the JFrame when the close button on the top right is clicked
		run.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}//End of main

	public void actionPerformed(ActionEvent e)
	{
		//It runs the pin or password game when clicked
		if ("Game 1".equals(e.getActionCommand()))
		{
			Combination_Lock();
			//d.add(game1);
			//dispose();
		}

		//It runs the shape game when clicked
		else if ("Game 2".equals(e.getActionCommand()))
		{
			 Three_language_shape();
			//dispose();
		}

		//It closes the
		else if ("Exit".equals(e.getActionCommand()))
		{
			System.exit(0);
		}
	}

}//End of class