/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : Buttons									*/
/*	Task : 4-1												*/
/*	Description : Makes 3 buttons one with an Icon, one with*/
/*	font and one normal button								*/
/************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Buttons extends JFrame implements ActionListener
{
	JLabel label = new JLabel();
	public Buttons()
	{
		super("Buttons");//Sets the name and the size of the frame
		setSize(440,380);
		setVisible(true);

		Container c = getContentPane();//container

		JPanel p = new JPanel();//panel

		//Creating an Icon
		//first button Icon
		ImageIcon buttonIcon = new ImageIcon("Button_Image.jpg");

		//creating first button
		JButton firstButton = new JButton("Button 1", buttonIcon);
		firstButton.setIcon(buttonIcon);
		firstButton.addActionListener(this);

		JButton secondButton = new JButton("Button 2");
		secondButton.addActionListener(this);

		//creating fonts
		Font secondFont = new Font("Serif" , Font.ITALIC, 14);
		secondButton.setFont(secondFont);

		JButton thirdButton = new JButton ("Button 3");
		thirdButton.addActionListener(this);

		//Adds the buttons to the panel
		p.add(firstButton);
		p.add(secondButton);
		p.add(thirdButton);
		p.add(label);
		c.add(p);
	}

	public static void main(String [] args )
	{
		Buttons frame = new Buttons();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}//End of main

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Button 1"))
		{
			label.setText("Button 1");
		}

		else if (e.getActionCommand().equals("Button 2"))
		{
			label.setText("Button 2");
		}

		else if (e.getActionCommand().equals("Button 3"))
		{
			label.setText("Button 3");
		}
	}
}//End of class