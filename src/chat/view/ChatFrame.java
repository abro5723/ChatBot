package chat.view;

import javax.swing.*;
import chat.controller.*;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setTitle("Dragon Bot");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
