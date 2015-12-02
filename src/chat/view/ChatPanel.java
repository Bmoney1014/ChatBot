package chat.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import chat.controller.ChatController;

public class ChatPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10, 30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		submitButton = new JButton("asda");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.PINK);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here to chat");
		chatArea.setEnabled(false);
	}

	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPreformed(ActionEvent click)
			{
				/**
				 * Grab user typed answer
				 * Display user answer
				 * Send the text to Chatbot
				 * Chatbot will process the conversation
				 * Display the Response
				 */
				String userText = typingField.getText();	//Grab user typed answer
				chatArea.append("\nUser: " + userText);		//display typed answer
				typingField.setText("");
				String reponse = baseController.userToChatbot(userText);	//send the tex to chatbot //chatbot will process the conversation
				chatArea.append("\nChatbot: " + response);		//display the response
			}
		});
	}
	
	public JTextField getTextField()
	{
		return TextField;
	}
}
