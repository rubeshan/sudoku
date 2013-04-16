import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class HotKeys extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public HotKeys(){
		
	    setSize(500,500);
	    setVisible(true);
	   setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	  
		   String data[][] = {{"Open","Ctrl + O"},
				   			  {"New ","Ctrl + N"},
				   			  {"Save", "Ctrl + S"},
				   			  {"Exit ","Ctrl + Q"},
				   			  {"Undo", "Ctrl + Z"},
				   			  {"Hot Keys", "Alt + H"},
				   			  {"FullScreen", "Alf + F"},
				   			  {"About", "Ctrl + F2"},
				   			  {"Help Topics", "Alf + F1"},
				   			  };
		   String col[] = {"Functions.","ShortCuts"};
		   
		   DefaultTableModel model = new DefaultTableModel(data,col);
		    JTable table = new JTable(model);
	
		    model.insertRow(0,new Object[]{"Functions","ShortCuts"});
		    
		    Container pane = getContentPane();
			pane.setLayout(null);
			
		    pane.add(table);
		    
			Insets position =pane.getInsets();
			Dimension size = table.getPreferredSize();
			table.setBounds(12+position.left, 10+position.top, size.width+280, size.height);
		
	}

}
