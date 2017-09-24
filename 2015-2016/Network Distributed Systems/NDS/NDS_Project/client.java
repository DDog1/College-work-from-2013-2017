import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class client extends JFrame implements ActionListener
{
	Container c = getContentPane();
	JPanel p = new JPanel();
	JTextField chat = new JTextField("test",20);
	JLabel message = new JLabel("Message");
	JTextField yourMessage = new JTextField("test",10);
	JButton send = new JButton("Send");
	String temp="";

	public static void main(String[]args)
	{
		client GUI = new client();
	}

	client()
	{
		super("Client");
		setSize(300, 350);
		setVisible(true);
		setLocation(300,100);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//Item in the menu bar
		JMenu OptionsMenu = new JMenu("Options");
		viewMenuBar.add(OptionsMenu);

		//Items with in the help Item
		JMenuItem HelpMenuItem = new JMenuItem("Help Topics");
		OptionsMenu.add(HelpMenuItem);

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		JMenuItem TechMenuItem = new JMenuItem("Technical Support");
		OptionsMenu.add(TechMenuItem);

		JMenuItem UpdateMenuItem = new JMenuItem("Check for Updates");
		OptionsMenu.add(UpdateMenuItem);

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		JMenuItem TipMenuItem = new JMenuItem("Tip of the Day");
		OptionsMenu.add(TipMenuItem);

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		JMenuItem AboutMenuItem = new JMenuItem("About TextPad");
		OptionsMenu.add(AboutMenuItem);

//*************************************************************
		JMenu ViewMenu = new JMenu("View");
		viewMenuBar.add(ViewMenu);

		JMenu ColourMenuItem = new JMenu("Colour");
		ViewMenu.add(ColourMenuItem);

		JMenuItem DefaultMenuItem = new JMenuItem("Default");
		ColourMenuItem.add(DefaultMenuItem);
		DefaultMenuItem.addActionListener(this);

		JMenuItem BlackMenuItem = new JMenuItem("Black");
		ColourMenuItem.add(BlackMenuItem);
		BlackMenuItem.addActionListener(this);
//*************************************************************

		setJMenuBar(viewMenuBar);


		//Order
		//Chat log goes here
		//Label with message
		//TextField with user message
		//Button with Send
		chat.setEditable(false);//user cant edit chat log
		chat.setPreferredSize(new Dimension(320,200));//set the size of the chat log area
		send.setMnemonic(KeyEvent.VK_ENTER);//Shortcut: Alt + Enter
		send.addActionListener(this);
		p.add(chat);
		p.add(message);
		p.add(yourMessage);
		p.add(send);
		c.add(p);


		revalidate();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Default"))
		{
			p.setBackground(Color.gray);
			chat.setForeground(Color.black);
			chat.setBackground(Color.white);
			message.setForeground(Color.black);
			yourMessage.setForeground(Color.black);
			yourMessage.setBackground(Color.white);
			send.setForeground(Color.black);
			send.setBackground(Color.blue);
			System.out.println("Colour");
		}
		if (e.getActionCommand().equals("Black"))
		{
			p.setBackground(Color.black);
			chat.setForeground(Color.green);
			chat.setBackground(Color.black);
			message.setForeground(Color.green);
			yourMessage.setForeground(Color.green);
			yourMessage.setBackground(Color.black);
			send.setForeground(Color.green);
			send.setBackground(Color.black);
			System.out.println("Black");
		}
		if (e.getActionCommand().equals("Send"))
		{
			String message = yourMessage.getText();
			temp += yourMessage.getText();
			chat.setText(temp);
			System.out.println("Send working\nMessage sent : "+message);
		}

		if (e.getActionCommand().equals(EXIT_ON_CLOSE))
		{
			int result = JOptionPane.showConfirmDialog((Component) e.getSource(),
			"Close this application?");
			if (result == JOptionPane.YES_OPTION)
			{
			  System.exit(0);
			}
			else if (result == JOptionPane.NO_OPTION)
			{
			  System.out.println("Do nothing");
			}
		}


		String text = JOptionPane.showInputDialog((Component) e.getSource(), "What is your name?");

		if (text != null && !text.equals(""))
		{
		  JOptionPane.showMessageDialog((Component) e.getSource(), "Hello " + text);
		}
		//revalidate();
	}
}