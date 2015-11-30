package chat.view;

import java.awt.Color;
import java.awt.event.*;
import java.awt.color.*;
import java.util.Random;
import javax.swing.*;
import chat.controller.chatController;


public class ChatPanel extends JPanel
{
	private chatController baseController;
	private JButton chatButton;
	private JTextField chatText;
	private SpringLayout baseLayout;
	private JTextArea chatArea;
	
	public ChatPanel(chatController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		chatButton = new JButton("Start the convo!");
		chatText = new JTextField("Type yo wurds mayn!");
		baseLayout.putConstraint(SpringLayout.SOUTH, chatText, -190, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 17, SpringLayout.SOUTH, chatText);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatText);
		baseLayout.putConstraint(SpringLayout.WEST, chatText, 85, SpringLayout.WEST, this);
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
	}
	
	private void setupLayout()
	{
	}
	
		
}

