package chat.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chat.controller.ChatController;
import chat.controller.chatController;
import chat.view.*;;


public class ChatControllerTest
{
	private chatController testController;

	@Before
	public void setUp() throws Exception
	{
		testController = new chatController();
	}

	@After
	public void tearDown() throws Exception
	{
		testController = null;
	}

	@Test
	public void testChatController()
	{
		assertNotNull("Data member not initialized", testController.getChatbot());
		assertNotNull("Data member not initialized", testController.getChatView());
		assertTrue("Wrong display type", (testController.getChatView() instanceof ChatView));
		assertTrue("Wrong Frame type",(testController.getBaseFrame() instanceof ChatFrame));
		assertSame("wrong controller", testController, testController.getBaseFrame().getBaseController());
	}
	
	
	

}
