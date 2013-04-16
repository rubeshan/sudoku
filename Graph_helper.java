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
public class Graph_helper extends JFrame{
	private static final long serialVersionUID = 1L;

	JLabel VLabel, HLabel, title;
	

	public Graph_helper(){
	;
		
		 VLabel = new JLabel("Progress");
		 HLabel = new JLabel("# of Games");
		 
	 title = new JLabel(VLabel.getText()+" VS. "+HLabel.getText()+".");
	Font currentFont = title.getFont();	
    title.setFont(new Font(currentFont.getFontName(), currentFont.getStyle(), 30));
    ImageIcon yAxis = new ImageIcon("src/VR.jpg");				
	JLabel VR = new JLabel(yAxis);
	ImageIcon xAxis = new ImageIcon("src/HR.jpg");				
	JLabel HR = new JLabel(xAxis);
	
	JLabel hLabel = new JLabel("Horizontal Axies =");
	JLabel vLabel = new JLabel("Vertical Axies      =");
	
	
	JButton close = new JButton("CLOSE");
	CloseButtonHandler closeHandler = new CloseButtonHandler();
	close.addActionListener(closeHandler);	

	JButton Print = new JButton("PRINT");
	PrintButtonHandler PrintHandler = new PrintButtonHandler();
	Print.addActionListener(PrintHandler);	
	
	
	Graph_maker graph = new Graph_maker();  
    Container pane = (Container) getContentPane().add(graph);
	pane.setLayout(null);	
	 
	pane.add(title);
	pane.add(VR);
	pane.add(HR);
	pane.add(close);
	pane.add(Print);
	pane.add(hLabel);
	pane.add(vLabel);
	pane.add(HLabel);
	pane.add(VLabel);
	
	Insets position = pane.getInsets();
	Dimension size = VR.getPreferredSize();
	VR.setBounds(50+position.left, 60+position.top, 5, 400);
	
	size = VR.getPreferredSize();
	VR.setBounds(60+position.left, 100+position.top, 5, 400);

	size = title.getPreferredSize();
	title.setBounds(110+position.left, 30+position.top,  size.width, size.height);
	
	size = HR.getPreferredSize();
	HR.setBounds(62+position.left, 500+position.top,  size.width-305, size.height);

	size = close.getPreferredSize();
	close.setBounds(490+position.left, 600+position.top, 75, 20);
	size = Print.getPreferredSize();
	Print.setBounds(410+position.left, 600+position.top, 70, 20);

	size = vLabel.getPreferredSize();
	vLabel.setBounds(30+position.left, 560+position.top, size.width, size.height);
	size = hLabel.getPreferredSize();
	hLabel.setBounds(30+position.left, 580+position.top, size.width, size.height);
	size = VLabel.getPreferredSize();
	VLabel.setBounds(140+position.left, 560+position.top, size.width+50, size.height);
	size = HLabel.getPreferredSize();
	HLabel.setBounds(140+position.left, 580+position.top, size.width+50, size.height);
	
}
	public static int[] ExportPoints(){
		
	int[] yPoints={500,400,300,190,400};
		return yPoints;
	}
	private class CloseButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){			
					setVisible(false);
			}
		}
	private class PrintButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
	
			}
		}

	
}
