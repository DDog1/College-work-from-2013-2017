import java.net.*;
import java.io.*;

public class server extends Thread
{
	private ServerSocket serverSocket;

	public server(int port) throws IOException
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

				//System.out.println(in.readUTF());//prints line

				out.writeUTF("Hello what is your name?");
				System.out.print(in.readUTF() + "");
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
		//int port = Integer.parseInt(args[0]);
		int port = 80;
		try
		{
			Thread t = new server(port);
			t.start();
		}
		catch(IOException x)
		{
			x.printStackTrace();
		}
	}
}