import java.net.*;
import java.io.*;
import java.util.Scanner;

public class DataSend
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

//************************ Code used
			DatagramSocket datagramSocket = new DatagramSocket();

			byte[] buffer = "0123456789".getBytes();
			InetAddress receiverAddress = InetAddress.getLocalHost();

			System.out.println("Enter your message : ");
			input = user_input.next();
			buffer = input.getBytes();

			DatagramPacket packet = new DatagramPacket(
				buffer, buffer.length, receiverAddress, 80);
			datagramSocket.send(packet);
			String s = buffer.toString();
			s = new String(buffer);
			System.out.println("Data Sent : "+s);
//************************

			//input = user_input.next();

			client.close();
		}
		catch(IOException x)
		{
			x.printStackTrace();
		}
	}
}