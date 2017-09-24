import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class ImageAppear extends JFrame implements ActionListener
{
	JButton button_1 = new JButton("real");
	JPanel panel = new JPanel();
	ImageIcon happyImage = new ImageIcon("");

	public ImageAppear()
	{
		button_1.addActionListener(this);
		panel.add(button_1);

		getContentPane().add(button_1);
		setSize(400,400);
		setVisible(true);
	}

	public static void main(String[]args)
	{
		ImageAppear button = new ImageAppear();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button_1)
		{
			button_1.setIcon(happyImage);
			button_1.setText("");
		}
		validate();
	}
}