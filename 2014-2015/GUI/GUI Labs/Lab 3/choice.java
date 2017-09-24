/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : choice									*/
/*	Task : 3-3												*/
/*	Description : Makes a multiple choice question with 	*/
/*	radio buttons											*/
/************************************************************/

import javax.swing.*;
import java.awt.*;

class choice extends JFrame
{
	public static void main(String[]args)
	{
		choice myChoice = new choice();
	}//End of main

	choice()
	{
		super("Choice");	//Just setting the title and size of the window
		setVisible(true);
		setSize(440,380);
		setLocation(100,300);

		Container c = getContentPane();

		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();
		JLabel label = new JLabel("What is the capital of Ireland?");
		panel.add(label);
		c.add(panel);

		ButtonGroup group = new ButtonGroup();

		//Makes the radio buttons
		JRadioButton button_1 = new JRadioButton("Cork",true);
		JRadioButton button_2 = new JRadioButton("Dublin");
		JRadioButton button_3 = new JRadioButton("Tralee");
		JRadioButton button_4 = new JRadioButton("Donegal");

		panel = new JPanel();

		//Adds the buttons to the panel
		panel.add(button_1);
		panel.add(button_2);
		panel.add(button_3);
		panel.add(button_4);

		//Adds the panel to the container
		c.add(panel);

		//Adds the buttons to a group so that you can only pick one at a time
		group.add(button_1);
		group.add(button_2);
		group.add(button_3);
		group.add(button_4);

		//Makes the frame fit in all of the items
		pack();
	}
}//End of class