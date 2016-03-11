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
    private ChatController baseController;
    
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

    public String topResults(List<String> wordList)
    {
    
    }
    
    public void loadTweets(String twitterHandle) throws TwitterException
    {
	Paging statusPage = new Paging(1, 200);
	int page = 1;
	while(page <= 10)
	{
	    statusPage.setPage(page);
	    statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
	    page++;
	}
	for (Status currentStatus : statuses)
	{
	    String[] tweetText = currentStatus.getText().split(" ");
	    for (String word : tweetText)
	    {
		tweetTexts.add(removePunctuation(word).toLowerCase());
	    }
	}
	removeCommonEnglishWords(tweetTexts);
	removeEmptyText();
    }

    private String removePunctuation(String currentString)
    {
	return null;
    }

    private void removeEmptyText()
    {
	
    }

    private List removeCommonEnglishWords(List<String> wordList)
    {
	return null;
    }


}