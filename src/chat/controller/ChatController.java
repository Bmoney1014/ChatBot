package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatPanel;
import chat.view.ChatFrame;
import chat.view.ChatView;
import chat.model.CTECTwitter;

/**
 * 
 * @author bhos1889
 * @version 2.1.1 3/11/16 Added a twitter addition
 */
public class ChatController 
{
	private ChatView myDisplay;
	private Chatbot myBot;
	private ChatFrame baseFrame;
	private CTECTwitter chatTwitter;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabInput("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		myDisplay.grabInput("Hi " + myBot.getUserName());
		chat();
	}
	private void chat()
	{
		String conversation = myDisplay.grabInput("What do you want to talk about?");
		{	
		conversation = myDisplay.grabInput(conversation);
		}
		
		String userToChatbot(String userText)
		{
			String response = "";
			
			if(myBot.quitChecker(userText))
			{
				shutDown();
			}
			
			response = myBot.processConversation(userText);
			
			return response;
		}
	}
	
	private void shutDown()
	{
		myDisplay.grabInput("Goodbye, " + myBot.getUserName() + "It was fun talking to you.");
		System.exit(0);
	}
	
	public void sendTweet(String tweetText)
	{
	    chatTwitter.sendTweet(tweetText);
	}

	public String analyze(String userName)
	{
	    String userAnalysis = "Twitter user " + userName + "has....";
	    
	    return userAnalysis;
	}
	
	public void handleErrors(String error)
	{
	    
	}
	public ChatView getMyDisplay()
	{
		return myDisplay;
	}

	public void setMyDisplay(ChatView myDisplay)
	{
		this.myDisplay = myDisplay;
	}

	public Chatbot getMyBot()
	{
		return myBot;
	}

	public void setMyBot(Chatbot myBot)
	{
		this.myBot = myBot;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}
	
	
}

