/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : Login									*/
/*	Task : 3-4												*/
/*	Description : Login part two with ok and cancel button	*/
/************************************************************/

import javax.swing.*;
//import java.awt.*;

class Login extends JFrame
{
	public static void main(String[]args)
	{
		Login login = new Login();
	}//End of main

	Login()
	{
		super("Login");	//Just setting the title and size of the window
		setVisible(true);
		setSize(220,180);
		setLocation(100,300);
		//setResizable(false);

		JPanel panel = new JPanel();

		//User login
		JLabel Usr = new JLabel("User Name");
		panel.add(Usr);

		JTextField user = new JTextField(10);
		panel.add(user);

		//Password login
		JLabel Password = new JLabel("Password");
		panel.add(Password);

		JPasswordField pass = new JPasswordField(10);
		panel.add(pass);


		//Buttons added in
		JButton leftButton = new JButton("OK");
		panel.add(leftButton);

		JButton rightButton = new JButton("CANCEL");
		panel.add(rightButton);

		getContentPane().add(panel);
	}
}//End of class