package chat.model;

import twitter4j.*;

import java.util.*;

import chat.controller.ChatController;

public class CtecTwitter
{

	private static final ArrayList<Status> tweetTexts = null;
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
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatBotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStaus : statusList)
		{
			String[] tweetText = currentStaus.getText().split("");
			for (String word : tweetText);
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeFromCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}
	

	public List removeFromCommonEnglishWords(List<String> wordsList)
	{
		return null;
	}
	
	private void removeTwitterUsernamesFromList(List<String>wordsList)
	{
		
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}
//	public String topResults(List<String> wordList)
//	{
//		
//	}
}
