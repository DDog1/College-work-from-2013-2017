import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerGUI extends JFrame implements ActionListener, WindowListener
{
	//The Jpanel at the top of the GUI
	private JPanel north = new JPanel();

	//The JPanel in the center of the GUI
	JPanel center = new JPanel(new GridLayout(2,1));

	//The stop and start buttons
	private JButton stopStart;

	//Text Area for the chat
	private JTextArea chat;

	//Text Area for the events
	private JTextArea event;

	//The port number
	private JTextField tPortNumber;

	//The server
	private Server server;


	//The server GUI accepts a port number as a parameter
	ServerGUI(int port)
	{
		super("Server");
		server = null;

		//Makes the menu bar
		JMenuBar viewMenuBar = new JMenuBar();

		//Item in the menu bar
		JMenu OptionsMenu = new JMenu("Options");
		viewMenuBar.add(OptionsMenu);

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

		north.add(new JLabel("Port number: "));
		tPortNumber = new JTextField("  " + port);
		north.add(tPortNumber);
		stopStart = new JButton("Start");
		stopStart.addActionListener(this);
		north.add(stopStart);
		add(north, BorderLayout.NORTH);

		chat = new JTextArea(80,80);
		chat.setEditable(false);
		appendRoom("~CHAT~\n");
		center.add(new JScrollPane(chat));
		event = new JTextArea(80,80);
		event.setEditable(false);
		appendEvent("~EVENTS~\n");
		center.add(new JScrollPane(event));
		add(center);

		north.setBackground(Color.gray);
		stopStart.setBackground(Color.blue);
		chat.setForeground(Color.black);
		chat.setBackground(Color.white);
		event.setForeground(Color.black);
		event.setBackground(Color.white);
		tPortNumber.setForeground(Color.black);
		tPortNumber.setBackground(Color.white);

		setResizable(false);
		setLocation(10, 175);
		addWindowListener(this);
		setSize(400, 600);
		setVisible(true);
	}

	//Update the Text Areas
	void appendRoom(String str)
	{
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}
	void appendEvent(String str)
	{
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);

	}

	//Action events
	public void actionPerformed(ActionEvent e)
	{
		//If running we stop
		if(server != null)
		{
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			stopStart.setText("Start");
			return;
		}

      	//If not started yet we start
		int port;
		try
		{
			port = Integer.parseInt(tPortNumber.getText().trim());
		}
		catch(Exception er)
		{
			appendEvent("Invalid port number");
			return;
		}

		if (e.getActionCommand().equals("Increase font size"))
		{
			Font font = chat.getFont();
			float size = font.getSize() + 2.0f;
			chat.setFont(font.deriveFont(size));
			event.setFont(font.deriveFont(size));
			return;
		}
		if (e.getActionCommand().equals("Decrease font size"))
		{
			Font font = chat.getFont();
			float size = font.getSize() - 2.0f;
			chat.setFont(font.deriveFont(size));
			event.setFont(font.deriveFont(size));
			return;
		}
		if (e.getActionCommand().equals("Exit"))
		{
			System.exit(0);
		}
		if (e.getActionCommand().equals("Default"))
		{
			north.setBackground(Color.gray);
			stopStart.setForeground(Color.black);
			stopStart.setBackground(Color.blue);
			chat.setForeground(Color.black);
			chat.setBackground(Color.white);
			event.setForeground(Color.black);
			event.setBackground(Color.white);
			tPortNumber.setForeground(Color.black);
			tPortNumber.setBackground(Color.white);
			return;
		}
		if (e.getActionCommand().equals("Black"))
		{
			north.setBackground(Color.black);
			stopStart.setForeground(Color.green);
			stopStart.setBackground(Color.black);
			chat.setForeground(Color.green);
			chat.setBackground(Color.black);
			event.setForeground(Color.green);
			event.setBackground(Color.black);
			tPortNumber.setForeground(Color.green);
			tPortNumber.setBackground(Color.black);
			return;
		}
		if (e.getActionCommand().equals("Colourized"))
		{
			north.setBackground(Color.red);
			stopStart.setForeground(Color.blue);
			stopStart.setBackground(Color.red);
			chat.setForeground(Color.blue);
			chat.setBackground(Color.red);
			event.setForeground(Color.blue);
			event.setBackground(Color.red);
			tPortNumber.setForeground(Color.cyan);
			tPortNumber.setBackground(Color.red);
			return;
		}

		//Ceate a new Server
		server = new Server(port, this);

		//Start server as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
	}

	//Main method
	public static void main(String[] arg)
	{
		//Start server on default port 1500
		new ServerGUI(1500);
	}

	public void windowClosing(WindowEvent e)
	{
		if(server != null)
		{
			try {
				server.stop();
			}
			catch(Exception eClose)
			{
			}
			server = null;
		}
		dispose();
		System.exit(0);
	}

	//Window listener necessary methods
	public void windowClosed(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}

	class ServerRunning extends Thread
	{
		public void run()
		{
			server.start();
			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server failure\n");
			server = null;
		}
	}

}
