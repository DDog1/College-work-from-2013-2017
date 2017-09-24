import java.net.*;
import java.io.*;
import java.util.*;

public class Client
{
	//Read from the socket
	private ObjectInputStream sInput;

	//Write on the socket
	private ObjectOutputStream sOutput;

	private Socket socket;
	private ClientGUI cg;
	private String server;
	private String username;
	private int port;

	//Client constructors
	Client(String server, int port, String username)
	{
		this(server, port, username, null);
	}

	Client(String server, int port, String username, ClientGUI cg)
	{
		this.server = server;
		this.port = port;
		this.username = username;
		this.cg = cg;
	}

	//Start the client
	public boolean start()
	{
		//Attempt to connect to the server
		try
		{
			socket = new Socket(server, port);
		}
		catch(Exception ec)
		{
			display("Error connectiong to server:" + ec);
			return false;
		}

		String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
		display(msg);

		try
		{
			sInput  = new ObjectInputStream(socket.getInputStream());
			sOutput = new ObjectOutputStream(socket.getOutputStream());
		}
		catch (IOException eIO)
		{
			display("Exception creating new Input/output Streams: " + eIO);
			return false;
		}

		new ListenFromServer().start();

		try
		{
			sOutput.writeObject(username);
		}
		catch (IOException eIO)
		{
			display("Exception doing login : " + eIO);
			disconnect();
			return false;
		}
		return true;
	}

	//Display method
	private void display(String msg)
	{
		if(cg == null)
			System.out.println(msg);
		else
			cg.append(msg + "\n");
	}

	//Send message method
	void sendMessage(ChatMessage msg)
	{
		try
		{
			sOutput.writeObject(msg);
		}
		catch(IOException e)
		{
			display("Exception writing to server: " + e);
		}
	}

	//Disconnect method
	private void disconnect()
	{
		try
		{
			if(sInput != null) sInput.close();
		}
		catch(Exception e) {}

		try
		{
			if(sOutput != null) sOutput.close();
		}
		catch(Exception e) {}

        try
        {
			if(socket != null) socket.close();
		}
		catch(Exception e) {}

		if(cg != null)
			cg.connectionFailed();

	}

	//The main method
	public static void main(String[] args)
	{
		int portNumber = 1500;
		String serverAddress = "localhost";
		String userName = "Anonymous";

		switch(args.length)
		{
			case 3:
				serverAddress = args[2];
			case 2:
				try
				{
					portNumber = Integer.parseInt(args[1]);
				}
				catch(Exception e)
				{
					System.out.println("Invalid port number.");
					System.out.println("Usage is: > java Client [username] [portNumber] [serverAddress]");
					return;
				}
				userName = args[0];
			case 0:
				break;
			default:
				System.out.println("Usage is: > java Client [username] [portNumber] {serverAddress]");
			return;
		}

		//Create the Client object
		Client client = new Client(serverAddress, portNumber, userName);

		if(!client.start())
			return;

		Scanner scan = new Scanner(System.in);

		//Infinite loop
		while(true)
		{
			System.out.print("> ");
			String msg = scan.nextLine();
			if(msg.equalsIgnoreCase("LOGOUT"))
			{
				client.sendMessage(new ChatMessage(ChatMessage.LOGOUT, ""));
				break;
			}
			else if(msg.equalsIgnoreCase("WHOISIN"))
			{
				client.sendMessage(new ChatMessage(ChatMessage.WHOISIN, ""));
			}
			else
			{
				client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
			}
		}
		client.disconnect();
	}

	//Listen for the user
	class ListenFromServer extends Thread
	{

		public void run()
		{
			while(true)
			{
				try
				{
					String msg = (String) sInput.readObject();
					if(cg == null)
					{
						System.out.println(msg);
						System.out.print("> ");
					}
					else
					{
						cg.append(msg);
					}
				}
				catch(IOException e)
				{
					display("Server has closed the connection: " + e);
					if(cg != null)
						cg.connectionFailed();
					break;
				}
				catch(ClassNotFoundException e2)
				{
					display("Class not found: " + e2);
				}
			}
		}
	}
}
