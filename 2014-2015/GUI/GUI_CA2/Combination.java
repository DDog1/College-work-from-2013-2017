import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;

public class Combination extends JInternalFrame implements MouseListener
{
	static JLabel[] ArrayLabel = new JLabel[9];//Creates the 9 buttons
	static int combo[] = {1, 4, 8, 2};//assigns the 4 values for the combination

	static int amount = 0;

	public Combination()
	{
		super("Password Game");//Names the frame
		Container c = getContentPane();

		JPanel panel = new JPanel(new GridLayout(0,3,5,5));//Makes space around the button and puts it in a row
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);//Makes the border color blue
		panel.setBorder(BorderFactory.createEmptyBorder(
												5, //top
												5, //left
												5, //bottom
												5) //right
												);

		for(int i=0; i<9; i++) //makes buttons 1-9
		{
			ArrayLabel[i] = new JLabel();//Makes the button
			ArrayLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
			ArrayLabel[i].setVerticalAlignment(SwingConstants.CENTER);
			ArrayLabel[i].setText(String.valueOf(i+1));//Sets the text to i+1 so that it will go 1, 2, 3...
			ArrayLabel[i].setBorder(border);//Makes the border blue
			ArrayLabel[i].addMouseListener(this);//Adds the button to the mouse listener
			panel.add(ArrayLabel[i]);
		}
		c.add(panel);//Adds the c to panel
	}//close constructor

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void mousePressed(MouseEvent e)
	{

	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource() instanceof JLabel)
		{
			combo[amount] = Integer.parseInt(((JLabel)e.getSource()).getText());

			((JLabel)e.getSource()).setText(" ");
		}

		if(amount == 3 && combo[0]==1 && combo[1]==4 && combo[2]==8 && combo[3]==2 )//Has to match this code
		{
			JOptionPane.showMessageDialog(null, "Correct Pin Entered", "Proceed", JOptionPane.PLAIN_MESSAGE);
			amount = -1;

			for(int i=0; i<9; i++) //Resets the lable with a number
			{
				ArrayLabel[i].setText(String.valueOf(i+1));
			}
		}
		else if(amount == 3)
		{
			JOptionPane.showMessageDialog(null, "Incorrect Pin", "Locked", JOptionPane.ERROR_MESSAGE);
			amount = -1;

			for(int i=0; i<9; i++) //Resets the lable with a number
			{
				ArrayLabel[i].setText(String.valueOf(i+1));
			}
		}
		amount++;
	}
}