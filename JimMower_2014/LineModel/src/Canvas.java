import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Canvas extends JComponent implements MouseListener {
	Point start, end;
	
	public Canvas() {
		// Create a line extending from P1 = (0.0,0.0) to P2 = (3.0,4.0)
		Point2f s = new Point2f(0f,0f); 
		Point2f e = new Point2f(3f,4f);
		LineSeg testLS = new LineSeg(s,e);
		System.out.println("a = " + testLS.getA() + ", b = " +
		          testLS.getB() + " c = " + testLS.getC());
		System.out.println("length = " + testLS.getLength());

	}
	
	public void paintComponent() {
		//Graphics2D g2 = (Graphics2D) g;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
