package chat.view;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import chat.controller.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
				String userText = typingField.getText();
				chatArea.append("/nUser: " + userText);
				typingField.setText("");
				String response = baseController.userToChatbot(userText);
				chatArea.append("/nChatbot: " + response);
			}
		});
	
	}
	
	public JTextField getTextField()
	{
		return typingField;
	}
}
