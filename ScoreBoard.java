import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {
private static final long serialVersionUID = 1L;
Image img;JButton exit;
public ScoreBoard(){	
	

	 ImageIcon icon = new ImageIcon("src/gameboard.jpg");
     img=icon.getImage();
     
    exit  = new JButton("", new ImageIcon("src/exit.gif"));
		ExitButtonHandler searchHandler = new ExitButtonHandler();
		exit.addActionListener(searchHandler);
	
}
	public void paintComponent(Graphics g){	
		
		 g.drawImage(img,0,0,getSize().width,getSize().height,this);
	
         /*
          * 
          
			Font font=new Font("Arial",40,40);
			g.setFont(font);
			g.setColor(Color.green);
			g.drawString("Sudoko Game Board", 20, 40);
			
			g.setColor(Color.black);
			font=new Font("Arial",40,20);
			g.setFont(font);
			g.drawString("Puzzle # 129239", 120, 80);
			*/
	 
}
    
	private class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
}