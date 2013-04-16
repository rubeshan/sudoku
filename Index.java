import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Index extends JFrame {
	private static final long serialVersionUID = 1L;

	public Index(){
		setLocation(470,270);
		setSize(760,452);
		setResizable(false);
		setTitle("Sudoku Purchase or Trial..");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
	
		JButton ok = new JButton("", new ImageIcon("src/trial.jpg"));
		ok.setBorder(null);
		OkButtonHandler okHandler = new OkButtonHandler();
		ok.addActionListener(okHandler);
		
		JButton purchase = new JButton("", new ImageIcon("src/purchase.jpg"));
		purchase.setBorder(null);
		PurchaseButtonHandler purchaseHandler = new PurchaseButtonHandler();
		purchase.addActionListener(purchaseHandler);
		
		
		JLabel text1 = new JLabel("Data Structures");
		
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
		ImageIcon pic = new ImageIcon("src/index.jpg");				
		JLabel image = new JLabel(pic);	
		
		pane.add(image);
		pane.add(ok);
		pane.add(purchase);
		
		pane.add(text1);
		
		Insets position = pane.getInsets();
		Dimension size = image.getPreferredSize();
		image.setBounds(0+position.left, 0+position.top, size.width, size.height);
		
		size = ok.getPreferredSize();
		ok.setBounds(290+position.left, 104+position.top, size.width-32, size.height-10);
		
		size = purchase.getPreferredSize();
		purchase.setBounds(292+position.left, 193+position.top, size.width-1, size.height-10);
		
		
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
	

	private class PurchaseButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			Purchase purchase = new Purchase();
			purchase.setVisible(true);
			setVisible(false);			
			}
		}
	
	

}
