package chat.view;

import javax.swing.*;
import chat.controller.*;

public class ChatFrame extends JFrame
{
	private chatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(chatController baseController)
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
	
	public chatController getBaseController()
	{
		return baseController;
	}
}
