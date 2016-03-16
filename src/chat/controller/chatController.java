package chat.controller;

import chat.model.Chatbot;
import chat.model.CtecTwitter;
import chat.view.*;

/**
 * Application controller for the project
 * @author abro5723
 * @version 1.0 10/21/15
 */
public class ChatController 
{
	private CtecTwitter chatTwitter;
	private ChatView myDisplay;
	private Chatbot myBot;
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
		chatTwitter = new CtecTwitter(this);
	}
	/**
	 * getters and setters for all chatController variables
	 * @return
	 */
	public ChatView getMyDisplay()
	{
		return myDisplay;
	}
	public void setMyDisplay(ChatView myDisplay)
	{
		this.myDisplay = myDisplay;
	}
	public Chatbot getMyBot()
	{
		return myBot;
	}
	public void setMyBot(Chatbot myBot)
	{
		this.myBot = myBot;
	}
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}
	public void start()
	{
		myDisplay.showResponse("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		 String conversation = myDisplay.grabAnswer("What would you like to talk about today?");
	 //while(myBot.lengthChecker(conversation))
		 //{
			 //if(myBot.contentChecker(conversation))
			 //{
				 //myDisplay.showResponse("wow, I had no idea you are interested in " + myBot.getContent());
			 //}
			 //else if(myBot.memeChecker(conversation))
			 //{
				 //myDisplay.showResponse("The dankest of memes.");
			 //}
			 //else if(myBot.politicalTopicChecker(conversation))
			 //{
				 //myDisplay.showResponse("Please I've no care for your petty politics mortal!");
			// }
			 //else if(myBot.keyboardMashChecker(conversation))
			 //{
				// myDisplay.showResponse("Well, you seem to be bored now.");
			 //}
			 
			 //conversation = myBot.processConversation(conversation);
			 //conversation = myDisplay.grabAnswer(myBot.processConversation(conversation));
			 //}
	}
	
	public String userToChatbot(String conversation)
	{
		String response = "";
		if(myBot.quitChecker(conversation))
		{
			shutDown();
		}
		
		response = myBot.processConversation(conversation);
		
		return response;
		
	}
	
	public void shutDown()
	{
		myDisplay.showResponse("Goodbye, " + myBot.getUserName() + " I'll devour your corpse");
		System.exit(0);
	}
	
	public void sendTweet(String tweetText)
	{
		chatTwitter.sendTweet(tweetText);
	}
	public void handleErrors(String errorMessage)
	{
		myDisplay.showResponse(errorMessage);
	}
	public String analyze(String userName)
	{
		String userAnalysis = "User " + userName + "has " + chatTwitter.topResults();
		
		return userAnalysis;
		
	}
	
}

	