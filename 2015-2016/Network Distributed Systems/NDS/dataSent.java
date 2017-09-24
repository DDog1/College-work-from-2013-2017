import java.util.Scanner;
class dataSent
{
	public static void main(String[]args)
	{
		Scanner user_input;//Makes User_input
		user_input = new Scanner (System.in);//Sets the User_input to read in the users value
		String input;
		System.out.println("Connecting to localhost on port 80\n");
		System.out.println("Just connected to localhost/127.0.0.1:80\n");
		System.out.println("Type a message to send to receiver:");
		input = user_input.next();
		System.out.println("\nSending Data on port 80\n");

	}
}