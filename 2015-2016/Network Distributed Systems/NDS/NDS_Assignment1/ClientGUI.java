import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ActionListener
{
	private JLabel label;

	private JTextField tf;

	//Server and port Text fields
	private JTextField tfServer;
	private JTextField tfPort;

	//Login and logout functions
	private JButton login;
	private JButton logout;
	private JButton whoIsIn;

	//The chat Text Area
	private JTextArea ta;

	//The four panels
	private JPanel serverAndPort = new JPanel(new GridLayout(1,5, 1, 3));
	private JPanel northPanel = new JPanel(new GridLayout(3,1));
	private JPanel centerPanel = new JPanel(new GridLayout(1,1));
	private JPanel southPanel = new JPanel();

	//Connection status boolean
	private boolean connected;

	//The Client object
	private Client client;

	//The default port and host numbers
	private int defaultPort;
	private String defaultHost;

	//The client GUI
	ClientGUI(String host, int port)
	{
		super("Client");
		defaultPort = port;
		defaultHost = host;

		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//Item in the menu bar
		JMenu OptionsMenu = new JMenu("Options");
		viewMenuBar.add(OptionsMenu);

		//Items with in the help Item
		JMenuItem HelpMenuItem = new JMenuItem("Help");
		OptionsMenu.add(HelpMenuItem);
		HelpMenuItem.addActionListener(this);
		HelpMenuItem.setMnemonic('h');
		HelpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		JMenuItem IncreaseMenuItem = new JMenuItem("Increase font size");
		OptionsMenu.add(IncreaseMenuItem);
		IncreaseMenuItem.addActionListener(this);
		IncreaseMenuItem.setMnemonic('i');
		IncreaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, Event.CTRL_MASK));

		JMenuItem DecreaseMenuItem = new JMenuItem("Decrease font size");
		OptionsMenu.add(DecreaseMenuItem);
		DecreaseMenuItem.addActionListener(this);
		DecreaseMenuItem.setMnemonic('d');
		DecreaseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, Event.CTRL_MASK));

		//Adds in a line to space it out
		OptionsMenu.addSeparator();

		JMenuItem ExitMenuItem = new JMenuItem("Exit");
		OptionsMenu.add(ExitMenuItem);
		ExitMenuItem.addActionListener(this);
		ExitMenuItem.setMnemonic('x');
		ExitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));

//*************************************************************
		JMenu ViewMenu = new JMenu("View");
		viewMenuBar.add(ViewMenu);

		JMenu ColourMenuItem = new JMenu("Colour");
		ViewMenu.add(ColourMenuItem);

		JMenuItem DefaultMenuItem = new JMenuItem("Default");
		ColourMenuItem.add(DefaultMenuItem);
		DefaultMenuItem.addActionListener(this);
		DefaultMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, Event.CTRL_MASK));

		JMenuItem BlackMenuItem = new JMenuItem("Black");
		ColourMenuItem.add(BlackMenuItem);
		BlackMenuItem.addActionListener(this);
		BlackMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, Event.CTRL_MASK));

		JMenuItem ColourizedMenuItem = new JMenuItem("Colourized");
		ColourMenuItem.add(ColourizedMenuItem);
		ColourizedMenuItem.addActionListener(this);
		ColourizedMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, Event.CTRL_MASK));
//*************************************************************

		setJMenuBar(viewMenuBar);

		tfServer = new JTextField(host);
		tfPort = new JTextField("" + port);
		tfPort.setHorizontalAlignment(SwingConstants.RIGHT);

		//The top of the GUI
		serverAndPort.add(new JLabel("Server:"));
		serverAndPort.add(tfServer);
		serverAndPort.add(new JLabel("Port:"));
		serverAndPort.add(tfPort);
		serverAndPort.add(new JLabel(""));
		northPanel.add(serverAndPort);

		//Labels and the TextField
		label = new JLabel("Enter your username below", SwingConstants.CENTER);
		northPanel.add(label);
		tf = new JTextField("User");
		tf.setBackground(Color.WHITE);
		northPanel.add(tf);
		add(northPanel, BorderLayout.NORTH);

		//The chat panel
		ta = new JTextArea("Welcome to the Chat room\n", 80, 80);
		centerPanel.add(new JScrollPane(ta));
		ta.setEditable(false);
		add(centerPanel, BorderLayout.CENTER);

		//The three buttons
		login = new JButton("Login");
		login.addActionListener(this);
		logout = new JButton("Logout");
		logout.addActionListener(this);
		logout.setEnabled(false);
		whoIsIn = new JButton("Users Online");
		whoIsIn.addActionListener(this);
		whoIsIn.setEnabled(false);

		southPanel.add(login);
		southPanel.add(logout);
		southPanel.add(whoIsIn);
		add(southPanel, BorderLayout.SOUTH);

		serverAndPort.setBackground(Color.gray);
		northPanel.setBackground(Color.gray);
		centerPanel.setBackground(Color.gray);
		tfPort.setForeground(Color.black);
		tfPort.setBackground(Color.white);
		tfServer.setForeground(Color.black);
		tfServer.setBackground(Color.white);
		ta.setForeground(Color.black);
		ta.setBackground(Color.white);
		login.setForeground(Color.black);
		login.setBackground(Color.white);
		logout.setForeground(Color.black);
		logout.setBackground(Color.white);
		whoIsIn.setForeground(Color.black);
		whoIsIn.setBackground(Color.white);
		southPanel.setForeground(Color.black);
		southPanel.setBackground(Color.white);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(410, 175);
		setSize(600, 600);
		setResizable(false);
		setVisible(true);
		tf.requestFocus();

	}

	//To append text in the chat
	void append(String str)
	{
		ta.append(str);
		ta.setCaretPosition(ta.getText().length() - 1);
	}

	//To failsafe a connection
	void connectionFailed()
	{
		login.setEnabled(true);
		logout.setEnabled(false);
		whoIsIn.setEnabled(false);
		label.setText("Enter your username");
		tf.setText("Anonymous");
		tfPort.setText("" + defaultPort);
		tfServer.setText(defaultHost);
		tfServer.setEditable(false);
		tfPort.setEditable(false);
		tf.removeActionListener(this);
		connected = false;
	}

	public void actionPerformed(ActionEvent e)
	{
		//Option actions
		if (e.getActionCommand().equals("Help"))
		{
			JOptionPane.showMessageDialog((Component) e.getSource(), "Welcome to our group chat program, \n please enter a username and then a \n message to send. \n If you wish to change font size, \n either enter the options menu and \n select the option to increase font \n size or use the CTRL+Equals command. \n The shortcut to decrease font size \n is CTRL+Minus and to exit the program \n press CTRL+X. \n \n Please enjoy the program", "Help", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		if (e.getActionCommand().equals("Increase font size"))
		{
			Font font = tf.getFont();
			float size = font.getSize() + 2.0f;
			tf.setFont(font.deriveFont(size));
			ta.setFont(font.deriveFont(size));
			return;
		}
		if (e.getActionCommand().equals("Decrease font size"))
		{
			Font font = tf.getFont();
			float size = font.getSize() - 2.0f;
			tf.setFont(font.deriveFont(size));
			ta.setFont(font.deriveFont(size));
			return;
		}
		if (e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		if (e.getActionCommand().equals("Default"))
		{
			serverAndPort.setBackground(Color.gray);
			northPanel.setBackground(Color.gray);
			centerPanel.setBackground(Color.gray);
			tfPort.setForeground(Color.black);
			tfPort.setBackground(Color.white);
			tfServer.setForeground(Color.black);
			tfServer.setBackground(Color.white);
			tf.setForeground(Color.black);
			tf.setBackground(Color.white);
			ta.setForeground(Color.black);
			ta.setBackground(Color.white);
			login.setForeground(Color.black);
			login.setBackground(Color.white);
			logout.setForeground(Color.black);
			logout.setBackground(Color.white);
			whoIsIn.setForeground(Color.black);
			whoIsIn.setBackground(Color.white);
			southPanel.setForeground(Color.black);
			southPanel.setBackground(Color.white);
		}
		if (e.getActionCommand().equals("Black"))
		{
			serverAndPort.setBackground(Color.black);
			northPanel.setBackground(Color.black);
			centerPanel.setBackground(Color.black);
			tfPort.setForeground(Color.green);
			tfPort.setBackground(Color.black);
			tfServer.setForeground(Color.green);
			tfServer.setBackground(Color.black);
			tf.setForeground(Color.green);
			tf.setBackground(Color.black);
			ta.setForeground(Color.green);
			ta.setBackground(Color.black);
			login.setForeground(Color.green);
			login.setBackground(Color.black);
			logout.setForeground(Color.green);
			logout.setBackground(Color.black);
			whoIsIn.setForeground(Color.green);
			whoIsIn.setBackground(Color.black);
			southPanel.setForeground(Color.green);
			southPanel.setBackground(Color.black);
		}
		if (e.getActionCommand().equals("Colourized"))
		{
			serverAndPort.setBackground(Color.red);
			northPanel.setBackground(Color.red);
			centerPanel.setBackground(Color.red);
			tfPort.setForeground(Color.cyan);
			tfPort.setBackground(Color.red);
			tfServer.setForeground(Color.cyan);
			tfServer.setBackground(Color.red);
			tf.setForeground(Color.blue);
			tf.setBackground(Color.red);
			ta.setForeground(Color.blue);
			ta.setBackground(Color.red);
			login.setForeground(Color.blue);
			login.setBackground(Color.red);
			logout.setForeground(Color.cyan);
			logout.setBackground(Color.red);
			whoIsIn.setForeground(Color.cyan);
			whoIsIn.setBackground(Color.red);
			southPanel.setForeground(Color.cyan);
			southPanel.setBackground(Color.red);
		}

		Object o = e.getSource();

		if(o == logout)
		{
			client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
			return;
		}
		if(o == whoIsIn)
		{
			client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));
			return;
		}
		if(connected)
		{
			client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, tf.getText()));
			tf.setText("");
			return;
		}
		if(o == login)
		{
			String username = "[" + tf.getText().trim() + "]";

			if(username.length() == 0)
				return;

			String server = tfServer.getText().trim();

			if(server.length() == 0)
				return;

			String portNumber = tfPort.getText().trim();
			if(portNumber.length() == 0)
				return;
			int port = 0;
			try
			{
				port = Integer.parseInt(portNumber);
			}
			catch(Exception en)
			{
				JOptionPane.showMessageDialog((Component) e.getSource(), "Port number invalid!", "Port error", JOptionPane.ERROR_MESSAGE);
			}

			client = new Client(server, port, username, this);

			if(!client.start())
				return;
			tf.setText("");
			label.setText("Enter your message below");
			connected = true;

			login.setEnabled(false);
			logout.setEnabled(true);
			whoIsIn.setEnabled(true);
			tfServer.setEditable(false);
			tfPort.setEditable(false);
			tf.addActionListener(this);
		}
	}

	//The main method
	public static void main(String[] args)
	{
		new ClientGUI("localhost", 1500);
	}

}
