package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * Popup display class for GUI interaction in the Chatbot project.
 * @author Brock Hostetter
 *@version 1.3 11/5/15 Added icons to popup windows!
 */

public class ChatView 
{
	private String message;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		message = "Hello from your friendly chatbot:D";
		chatIcon = new ImageIcon(getClass().getResource("Images/BausKitty.png"));
	}
	
	public String grabInput(String displayText)
	{
		String returnedText = "";
		
		displayText = JOptionPane.showInputDialog(null, displayText, message, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		
		return returnedText;
	}
		public void displayText(String displayText)
		{
			JOptionPane.showMessageDialog(null, displayText, message, JOptionPane.INFORMATION_MESSAGE,chatIcon);
		}
}
