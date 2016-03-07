package chat.model;

import twitter4j.*;
import java.util.ArrayList;

public class CtecTwitter
{

	private ArrayList<Status> statusList;
	private ArrayList<String> wordList;
	private Twitter chatBotTwitter;
	
	public CtecTwitter()
	{
		statusList = new ArrayList<Status>();
		wordList = new ArrayList<String>();
	}
	
	public void sendTweet(String tweet)
	{
		
	}
}
