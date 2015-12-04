package chat.view;
/**
 * @author Ashton Brown
 * @version 1.0 11/27/2016
 * Frame required to create the panel.
 */
import javax.swing.*;
import chat.controller.*;

public class ChatFrame extends JFrame
{
	//creation of instances
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		//association of instances to variables
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		//setting the frames different attributes.
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setTitle("Dragon Bot");
		this.setResizable(false);
		this.setVisible(true);
	}
	/**
	 * getters and setters for Frame components
	 * @return
	 */
	public ChatController getBaseController()
	{
		return baseController;
	}

	public ChatPanel getBasePanel()
	{
		return basePanel;
	}

	public void setBasePanel(ChatPanel basePanel)
	{
		this.basePanel = basePanel;
	}

	public void setBaseController(ChatController baseController)
	{
		this.baseController = baseController;
	}
	
}
