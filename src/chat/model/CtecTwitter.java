package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.*;
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
		statusList.clear();
		wordList.clear();
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
	
	@SuppressWarnings("unchecked")
	public List removeFromCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for(int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		//removeTwitterUsernamesFromList(wordList);
		return wordList;
	}
	
	private String[] importWordsToArray() 
	{
		String[] boringWords;
		int wordCount = 0;
		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while (wordFile.hasNext())
		{
			wordCount++;
			wordFile.next();
		}
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordCount];
		int boringWordCount = 0;
		while(wordFile.hasNext())
		{
			boringWords[boringWordCount] = wordFile.next();
			boringWordCount++;
		}
		wordFile.close();
		return boringWords;
	}

	//Runs the punctuation against text
	private void removeTwitterUsernamesFromList(List<String>wordList)
	{
		for(int wordCount = 0; wordCount < wordList.size(); wordCount++)
		{
			if(wordList.get(wordCount).length() >= 1 && wordList.get(wordCount).charAt(0) == '@')
			{
				wordList.remove(wordCount);
				wordCount--;
			}
		}
	}
	
	private String removePunctuation(String currentString)
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
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordList.size(); spot++)
		{
			if(wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				spot--;
			}
		}
	}
	//In order to remove value ^ you need to go backwards
	public String topResults()
	{
		String tweetResults = "";
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < wordList.size(); spot++)
			{
				if(wordList.get(index).equals(wordList.get(spot)))
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
		
		tweetResults = "The top word in teh tweets waz " + wordList.get(topWordLocation) + " and it was used " +
				topCount + " timz!";
		return tweetResults;
	}
	
	public String sampleInvestigation()
	{
		String results = "";
		
		Query query = new Query("marathon");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.587521,  -111.869178), 5, Query.MILES);
		query.setSince("2016-1-1");
		try
		{
			QueryResult result = chatBotTwitter.search(query);
			results +="Count : " + result.getTweets().size() + "\n";
			for(Status tweet : result.getTweets())
			{
				results += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		catch(TwitterException error)
		{
			error.printStackTrace();
		}
		
		return results;
	}
	
}
