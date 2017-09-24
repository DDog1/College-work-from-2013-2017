/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : choice									*/
/*	Task : 4-3												*/
/*	Description : Taking from last weeks lab, adding in		*/
/*	action listener that show the right answer when clicked	*/
/*	and get a wrong message if wrong						*/
/************************************************************/

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

class choice extends JFrame implements ActionListener
{
	JRadioButton button_1,button_2,button_3,button_4;
	choice()
	{
		super("Choice");//Sets the name and size of the frame
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
		JRadioButton button_1 = new JRadioButton("Cork",true);
		JRadioButton button_2 = new JRadioButton("Dublin");
		button_2.setActionCommand("button_2");
		JRadioButton button_3 = new JRadioButton("Tralee");
		JRadioButton button_4 = new JRadioButton("Donegal");

		panel = new JPanel();

		//Adds the buttons to the action listener
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);

		//Adds the buttons to the panel
		panel.add(button_1);
		panel.add(button_2);
		panel.add(button_3);
		panel.add(button_4);

		c.add(panel);

		//Adds the buttons in to the group
		group.add(button_1);
		group.add(button_2);
		group.add(button_3);
		group.add(button_4);

		pack();
	}

	public static void main(String[]args)
	{
		choice myChoice = new choice();
	}//End of main

	public void actionPerformed(ActionEvent e)
	{
		String message = "";

		//Object source = e.getItemSelectable();

		if (e.getActionCommand().equals("button_2"))
			message = "Correct";

		else
			message = "Sorry , the capital of Ireland is Dublin";


		JOptionPane.showMessageDialog(null, message, "Answer", JOptionPane.ERROR_MESSAGE);
	}
}//End of class