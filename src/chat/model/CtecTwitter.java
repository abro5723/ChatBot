package chat.model;

import twitter4j.*;

import java.util.*;

import chat.controller.ChatController;

public class CtecTwitter
{

	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatBotTwitter;
	private ChatController baseController;
	
	public CtecTwitter(ChatController baseController)
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		chatBotTwitter = TwitterFactory.getSingleton();
		this.baseController = baseController;
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatBotTwitter.updateStatus("I have way too much fun with this");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
//	public String topResults(List<String> wordList)
//	{
//		
//	}
}
