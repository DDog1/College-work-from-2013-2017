import java.net.*;
import java.io.*;
import java.util.Scanner;

public class GreetingClient
{
	public static void main(String[]args)
	{
		Scanner user_input;//Makes User_input
		user_input = new Scanner (System.in);//Sets the User_input to read in the users value
		String input;

		String serverName = args[0];
		int port = Integer.parseInt(args[1]);
		try
		{
			System.out.println("Connecting to " + serverName+" on port "+port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			System.out.println("");//prints line

			System.out.println("Server says : " + in.readUTF());//Whats name
			System.out.print("Please enter name : ");
			input = user_input.next();
			System.out.println("");//print line
			out.writeUTF("Client " + client.getLocalSocketAddress() + " says : ");
			out.writeUTF(input);

			System.out.println("Server says " + in.readUTF());//Do you like college
			System.out.print("Please enter y/n : ");
			input = user_input.next();
			System.out.print("\n");//print line
			out.writeUTF("Client " + client.getLocalSocketAddress() + " says : " + input);

			//System.out.println("Server says " + in.readUTF());//depends on what you say yes no or :/

			System.out.println("Server says : " + in.readUTF());
			client.close();
		}
		catch(IOException x)
		{
			x.printStackTrace();
		}
	}
}