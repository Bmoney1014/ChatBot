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
	catch(TwitterException error)
	{
	    baseController.handleErrors(error.getErrorMessage());
	}
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
	String punctuation = ".,'?!:;\"(){}^[]<>-";
	
	String scrubbedString = "";
	for (int i = 0; i < currentString.length(); i++)
	{
	    if (punctuation.indexOf(currentString.charAt(i)) == -1)
	    {
		scrubbedString += currentString.charAt(i);
	    }
	}
	return scrubbedString;
    }

    private void removeEmptyText()
    {
	for (int spot = 0; spot < tweetTexts.size(); spot++)
	{
	    if (tweetTexts.get(spot).equals(""))
	    {
		tweetTexts.remove(spot);
		spot--;
	    }
	}
    }

    private List removeCommonEnglishWords(List<String> wordList)
    {
	String[] boringWords = importWordsToArray();
	
	for (int count = 0; count < wordList.size(); count++)
	{
	    for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
	    {
		if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
		{
		    wordList.remove(count);
		    count--;
		    removeSpot = boringWords.length;
			
		}
	    }
	}
	
	return wordList;
    }
    
    private String[] importWordsToArray()
    {
	String[] boringWords;
	int wordCount = 0;
	try
	{
	    Scanner wordFile = new Scanner(new File("commonWords.txt"));
	    while (wordFile.hasNext())
	    {
		wordCount++;
		wordFile.next();
	    }
	    wordFile.reset();
	    boringWords = new String[wordCount];
	    int boringWordCount = 0;
	    while (wordFile.hasNext())
	    {
		boringWords[boringWordCount] = wordFile.next();
		boringWordCount++;
	    }
	    wordFile.close();
	}
	catch (FileNotFoundException e)
	{
	    return new String[0];
	}
	return boringWords;
    }

    public String topResults(List<String> tweetTexts)
    {
	String tweetResults = "";
	
	int topWordLocation = 0;
	int topCount = 0;
	
	for(int index = 0; index < tweetTexts.size(); index++)
	{
	    int wordUseCount = 1;
	    
	    for(int spot = index + 1; spot < tweetTexts.size(); spot++)
	    {
		if(tweetTexts.get(index).equals(tweetTexts.get(spot)))
		{
		    wordUseCount++;
		}
		if(wordUseCount > topCount)
		{
		    topCount = wordUseCount;
		    topWordLocation = index;
		}
	    }
	}
	
	tweetResults = "The top word in the tweets was " + tweetTexts.get(topWordLocation) + " and it was used " + topCount + " times!";
	
	return tweetResults;	
    }
    
    public String sampleInvestigation()
    {
	String results = "";
	
	Query query = new Query("Scoot");
	query.setCount(200);
	query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.KILOMETERS);
	query.setSince("2016-1-1");
	try
	{
	    QueryResult result = chatbotTwitter.search(query);
	    results += "Count : " + result.getTweets().size() + "\n";
	    for (Status tweet : result.getTweets())
	    {
		results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
	    }
	}
	catch (TwitterException error)
	{
	    error.printStackTrace();
	}
	
	return results;
    }
}