package chat.model;

import java.util.ArrayList;

/**
 * ChatBot Controller Class
 * @author bhos1889
 * @version 2.2 12/2/15 Added a way for the chatbot to communicate back to the user.
 */
public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	public Chatbot(String userName)
	{
		this.memesList= new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Just do it!";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("cute animals");
		this.memesList.add("doge");
		this.memesList.add("spoderman");
		this.memesList.add("aliens!");
		this.memesList.add("what if I told you");
		this.memesList.add("unhelpful high school teacher");
		
	}
	
	private void buildPoliticalTopicsList()
	{	
		
	}
	
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() >= 1)
			{
				hasLength = true;
			}
		}
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
	}
	
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(String meme : memesList)
		{
			if(currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}
		return hasMeme;
	}
	
	public boolean quitChecker(String userQuit)
	{
		return true;
	}
	
	public String processCoversation(String currentInput)
	{
		String nextConversation = "oh, what else do you want to talk about?";
		int randomTopic = (int) (Math.random() * 5); //Generates a random between 0 and 4.
		
		switch (randomTopic) //Case, value, colon
		{
		case 0:
			 if(memeChecker(currentInput))
			 {
				 nextConversation = "That is a very popular meme this year. What else are you"
						+  "wanting to talk about?";
			 }
			break;
		case 1:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "Are you intereted in politics?";
			}
			break;
		case 2:
			if(contentChecker(currentInput))
		{
			nextConversation = "What else do you want to talk about?";
		}
			break;
		case 3:
			if(currentInput.length() > 30)
			{
				nextConversation = "Anything else you want to talk about?";
			}
			break;
		case 4:
			nextConversation = "Is that all you want to talk about?";
			break;
		default:
			nextConversation = "The universe has ended sad face";
			break;
		}	
		
		return nextConversation;
	}
	
	
	public String getUserName()
	{
		return content;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	public void setContent(String content)
	{
		
	}
}
