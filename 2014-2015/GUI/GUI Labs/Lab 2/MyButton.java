/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : MyButton									*/
/*	Task : 2-3												*/
/*	Description : Makes three buttons add font to the last 	*/
/*	two and enabled is false on the last button				*/
/************************************************************/

import javax.swing.*;
import java.awt.*;

class MyButton extends JFrame
{
	public static void main(String[]args)
	{
		MyButton frame1 = new MyButton("First Java GUI Window");//Frame being called
		//frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//frame1.setSize(440,380);
		//frame1.setLocation(100,300);
		//frame1.setResizable(false);
	}//End of main

	public MyButton(String myTitle)
	{
		super(myTitle);	//Just setting the title and size of the window
		setVisible(true);
		setSize(440,380);
		setLocation(100,300);
		setResizable(false);

		JPanel panel = new JPanel();

		//Making the buttons and adding them to the panel
		JButton leftButton = new JButton("My first Button");
		panel.add(leftButton);

		JButton rightButton = new JButton("My second Button");
		panel.add(rightButton);

		JButton lastButton = new JButton("My third Button");
		panel.add(lastButton);

		//Making the fancy font for the two buttons and setting them to the buttons in question
		Font fancyFont = new Font("Serif" , Font.ITALIC, 14);
		lastButton.setFont(fancyFont);

		Font fancyFont1 = new Font("Arial" , Font.BOLD, 12);
		leftButton.setFont(fancyFont1);

		//Setting the buttons to true or false and adding the panel to the contentpane
		leftButton.setEnabled(true);
		rightButton.setEnabled(true);
		lastButton.setEnabled(false);
		getContentPane().add(panel);
	}
}//End of class