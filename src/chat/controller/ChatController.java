package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * 
 * @author bhos1889
 * @version 1.1.1 10/21/15 fixed error ;)
 */
public class ChatController 
{
	private ChatView myDisplay;
	private Chatbot myBot;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabInput("What is your name?");
		myBot = new Chatbot(userName);
	}
	
	public void start()
	{
		myDisplay.grabInput("Hello " + myBot.getUserName());
	}
}
