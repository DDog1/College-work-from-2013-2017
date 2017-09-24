import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.time.LocalTime;

class client extends JFrame implements ActionListener
{
	//Client
	static String serverName = "localhost";
	static int port = 80;

	//********************************************

	Container c = getContentPane();
	JPanel p = new JPanel();

	//The user enters in there username for the chat
	JLabel username = new JLabel("Username:");
	JTextField yourUsername = new JTextField("User",10);
	JButton set = new JButton("Set");

	//Spot for the user to enter in there message
	JLabel message = new JLabel("Message:");
	JTextField yourMessage = new JTextField("",10);
	JButton send = new JButton("Send");

	//Displays the chat log...who said what and time + updates are shown if needed
	JTextArea times = new JTextArea(34, 10);
	JTextArea chat = new JTextArea(34, 25);

	//Username variable
	String myUsername = "";

	//Message variable
	String myMessage = "";

	//Local log container
	String nameTime = "";
	String log = "";

	public static void main(String[]args)
	{
		client GUI = new client();

		try
		{
			System.out.println("Connecting to " + serverName+" on port "+port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			InputStream inFromServer = client.getInputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			DataInputStream in = new DataInputStream(inFromServer);
			out.writeUTF("test");
		}
		catch(IOException x)
		{
			//x.printStackTrace();
			System.out.println("Could not connect to " + serverName);
		}
	}

	client()
	{
		super("Client");
		setSize(800, 650);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//*************************************************************

		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//Item in the menu bar
		JMenu OptionsMenu = new JMenu("Options");
		viewMenuBar.add(OptionsMenu);

		//Items with in the options Item
		JMenuItem HelpMenuItem = new JMenuItem("Help");
		OptionsMenu.add(HelpMenuItem);
		HelpMenuItem.addActionListener(this);
		HelpMenuItem.setMnemonic('h');
		HelpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));//Shortcut: Ctrl + h

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		//Items with in the options Item
		JMenuItem IncreaseMenuItem = new JMenuItem("Increase font size");
		OptionsMenu.add(IncreaseMenuItem);
		IncreaseMenuItem.addActionListener(this);
		IncreaseMenuItem.setMnemonic('i');
		IncreaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, Event.CTRL_MASK));//Shortcut: Ctrl + =

		//Items with in the options Item
		JMenuItem DecreaseMenuItem = new JMenuItem("Decrease font size");
		OptionsMenu.add(DecreaseMenuItem);
		DecreaseMenuItem.addActionListener(this);
		DecreaseMenuItem.setMnemonic('d');
		DecreaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, Event.CTRL_MASK));//Shortcut: Ctrl + -

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		//Items with in the options Item
		JMenuItem ChangeMenuItem = new JMenuItem("Change username");
		OptionsMenu.add(ChangeMenuItem);
		ChangeMenuItem.addActionListener(this);
		ChangeMenuItem.setMnemonic('u');
		ChangeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));//Shortcut: Ctrl + u

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		//Items with in the options Item
		JMenuItem ExitMenuItem = new JMenuItem("Exit");
		OptionsMenu.add(ExitMenuItem);
		ExitMenuItem.addActionListener(this);
		ExitMenuItem.setMnemonic('x');
		ExitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));//Shortcut: Ctrl + x

//*************************************************************

		//Item in the menu bar
		JMenu ViewMenu = new JMenu("View");
		viewMenuBar.add(ViewMenu);

		//Items with in the view Item
		JMenu ColourMenuItem = new JMenu("Colour");//Lets the user to change the colour of the gui
		ViewMenu.add(ColourMenuItem);

		//Items with in the colour Item
		JMenuItem DefaultMenuItem = new JMenuItem("Default");//set default
		ColourMenuItem.add(DefaultMenuItem);
		DefaultMenuItem.addActionListener(this);
		DefaultMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, Event.CTRL_MASK));//Shortcut: Ctrl + 1

		//Items with in the colour Item
		JMenuItem BlackMenuItem = new JMenuItem("Black");//set black background with green text
		ColourMenuItem.add(BlackMenuItem);
		BlackMenuItem.addActionListener(this);
		BlackMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, Event.CTRL_MASK));//Shortcut: Ctrl + 2

		//Items with in the colour Item
		JMenuItem ColourizedMenuItem = new JMenuItem("Colourized");//set reb background with blue text
		ColourMenuItem.add(ColourizedMenuItem);
		ColourizedMenuItem.addActionListener(this);
		ColourizedMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, Event.CTRL_MASK));//Shortcut: Ctrl + 3

//*************************************************************

		setJMenuBar(viewMenuBar);


		//Order
		//Chat log goes here
		//Label with message
		//TextField with user message
		//Button with Send
		times.setEditable(false);//User can't edit names and times
		set.addActionListener(this);
		chat.setEditable(false);//User can't edit chat log
		send.setMnemonic(KeyEvent.VK_ENTER);//send.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, Event.CTRL_MASK));//Shortcut: Alt + Enter
		send.addActionListener(this);
		p.add(username);
		p.add(yourUsername);
		set.setMnemonic('s');
		//set.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		p.add(set);
		p.add(message);
		yourMessage.setEnabled(false);
		p.add(yourMessage);
		send.setEnabled(false);
		p.add(send);
		times.setLineWrap(false);
		p.add(times);
		chat.setLineWrap(false);
		p.add(chat);
		JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
            times, chat);
        scrollPane.setPreferredSize(new Dimension(550, 550));
        scrollPane.setViewportView(splitPane);
		p.add(scrollPane);
		c.add(p);

		//Set introduction text
		chat.setText("Welcome to the chat.");

		//Default styling
		p.setBackground(Color.gray);
		chat.setForeground(Color.black);
		chat.setBackground(Color.white);
		username.setForeground(Color.black);
		yourUsername.setForeground(Color.black);
		yourUsername.setBackground(Color.white);
		message.setForeground(Color.black);
		yourMessage.setForeground(Color.black);
		yourMessage.setBackground(Color.white);
		set.setForeground(Color.black);
		set.setBackground(Color.blue);
		send.setForeground(Color.black);
		send.setBackground(Color.blue);

		revalidate();
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Help"))
		{
			System.out.println("**************************************");
			System.out.println("               Help                   ");
			System.out.println("**************************************");
			System.out.println(" Welcome to our group chat program, \n please enter a username and then a \n message to send. \n If you wish to change font size, \n either enter the options menu and \n select the option to increase font \n size or use the CTRL+Equals command. \n The shortcut to decrease font size \n is CTRL+Minus and to exit the program \n press CTRL+X. \n \n Please enjoy the program.");
			System.out.println("**************************************");
		}
		if (e.getActionCommand().equals("Increase font size"))//Increase the size of the text
		{
			Font font = times.getFont();
			float size = font.getSize() + 2.0f;
			times.setFont(font.deriveFont(size));
			chat.setFont(font.deriveFont(size));
		}
		if (e.getActionCommand().equals("Decrease font size"))//Decrease the size of the text
		{
			Font font = times.getFont();
			float size = font.getSize() - 2.0f;
			times.setFont(font.deriveFont(size));
			chat.setFont(font.deriveFont(size));
		}
		if (e.getActionCommand().equals("Change username"))//Lets the user to update there username, sends a message saying user "x" has changed there name to "y"
		{
			String temp = yourUsername.getText();
			String text = JOptionPane.showInputDialog((Component) e.getSource(), "Please enter a username");

			if (text != null && !text.equals("") && !text.equals("User") && !temp.equals("User"))
			{
			  	JOptionPane.showMessageDialog((Component) e.getSource(), "Hello " + text);
				myUsername = text;
				yourUsername.setText(text);
				yourUsername.setEnabled(false);
				set.setEnabled(false);
				yourMessage.setEnabled(true);
				send.setEnabled(true);
				LocalTime time = LocalTime.now();
				nameTime += ("\n" + "~ UPDATE ~" + time);
				log += ("\n" + temp + " has changed their name to: " + myUsername);
				times.setText(nameTime);
				chat.setText(log);
			}
			else if (text != null && temp.equals("User") && !text.equals("User"))
			{
			  	JOptionPane.showMessageDialog((Component) e.getSource(), "Welcome " + text);
				myUsername = text;
				yourUsername.setText(text);
				yourUsername.setEnabled(false);
				set.setEnabled(false);
				yourMessage.setEnabled(true);
				send.setEnabled(true);
				LocalTime time = LocalTime.now();
				nameTime += ("\n" + "~ UPDATE ~" + time);
				log += ("\n" + myUsername + " has joined the chat.");
				times.setText(nameTime);
				chat.setText(log);
			}
			else
			{
				JOptionPane.showMessageDialog((Component) e.getSource(), "Username can not be set to default!", "Naming error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getActionCommand().equals("Exit"))//Exit the program
		{
			System.exit(0);
		}
		if (e.getActionCommand().equals("Default"))//Change the colour to default
		{
			p.setBackground(Color.gray);
			times.setForeground(Color.black);
			times.setBackground(Color.white);
			chat.setForeground(Color.black);
			chat.setBackground(Color.white);
			username.setForeground(Color.black);
			yourUsername.setForeground(Color.black);
			yourUsername.setBackground(Color.white);
			message.setForeground(Color.black);
			yourMessage.setForeground(Color.black);
			yourMessage.setBackground(Color.white);
			set.setForeground(Color.black);
			set.setBackground(Color.blue);
			send.setForeground(Color.black);
			send.setBackground(Color.blue);
		}
		if (e.getActionCommand().equals("Black"))//Change the colour to black
		{
			p.setBackground(Color.black);
			times.setForeground(Color.green);
			times.setBackground(Color.black);
			chat.setForeground(Color.green);
			chat.setBackground(Color.black);
			username.setForeground(Color.green);
			yourUsername.setForeground(Color.green);
			yourUsername.setBackground(Color.black);
			message.setForeground(Color.green);
			yourMessage.setForeground(Color.green);
			yourMessage.setBackground(Color.black);
			set.setForeground(Color.green);
			set.setBackground(Color.black);
			send.setForeground(Color.green);
			send.setBackground(Color.black);
		}
		if (e.getActionCommand().equals("Colourized"))//Change the colour to red
		{
			p.setBackground(Color.red);
			times.setForeground(Color.cyan);
			times.setBackground(Color.red);
			chat.setForeground(Color.cyan);
			chat.setBackground(Color.red);
			username.setForeground(Color.cyan);
			yourUsername.setForeground(Color.blue);
			yourUsername.setBackground(Color.red);
			message.setForeground(Color.cyan);
			yourMessage.setForeground(Color.red);
			yourMessage.setBackground(Color.cyan);
			set.setForeground(Color.blue);
			set.setBackground(Color.red);
			send.setForeground(Color.blue);
			send.setBackground(Color.red);
		}
		if (e.getActionCommand().equals("Set"))//Set the username and say user "x" has joined the chat
		{
			myUsername = yourUsername.getText();
			yourUsername.setEnabled(false);
			set.setEnabled(false);
			yourMessage.setEnabled(true);
			send.setEnabled(true);
			LocalTime time = LocalTime.now();
			nameTime += ("\n" + "~ UPDATE ~" + time);
			log += ("\n" + myUsername + " has joined the chat.");
			times.setText(nameTime);
			chat.setText(log);
		}
		if (e.getActionCommand().equals("Send"))//Send the sessage
		{
			myMessage = yourMessage.getText();
			LocalTime time = LocalTime.now();
			nameTime += ("\n" + "[" + myUsername + "]" + time);
			log += ("\n" + myMessage);
			times.setText(nameTime);
			chat.setText(log);
			yourMessage.setText("");


		}
	}
}