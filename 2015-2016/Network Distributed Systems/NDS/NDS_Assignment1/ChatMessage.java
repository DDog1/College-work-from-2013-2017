import java.io.*;

//Pass message as java object to make it easier
public class ChatMessage implements Serializable
{

	protected static final long serialVersionUID = 1112122200L;

	//Receive the list of the connected users
	static final int WHOISIN = 0;

	//Normal message
	static final int MESSAGE = 1;

	//Disconnect from the Server
	static final int LOGOUT = 2;

	private int type;
	private String message;

	ChatMessage(int type, String message)
	{
		this.type = type;
		this.message = message;
	}

	int getType()
	{
		return type;
	}
	String getMessage()
	{
		return message;
	}
}
