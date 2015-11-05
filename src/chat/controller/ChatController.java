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
		myDisplay.grabInput("Hi " + myBot.getUserName());
		chat();
	}
	private void chat()
	{
		String conversation = myDisplay.grabInput("What do you want to talk about?");
		while(myBot.lengthChecker(conversation));
		{
			conversation = myBot.processCoversation(conversation);
			conversation = myDisplay.grabInput(conversation);
		}
	}
	
	private void shutDown()
	{
		myDisplay.grabInput("Goodbye, " + myBot.getUserName() + "It was fun talking to you.");
		System.exit(0);
	}
}

