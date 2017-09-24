import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener
{
	JComboBox combo1,combo2;
	JTextField txtfld;
	JLabel label;
	String posi[] = {"First[1]","Second[2]","Third[3]"};
	String award[] = {"Atheletics","HorseShow"};

	public Gui()
	{
		gui();
	}

	public void gui()
	{
		Container ContentPane = getContentPane();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		txtfld = new JTextField (20);

		combo1 = new JComboBox(posi);
		combo2 = new JComboBox(award);

		label = new JLabel("YOU ARE ");

        combo1.addActionListener(this);
        combo2.addActionListener(this);

        panel.add(txtfld);
        panel.add(label);
        panel2.add(combo1);
        panel2.add(combo2);
        ContentPane.add(panel);
        ContentPane.add(panel2,BorderLayout.SOUTH);
		setSize(400,300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0)
	{

	}

	public static void main(String[] args)
	{
		new Gui();
	}
}
