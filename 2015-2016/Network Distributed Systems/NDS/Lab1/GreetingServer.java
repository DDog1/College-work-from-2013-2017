import java.net.*;
import java.io.*;

public class GreetingServer extends Thread
{
	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException
	{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				System.out.println(in.readUTF());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());

				System.out.println("");//prints line

				out.writeUTF("Hello what is your name?");
				System.out.print(in.readUTF() + "");
				System.out.print(in.readUTF() + "\n\n");

				out.writeUTF("Do you like college?");
				System.out.println(in.readUTF()+ "\n");

				/*
				String temp = in.readUTF();

				if(temp.equals("y"))
				{
					out.writeUTF("Thats good!! :)");
				}
				else if(temp.equals("n"))
				{
					out.writeUTF("Oh no!! :O");
				}

				else
				{
					out.writeUTF("hmmmmmm you entred something but I dont know what :/");
				}*/

				out.writeUTF("Thank you for connceting to " + server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
			}
			catch(SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
				break;
			}
			catch(IOException x)
			{
				x.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[]args)
	{
		int port = Integer.parseInt(args[0]);
		try
		{
			Thread t = new GreetingServer(port);
			t.start();
		}
		catch(IOException x)
		{
			x.printStackTrace();
		}
	}
}