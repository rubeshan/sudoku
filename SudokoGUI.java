import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


import java.awt.event.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;


/******************************************************************************
 * <p>Title: SudokoUI</p>
 * <p>Description: Sudoko Graphical Interface</p>
 * <p>for the ENGR2710 Project</p>
 * @author Ramiro Liscano
 * @version 1.0
 */
public class SudokoGUI extends JFrame {
	private static final long serialVersionUID=1;
	static final int MAX_ROW = 3;
	static final int MAX_COL = 3;

	JMenuBar menuBar;
	JMenu menu, submenu;
	private JMenuItem menuItem,undoMenuItem;
	
	// Array of the 81 Panel squares
	JPanel[][] sudokoPanels = new JPanel[MAX_ROW*MAX_ROW][MAX_COL*MAX_COL];
	

	public SudokoGUI(){
		
		super("Sudoko Application");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(470,270);
		setPreferredSize(new Dimension(800,500));
	setResizable(false);
	   // setSize(800, 500);

		
		// Add the menu to support Undo operation
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the File menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("The File menu");
		menuBar.add(menu);
		
		// Add the reset option		
		menuItem = new JMenuItem("New");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Create New File");
		menuItem.addActionListener(
		new ActionListener(){
		public void actionPerformed(ActionEvent e){
			for (int i=0; i<SudokoGUI.MAX_ROW*SudokoGUI.MAX_ROW; i++)
				for (int j=0; j<SudokoGUI.MAX_COL*SudokoGUI.MAX_COL; j++) {					
					sudokoPanels[i][j].add(new JLabel(" "));	
					
				}
		}});		
		menu.add(menuItem);

		//Add the open option
		menuItem = new JMenuItem("Open");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("exit the program");
		menuItem.addActionListener(
		new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		loadContent();
		}});		            
		menu.add(menuItem);
		
		// Add the save Option
		menuItem = new JMenuItem("Save");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("exit the program");
		menuItem.addActionListener(
		new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		saveContent();
		}});		            
		menu.add(menuItem);
		
		//Add the Exit option.

		menuItem = new JMenuItem("Exit",KeyEvent.VK_X);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Exits the application");
		menuItem.addActionListener(
		new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0); }});
          
		menu.add(menuItem);
		
		//Add the Edit menu for Undo operations.
		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription("This menu handles editing operations");
		menuBar.add(menu);

		//Add the Undo option.

		undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		undoMenuItem.getAccessibleContext().setAccessibleDescription("Undoes any user actions");
		// Undo listener will be added by a method call
		menu.add(undoMenuItem);
		
		menuItem = new JMenuItem("Settings");
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Settings Window");
		menuItem.addActionListener(
		new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	Display display = Display.getDefault();
    		Shell shell = new Shell(display);
    		Settings inst = new Settings(shell, SWT.NULL);
    		
    		
    		Point size = inst.getSize();
    		shell.setLayout(new FillLayout());
    		shell.layout();
    		if(size.x == 0 && size.y == 0) {
    			inst.pack();
    			shell.pack();
    		} else {
    			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
    			shell.setSize(shellBounds.width, shellBounds.height);
    		}
    		shell.open();
    		while (!shell.isDisposed()) {
    			if (!display.readAndDispatch())
    				display.sleep();
    		}       	
             }});
          
		menu.add(menuItem);
		
		
		//Add the Edit menu for Undo operations.
		menu = new JMenu("Chat");
		menu.setMnemonic(KeyEvent.VK_C);
		menu.getAccessibleContext().setAccessibleDescription("This menu opens the chat window.");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Chat-arrr");
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Chatting window");
		menuItem.addActionListener(
		new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	ChatWindow chat = new ChatWindow();
        	chat.chatWindow();
             }});
          
		menu.add(menuItem);
		

		/**
		 * View Menu contains
		 * HotKeys
		 * Instructions
		 */
		
		menu = new JMenu("View");
		menu.setMnemonic(KeyEvent.VK_V);
		menu.getAccessibleContext().setAccessibleDescription("This is the View Menu");
		menuBar.add(menu);

		menuItem = new JMenuItem("HotKeys");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("View Hot Keys");
		menuItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){				
				HotKeys hotKeys = new HotKeys();
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();	
				hotKeys.setLocation(screen.width/3,screen.height/4);
				
				hotKeys.setVisible(true);
				hotKeys.setTitle("Hot Keys/ Short Cuts");
				hotKeys.setSize(470,400);	}});
		menu.add(menuItem);

		menuItem = new JMenuItem("Progress");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("View Hot Keys");
		menuItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){				
				Graph_helper graph= new Graph_helper();
				graph.setVisible(true);
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();	
				graph.setLocation(screen.width/3,screen.height/4);
				graph.setTitle("Graph viewer");
				graph.setSize(600, 650);
				graph.setResizable(false);
				
			}});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Full Screen");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("View Full Screen");
		menuItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){	
				
				
				
				java.awt.Point xloc = getLocation();
				
				if(xloc.x==-8){
				setLocation(470,270);
				setSize(new Dimension(800,500));
				setResizable(false);
				}else{
					Toolkit tk = Toolkit.getDefaultToolkit(); 				
				int xSize = ((int) tk.getScreenSize().getWidth()+50);   
				int ySize = ((int) tk.getScreenSize().getHeight()+50); 
				setLocation(-8,-30);
				setResizable(true);
				setSize(xSize,ySize);
				}
				
				///setUndecorated(true);  
				  
				 
			}});
		menu.add(menuItem);
		
		/**
		 * Help Menu contains
		 * Help Topics
		 * About
		 */
		//Add the Help menu Option
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.getAccessibleContext().setAccessibleDescription("This is the Help Menu");
		
		menuBar.add(menu);
		
		// Add the Help Topics Option
		menuItem = new JMenuItem("Help topics");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Help about the Program");
		menuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Help help = new Help();
				help.setVisible(true);
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();	
				help.setLocation(screen.width/3,screen.height/8);
				help.setResizable(false);
				
				help.setSize(500, 800);
				help.setTitle("Help Contents");				
			}});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("About");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("About this software");
		menuItem.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent e){	
				About about = new About();
				about.setVisible(true);
				Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();	
				about.setLocation(screen.width/3,screen.height/4);
				about.setTitle("About Soduku Game");
				about.setSize(470,400);	}});		
		menu.add(menuItem);
		// Listener for window closing
//		addWindowListener(new WindowClosing());
		
		// Create a 3x3 panel to hold the larger squares.
		//JButton hi = new JButton("hehe");
		
		ScoreBoard graph = new ScoreBoard();
		graph.setSize(20, 50);
		JPanel BPanel = new JPanel();
		BPanel.setLayout(new GridLayout(1,2));
		

		
		
		JPanel outerPanel = new JPanel();
		outerPanel.setLayout(new GridLayout(MAX_ROW,MAX_COL));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		outerPanel.setBorder(blackBorder);
		
		// Go through each one of the larger panels and insert sub 3x3 panels
		for(int i=0;i<MAX_ROW;i++)
			for (int j=0;j<3;j++){
				JPanel innerPanel = new JPanel();
				innerPanel.setLayout(new GridLayout(MAX_ROW,MAX_COL));
				innerPanel.setBorder(blackBorder);
				outerPanel.add(innerPanel);
				//outerPanel.add(innerPanel);

				//Go through the inner panels and create for each the
				// play panel where the numbers will go.
								
				for(int ii=0;ii<MAX_ROW;ii++)
					for (int jj=0;jj<MAX_COL;jj++){
						JPanel gamePanel = new JPanel();
						gamePanel.setBorder(blackBorder);
						gamePanel.setSize(90, 20);
						innerPanel.add(gamePanel);
						sudokoPanels[i*MAX_ROW+ii][j*MAX_COL+jj]=gamePanel;
					}
				BPanel.add(outerPanel);
			}
		
		BPanel.add(graph);
		
		setContentPane(BPanel);
		setJMenuBar(menuBar);
	    pack();
	    setVisible(true);
	}
		
	/******************************************************************************
	 * 
	 * addUndoMenuListener
	 * Method to set the Undo action listener
	 * 
	 * @author Ramiro Liscano
	 * @version 1.0
	 * @param ActionListener aListener
	 * @return void
	 * 
	 */	

	
	public void addUndoMenuListener(ActionListener aListener){
		undoMenuItem.addActionListener(aListener);
	}

	/******************************************************************************
	 * 
	 * getSudokoPanels
	 * Method to get the sudoko panels
	 * 
	 * @author Ramiro Liscano
	 * @version 1.0
	 * @param none
	 * @return JPanel[][] - The panels representing the Sudoko
	 * 
	 */	
	
	public JPanel[][] getSudokoPanels() {
		return sudokoPanels;
	}
	
	  public void loadContent() {
		  String OpenName = JOptionPane.showInputDialog("Enter the file Name to Open..");
		  try {
				DataInput f = new DataInputStream(new FileInputStream(OpenName+".txt"));
				String txt = f.readLine();
				while (txt != null) {					
					
				}
			} catch (Exception e1) {
				System.err.println("Could not load page: " + OpenName);
			}
	
			
	     }
	     
	     public void saveContent() {
	    	 String SaveName = JOptionPane.showInputDialog("Enter the file Name to Save..");
	         try {
	             FileWriter fw = new FileWriter(SaveName+".txt");
	          
	             fw.close();
	         } catch(Exception e) {
	             System.err.println("Could not save page: " + SaveName);
	         }
	     }
	
}




