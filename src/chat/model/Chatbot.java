package chat.model;

import java.util.ArrayList;
import chat.controller.*;

/**
 * 
 * @author abro5723
 * @version 1.0 10/21/15
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
		this.memesList = new ArrayList<String>();
		/**
		 * Bad Luck Brian
		 * Doge
		 * "Aliens"
		 * Rare Pepe
		 * Me gusta
		 * What if I told you
		 * troll
		 * Unhelpful high school teacher
		 * Cute animals
		 * Y u no?
		 */
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "content";
		
		buildMemesList();
		buildPoliticalTopicsList();
	}
	
	
	private void buildMemesList()
	{
		this.memesList.add("Me gusta");
		this.memesList.add("Rare Pepe");
		this.memesList.add("Doge");
		this.memesList.add("Aliens!");
		this.memesList.add("what if I told you");
		this.memesList.add("Spoderman");
		this.memesList.add("troll");
		this.memesList.add("Cute animals");
		this.memesList.add("Bad luck Brian");
		this.memesList.add("Y u no?");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("democrat");
		this.politicalTopicList.add("republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/8/2016");
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasMash = false;
		
		if(currentInput.equals("dasgds") || currentInput.equals("asdf") || currentInput.equals("jkl;"))
		{
			hasMash = true;
		}
		else
		{}
		
		return hasMash;
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean hasQuit = false;
		
		if(currentInput.equals("quit"))
		{
			hasQuit = true;
		}
		
		return hasQuit;
	}
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
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
		boolean hasPoliticalTopic = false;
		
		for(String currentPoliticalTopic: politicalTopicList)
		{
			if(currentPoliticalTopic.contains(currentInput))
			{
				hasPoliticalTopic = true;
			}
		}
		return hasPoliticalTopic;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		
		for(String currentMeme: memesList)
		{
			if(currentMeme.contains(currentInput))
			{
				hasMeme = true;
			}
		}

		
		return hasMeme;
	}
	
	public String processConversation(String currentInput)
	{
		String nextConversation = "";
		int randomTopic = (int) (Math.random() * 5);
		
		switch (randomTopic)
		{
		case 0 :
			if(memeChecker(currentInput))
			{
				nextConversation = "That is a very popular meme this year. Whar else are you wanting to talk about?"; 
			}
			break;
		case 1:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "Hmm, that's a very odd topic. Any other thoughts?";
			}
			break;
		case 2:
			if(contentChecker(currentInput))
			{
				nextConversation ="Alright. Have you anything else to say?";
			}
			break;
		case 3:
			if(currentInput.length() > 20)
			{
				nextConversation = "Not much of a talker are you?";
			}
			break;
		case 4:
			if(currentInput.length() < 20)
			{
				nextConversation = "Wow, you don't really elaborate do you?";
			}
		
		}
		return nextConversation;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
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
		content= "Motivational sign";
		this.content = content;
	}
}
