/************************************************************/
/*	Name : Darren Cosgrave									*/
/*	Date : 2 / November / 2014								*/
/*	Program name : Animals									*/
/*	Task : 4-2												*/
/*	Description : Frame with an array that shows the index	*/
/************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Animals extends JFrame implements ListSelectionListener
{
	JList list;

	//Array with zoo animals
	String choices[] = {"Lion", "Monkey", "Elepant", "Kangaroo", "Polar Bear", "Penguin", "Ostrich"};

	Animals()
	{
		super("Animals");//Sets the name and size of the frame
		Container c = getContentPane();
		list = new JList(choices);
		list.addListSelectionListener(this);
		JScrollPane pane = new JScrollPane(list);
		c.add(pane);
		setSize(400,300);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		Animals myList = new Animals();
	}//End of main

	public void valueChanged(ListSelectionEvent e)
	{
		Object source = e.getSource();

		if (source == list)
		{
			int selectionNum = 0;
			String message = "The selected index is: ";
			selectionNum = list.getSelectedIndex();
			message = message + selectionNum;

			JOptionPane.showMessageDialog(null, message, "List Query", JOptionPane.ERROR_MESSAGE);
			message = "The selected index is: " + list.getSelectedValue();
			JOptionPane.showMessageDialog(null, message, "List Query", JOptionPane.ERROR_MESSAGE);
		}
	}
}//End of class