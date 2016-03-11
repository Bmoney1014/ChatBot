package chat.model;

import java.util.*;
import twitter4j.*;
import java.io.*;
import chat.controller.ChatController;

import twitter4j.Twitter;

public class CTECTwitter 
{
    private Twitter chatbotTwitter;
    private List<Status> statuses;
    private List<String> tweetTexts;
    
    public CTECTwitter()
    {
	chatbotTwitter= TwitterFactory.getSingleton();
	statuses = new ArrayList<Status>();
	tweetTexts = new ArrayList<String>();
    }
    
    public void sendTweet(String tweet)
    {
	try
	{
	    chatbotTwitter.updateStatus("");
	}
	catch(twitterException error)
	{
	    baseController.handleErrors(error.getErrorMessage());
	}
    }
}
