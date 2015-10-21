package chat.controller;

/**
 * Starts the ChatBot program.
 * @author bhos1889
 * @version 1.0 10/21/15
 */
public class Runner 
{

	public static void main(String [] args)
	{
		ChatController myChatController = new ChatController();
		myChatController.start();
	}
}
