import java.net.*;
import java.io.*;

public class DataSend
{
	DatagramSocket datagramSocket = new DatagramSocket();

	byte[] buffer = "0123456789".getBytes();
	InetAddress receiverAddress = InetAddress.getLocalHost();

	DatagramPacket packet = new DatagramPacket(
		buffer, buffer.length, receiverAddress, 80);
	datagramSocket.send(packet);
}