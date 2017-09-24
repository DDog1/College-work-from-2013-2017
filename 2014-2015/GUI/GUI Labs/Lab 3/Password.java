/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : Password									*/
/*	Task : 3-1												*/
/*	Description : Making a login with user and password area*/
/************************************************************/

import javax.swing.*;
//import java.awt.*;

class Password extends JFrame
{
	public static void main(String[]args)
	{
		Password login = new Password();
	}//End of main

	Password()
	{
		super("password");	//Just setting the title and size of the window
		setVisible(true);
		setSize(220,180);
		setLocation(100,300);
		//setResizable(false);

		JPanel panel = new JPanel();

		//User login label
		JLabel Usr = new JLabel("User Name");
		panel.add(Usr);

		//User login text field
		JTextField user = new JTextField(10);
		panel.add(user);

		//Password login label
		JLabel Password = new JLabel("Password");
		panel.add(Password);

		//Password login password field
		JPasswordField pass = new JPasswordField(10);
		panel.add(pass);

		getContentPane().add(panel);
	}
}//End of class