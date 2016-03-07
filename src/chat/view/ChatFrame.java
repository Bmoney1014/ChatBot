package chat.view;

import javax.swing.JFrame;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		basePanel = new ChatPanel(baseController);
		this.baseController = baseController;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setTitle("Brock's Chatbot");
		this.setVisible(true);
	}

	private void setContentPane(ChatPanel basePanel2)
	{
		
	}

	public ChatController getBaseController()
	{
		return baseController;
	}
}
