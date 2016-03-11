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
	private JButton saveButton;
	private JButton loadButton;
	private JButton testButton;
	private JButton tweetButton;
	private JButton analyzeTweetButton;
	
	
	public ChatPanel(ChatController baseController)
	{
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10, 30);
		typingField = new JTextField(30);
		submitButton = new JButton("asda");
		analyzeTweetButton = new JButton("Look at tweets");
		
		setupPanel();
		setupLayout();
		setupListeners();
		setupChatPane();
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(testButton);
		this.add(textPane);
		this.add(analyzeTweetButton);
		this.add(tweetButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(typingField);
		this.setPreferredSize(new Dimension(600, 600));
	}

	private void setupChatPane()
	{
	    
	}
	
	private void setupListeners()
	{
		tweetButton.addActionListener(new ActionListener()
		{
		    public void actionPreformed(ActionEvent click)
		    {
			baseController.sendTweet("what text?");
		    }
		});
	
		analyzeTwitterButton.addActionListener(new)
	}
	
	public JButton getJButton()
	{
		return testButton;
	}
}
