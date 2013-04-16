import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Purchase extends JFrame {
	private static final long serialVersionUID = 1L;

	public Purchase(){
		
		setLocation(470,270);
		setSize(760,452);
		setResizable(false);
		setTitle("Sudoku Purchase");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JButton ok = new JButton("", new ImageIcon("src/submit.jpg"));
		ok.setBorder(null);
		OkButtonHandler okHandler = new OkButtonHandler();
		ok.addActionListener(okHandler);
		
		JTextField Lname = new JTextField();
		Lname.setText("Login Name");
		
		JTextField Pass = new JTextField();
		Pass.setText("Password");
		
		JTextField Pass2 = new JTextField();
		Pass2.setText("Re-Type Password");
		
		JTextField Email = new JTextField();
		Email.setText("Valid e-mail address");
		
		JLabel title = new JLabel("Purchase Product");
		Font currentFont = title.getFont();
	    title.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), 24));

		JLabel lname = new JLabel("Login name");	
		JLabel pass = new JLabel("Password" );	
		JLabel pass2 = new JLabel("Re-type Password");	
		JLabel email = new JLabel("E-mail address");		
		
		ImageIcon pic = new ImageIcon("src/purchase_main.jpg");				
		JLabel image = new JLabel(pic);	
		
		ImageIcon pic2 = new ImageIcon("src/picture2.jpg");				
		JLabel image2 = new JLabel(pic2);
		
		Container pane = getContentPane();
		pane.setBackground(Color.white);
		pane.setLayout(null);
		
		pane.add(image);
		pane.add(image2);
		pane.add(ok);
		
		pane.add(title);
		
		pane.add(Lname);
		pane.add(Pass);
		pane.add(Pass2);
		pane.add(Email);
		
		pane.add(lname);
		pane.add(pass);
		pane.add(pass2);
		pane.add(email);
		
		Insets position = pane.getInsets();
		Dimension size = image.getPreferredSize();
		image.setBounds(0+position.left, 257+position.top, size.width, size.height);
		
		size = ok.getPreferredSize();
		ok.setBounds(430+position.left, 179+position.top, size.width, size.height);

		size = image2.getPreferredSize();
		image2.setBounds(360+position.left, 0+position.top, size.width, size.height);
		
		size = title.getPreferredSize();
		title.setBounds(30+position.left, 30+position.top, size.width, size.height);

		size = lname.getPreferredSize();
		lname.setBounds(40+position.left, 80+position.top, size.width, size.height);
		size = pass.getPreferredSize();
		pass.setBounds(40+position.left, 120+position.top, size.width, size.height);
		size = pass2.getPreferredSize();
		pass2.setBounds(40+position.left, 160+position.top, size.width, size.height);
		size = email.getPreferredSize();
		email.setBounds(40+position.left, 200+position.top, size.width, size.height);
		

		size = Lname.getPreferredSize();
		Lname.setBounds(190+position.left, 80+position.top, 90, size.height+10);
		size = Pass.getPreferredSize();
		Pass.setBounds(190+position.left, 120+position.top, 90, size.height+10);
		size = Pass2.getPreferredSize();
		Pass2.setBounds(190+position.left, 160+position.top, 90, size.height+10);
		size = Email.getPreferredSize();
		Email.setBounds(190+position.left, 200+position.top, 90, size.height+10);
		
		
	}
	
	private class OkButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			SudokoGUI sudokoApp = new SudokoGUI();
			SudokoGame sudokoGame = new MySudokoExample();
			sudokoApp.addUndoMenuListener(sudokoGame.getUndoActionListener());
			sudokoGame.loadData("sudoko0001.txt",sudokoApp.getSudokoPanels());
			sudokoApp.setVisible(true);
			setVisible(false);			
			}
		}

}
