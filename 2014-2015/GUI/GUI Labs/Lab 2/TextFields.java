/****************************************************************/
/*	Name : Darren Cosgrave										*/
/*	Date : 2 / November / 2014									*/
/*	Program name : TextFields									*/
/*	Task : 2-4													*/
/*	Description : Makes two text fields with one set to false	*/
/****************************************************************/

import javax.swing.*;
import java.awt.*;
class TextFields extends JFrame
{
	public TextFields()
	{
		super("Text Fields");
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();

		//Instantiate a new TextField
		JTextField tf = new JTextField("This is my first text area");
		//add the text field to the panel
		panel.add(tf);

		Font font = new Font("Arial", Font.ITALIC, 14);
		tf.setFont(font);

		//Second text field
		JTextField tf2 = new JTextField("This is my second text area");
		panel.add(tf2);
		tf2.setEditable(false);

		contentPane.add(panel);

		//set size of windows properties
		setSize(440, 380);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		JFrame frame = new TextFields();//Frame being called
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}//End of main
}//End of class