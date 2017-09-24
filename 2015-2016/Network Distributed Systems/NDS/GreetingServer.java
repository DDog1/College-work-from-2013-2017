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
//***********************

				DatagramSocket datagramSocket = new DatagramSocket(80);

				byte[] buffer = new byte[10];
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

				datagramSocket.receive(packet);
				buffer = packet.getData();
				String s = buffer.toString();
				s = new String(buffer);
				System.out.println("Data Received : "+s);
//***********************

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