import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class jListView extends JFrame implements ActionListener
{
	static JTextField textfield1 = new JTextField(10);
	static JTextField textfield2 = new JTextField(10);
	Container c = getContentPane();
	JPanel p = new JPanel();
	JLabel label1 = new JLabel("Enter in a hobby");
	JList list = new JList(temp);
	JLabel label2 = new JLabel("Enter index");
	JButton button1 = new JButton("Add");
	JButton button2 = new JButton("Refresh");
	static String[] temp = HobbyList.Hobby;

	public static void main(String[]args)
	{
		jListView GUI = new jListView();
	}

	jListView()
	{
		super("jListView");
		setVisible(true);
		setSize(200,200);
		setLocation(300,100);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		list.setPreferredSize(new Dimension(100,25));

		p.setLayout(new FlowLayout());

		//Sets the space around the JPanel to 5 all round
		p.setBorder(BorderFactory.createEmptyBorder(
										5, //top
										5, //left
										5, //bottom
										5) //right
								);

		p.add(list);
		p.add(label1);
		p.add(textfield1);
		p.add(label2);
		p.add(textfield2);

		p.add(button1);
		p.add(button2);
		button1.addActionListener(this);
		button1.setActionCommand("Add");
		button2.addActionListener(this);
		button2.setActionCommand("Refresh");

		c.add(p);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Add"))
		{
			String text = textfield1.getText();
			int index = Integer.parseInt(textfield2.getText());
			HobbyList.addHobby(index, text);
			HobbyList.display();

			p.remove(list);
			p.remove(label1);
			p.remove(textfield1);
			p.remove(label2);
			p.remove(textfield2);
			p.remove(button1);
			p.remove(button2);
			c.remove(p);
			list = new JList(temp);
			p.add(list);
			p.add(label1);
			p.add(textfield1);
			p.add(label2);
			p.add(textfield2);
			p.add(button1);
			p.add(button2);
			c.add(p);
		}
		if (e.getActionCommand().equals("Refresh"))
		{
			revalidate();
			HobbyList.display();
		}
	}
}