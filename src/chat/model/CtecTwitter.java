package chat.model;

import twitter4j.*;

import java.util.ArrayList;

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
			chatBotTwitter.updateStatus("Spam ");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
//	public String topResults(ArrayList<String> wordList)
//	{
//		
//	}
}
