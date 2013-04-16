import java.awt.*;
import java.awt.event.*;


public class SudokoMouseAction implements MouseListener {
	
	private static int count;

	public void mouseClicked(MouseEvent arg0) {
		Graphics paneGraphics = arg0.getComponent().getGraphics();
		paneGraphics.setFont(new Font("Dialog", Font.PLAIN, 24));
		paneGraphics.drawString((new Integer(count++)).toString(), 30, 30);
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
