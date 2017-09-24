import java.net.*;
import java.io.*;

public class DataReceived
{
	DatagramSocket datagramSocket = new DatagramSocket(80);

	byte[] buffer = new byte[10];
	DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

	datagramSocket.receive(packet);
}