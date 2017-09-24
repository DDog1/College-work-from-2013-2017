/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : MyLabel									*/
/*	Task : 2-2												*/
/*	Description : Makes a frame with two labels				*/
/************************************************************/

import javax.swing.*;
import java.awt.*;

class MyLabel extends JFrame
{
	public static void main(String[]args)
	{
		MyLabel frame1 = new MyLabel("First Java GUI Window");//Frame being called
		//frame1.setSize(440,380);
		//frame1.setLocation(100,300);
		//frame1.setResizable(false);
	}//End of main

	public MyLabel(String myTitle)
	{
		super(myTitle);		//Just setting the title and size of the window
		setVisible(true);
		setSize(440,380);
		setLocation(100,300);
		setResizable(false);

		//Making a space in memory for the panel
		JPanel panel = new JPanel();

		//Making the two labels and adding them to the panel
		JLabel leftLabel = new JLabel("My first lable");
		panel.add(leftLabel);
		JLabel rightLabel = new JLabel("My second lable");
		panel.add(rightLabel);

		//Making the fancy font for the buttons and setting them to the buttons
		Font fancyFont = new Font("Arial" , Font.ITALIC, 14);
		leftLabel.setFont(fancyFont);
		Font fancyFont1 = new Font("Times" , Font.BOLD, 12);
		leftLabel.setFont(fancyFont1);

		//Adding the panel to the contentpane
		getContentPane().add(panel);
	}
}//End of class