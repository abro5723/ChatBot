package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;

/**
 * Application controller for the project
 * @author abro5723
 * @version 1.0 10/21/15
 */
public class chatController 
{
	private ChatView myDisplay;
	private Chatbot myBot;
	
	public chatController()
	{
		myDisplay = new ChatView();
		String userName = myDisplay.grabAnswer("What is your name?");
		myBot = new Chatbot(userName);
	}
	public void start()
	{
		myDisplay.showResponse("Hello " + myBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		 String conversation = myDisplay.grabAnswer("What would you like to talk about today?");
		 while(myBot.lengthChecker(conversation))
		 {
			 if(myBot.contentChecker(conversation))
			 {
				 myDisplay.showResponse("wow, I had no idea you are interested in " + myBot.getContent());
			 }
			 else if(myBot.memeChecker(conversation))
			 {
				 myDisplay.showResponse("The dankest of memes.");
			 }
	
			 conversation = myDisplay.grabAnswer(conversation);
		 }
	}
	private void shutDown()
	{
		 
	}
}

	