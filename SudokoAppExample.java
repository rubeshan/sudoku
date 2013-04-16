
/******************************************************************************
 * <p>Title: Sudoko Application Example</p>
 * <p>Description: Starts the Sudoko application</p>
 * <p>for the ENGR2710 Project</p>
 * @author Ramiro Liscano
 * @version 1.0
 */
public class SudokoAppExample {
	
	/****************************************************************************
	 * Start of execution
	 * @param args String[] (not used)
	 */
	public static void main(String args[]) {
		
		// Create your Sudoko Game
		Index index = new Index();
		index.setVisible(true);
		
		SudokoGUI sudokoApp = new SudokoGUI();
		sudokoApp.setVisible(false);
		SudokoGame sudokoGame = new MySudokoExample();
		sudokoApp.addUndoMenuListener(sudokoGame.getUndoActionListener());
		sudokoGame.loadData("sudoko0001.txt",sudokoApp.getSudokoPanels());
		
		}
}
