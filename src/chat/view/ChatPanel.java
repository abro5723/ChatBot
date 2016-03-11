package chat.view;
/**
 * @author Ashton Brown
 * @version: 1.0 11/27/2016
 * A chatbot that is not unlike ones that someone may find online; however, it is not as diverse.
 */

// imports required for certain functionality of aspects within the panel class
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.color.*;
import java.util.Random;

import javax.swing.*;

import chat.controller.ChatController;


public class ChatPanel extends JPanel
{
	//creation of instances needed for required compilation
	private ChatController baseController;
	private JButton chatButton;
	private JTextField chatText;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	private JLabel promptLabel;
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton analyzeTwitterButton;
	
	
	public ChatPanel(ChatController baseController)
	{
		//association of instances to new names/variables
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatButton = new JButton("Start the convo!");
		chatText = new JTextField("Type yo wurds mayn!");
		chatArea = new JTextArea(10, 40);
		chatArea.setEnabled(false);
		tweetButton = new JButton("Send a tweet");
		analyzeTwitterButton = new JButton("Count dem Tweets");
		

		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		//adds all needed components to the panel
		this.add(chatButton);		
		this.setLayout(baseLayout);
		this.add(chatText);
		this.add(tweetButton);
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		chatText.setToolTipText("Type here for the chatbot.");
		chatArea.setEnabled(false);
		this.add(analyzeTwitterButton);
		//this.add(testButton);
		this.add(textPane);
		//this.add
	}
	
	private void setupListeners()
	{
		//Setup of the button to input info to the chatbot
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = chatText.getText();
				chatArea.append(userText);
				chatText.setText("");
				String response = baseController.userToChatbot(userText);
				chatArea.append("\nChatbot: " + response);
			}
		});
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("no txt to send");
			}
		});
		
		analyzeTwitterButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent click) 
			{
				String user = chatText.getText();
				String results = baseController.analyze(user);
				chatArea.setText(results);
			}
			
			
		});
		
	}


	
	
	private void setupChatPane()
	{
		textPane = new JScrollPane(chatArea);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		this.setPreferredSize(new Dimension(500, 500));
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	private void setupLayout()
	{
		//placing of constraints on the GUI components
		baseLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 2, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.EAST, analyzeTwitterButton, -141, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatText, 6, SpringLayout.SOUTH, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 6, SpringLayout.SOUTH, chatText);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatText);
		baseLayout.putConstraint(SpringLayout.WEST, chatText, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 1, SpringLayout.SOUTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -10, SpringLayout.EAST, chatButton);
	}
	
	/**
	 * getters and setters for the different variables
	 * @return
	 */
	public ChatController getBaseController()
	{
		return baseController;
	}

	public void setBaseController(ChatController baseController)
	{
		this.baseController = baseController;
	}

	public JButton getChatButton()
	{
		return chatButton;
	}

	public void setChatButton(JButton chatButton)
	{
		this.chatButton = chatButton;
	}

	public JTextField getChatText()
	{
		return chatText;
	}

	public void setChatText(JTextField chatText)
	{
		this.chatText = chatText;
	}

	public SpringLayout getBaseLayout()
	{
		return baseLayout;
	}

	public void setBaseLayout(SpringLayout baseLayout)
	{
		this.baseLayout = baseLayout;
	}

	public JTextArea getChatArea()
	{
		return chatArea;
	}

	public void setChatArea(JTextArea chatArea)
	{
		this.chatArea = chatArea;
	}

		
}

