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
			String[] tweetText = currentStaus.getText().split(" ");
			for (String word : tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeFromCommonEnglishWords(wordList);
		removeEmptyText();
	}
	

	public List removeFromCommonEnglishWords(List<String> wordList)
	{
		return wordList;
	}
	
	//Runs the punctuation against text
	private String removeTwitterUsernamesFromList(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		
		String scrubbedString = "";
		for(int i = 0; i<currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}
	
	private void removeEmptyText()
	{
		
	}
	
	public String topResults(List<String> wordList)
	{
		return null;
	}
	
}
