import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ChatWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public void chatWindow(){
		
		setSize(590,500);
		setVisible(true);
		
		Container content = getContentPane();
		content.setLayout(null);
		content.setBackground(Color.orange);
		JLabel Title = new JLabel("Welcome to Chat Master");
		Font currentFont = Title.getFont();
	    Title.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), 24));
	   	content.add(Title);
	   	
	   	JTextArea ChatViewer = new JTextArea(18,30);
		ChatViewer.setText("The chat messages are displayed here.");		
		JScrollPane  scroll = new JScrollPane(ChatViewer);
		
		JTextArea userChat = new JTextArea(5,30);
		userChat.setText("This is for the user to insert text");
		JScrollPane  scroll2 = new JScrollPane(userChat);
		
		JTextArea contacts = new JTextArea(18, 15);
		contacts.setText("contact 1\ncontact 2\ncontact 3");
		JScrollPane scroll3 = new JScrollPane(contacts);
		
		JButton Send = new JButton("Send ");
		Send.setBackground(Color.green);
		SendButtonHandler sendhandler = new SendButtonHandler();
		Send.addActionListener(sendhandler);
		
		content.add(scroll);
		content.add(scroll2);
		content.add(scroll3);
		content.add(Send);
		
		Insets position = content.getInsets();	
		Dimension size;
		
		size= Title.getPreferredSize();
		Title.setBounds(20+position.left, 10+position.top, size.width, size.height);

		size= scroll.getPreferredSize();
		scroll.setBounds(20+position.left, 40+position.top, size.width, size.height);

		size= scroll2.getPreferredSize();
		scroll2.setBounds(20+position.left, 350+position.top, size.width, size.height);

		size= scroll3.getPreferredSize();
		scroll3.setBounds(370+position.left, 40+position.top, size.width, size.height);
		
		size= Send.getPreferredSize();
		Send.setBounds(370+position.left, 350+position.top, size.width, size.height);
		
	}
	private class SendButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		}
	}
}
