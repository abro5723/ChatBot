package chat.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ChatView 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello Mortal!";
		chatIcon = new ImageIcon(getClass().getResource("images/dragon-021.png"));
	}
	public void showResponse(String wordsFromSomewhere)
	{
		JOptionPane.showMessageDialog(null, wordsFromSomewhere, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
	
	public String grabAnswer(String stuff)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null,stuff,windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here:)").toString();
		return answer;
	}

}


