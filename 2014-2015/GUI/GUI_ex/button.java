import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class button extends JFrame implements ActionListener
{

	JLabel label = new JLabel();


	public button()
	{
		super("Button!");
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();

		Icon bugIcon = new ImageIcon("bug1.gif");
		JButton mybutton = new JButton("Button 1", bugIcon);
		mybutton.addActionListener(this);
		panel.add(mybutton);

		JButton mybutton2 = new JButton("Button 2");
		mybutton2.addActionListener(this);
		panel.add(mybutton2);

		JButton mybutton3 = new JButton("Button 3");
		mybutton3.addActionListener(this);
		panel.add(mybutton3);

		panel.add(label);

		Font newfont = new Font("Ariel", Font.ITALIC, 14);

		mybutton2.setFont(newfont);

		contentPane.add(panel);

		setSize(200,200);
		setVisible(true);

		}

		public static void main(String[]args)
		{
		button myFrame = new button();
		myFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		}

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
}//end of class
