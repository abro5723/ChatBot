package chat.view;

import java.awt.Color;
import java.awt.event.*;
import java.awt.color.*;
import java.util.Random;
import javax.swing.*;
import chat.controller.ChatController;


public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton chatButton;
	private JTextField chatText;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Start the convo!");
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		chatText = new JTextField("Type yo wurds mayn!");
		baseLayout.putConstraint(SpringLayout.WEST, chatText, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatText, -6, SpringLayout.NORTH, chatButton);
		chatArea = new JTextArea();
		
		setupPanel();
		setupLayout();
	}

	
	private void setupPanel()
	{
		this.add(chatButton);
		this.add(chatText);
		this.setLayout(baseLayout);
		this.setBackground(Color.BLUE);
		this.add(chatArea);
		chatText.setToolTipText("Typhere for the chatbot.");
		chatArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
	}
	
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

