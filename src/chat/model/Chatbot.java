package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only sub methods are provided. Students will complete methods as part of the project.
 * @author bhos1889
 * @version 1.1 10/23/15 Completed the lengthChecker method. Fixed the Constructor and getter for userName
 */
public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
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
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
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
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
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
	
	public String processCoversation(String currentInput)
	{
		String nextConversation = "oh, what else do yo want to talk about?";
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
	
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return content;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}
