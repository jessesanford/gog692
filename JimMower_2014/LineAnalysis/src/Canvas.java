import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Canvas extends JComponent implements MouseListener { 
	
	
	int RADIUS = 5;
	Point P1, P2;
	
	
	public Canvas() {
		P1 = null;
		P2 = null;	
		
		addMouseListener(this);	
	}
	
	
	public void paintComponent( Graphics g) {
		Graphics2D g2 = (Graphics2D)g; 
		g2.drawLine(P1.x, P1.y, P2.x, P2.y);
		//g2.drawString(a, b, c);
		if (P1 != null) {
		     g2.fillArc(P1.x, P1.y, RADIUS * 2, RADIUS * 2, 0, 360);
		if (P2 != null) {
			g2.fillArc(P2.x, P2.y, RADIUS * 2, RADIUS * 2, 0, 360);
		     }
		}	

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Clicked at " + e.getX() + ", " + e.getY());
		
		if (P1 == null) {
		     P1 = e.getPoint();
		} else {
		
		if (P2 == null) {
			P2 = e.getPoint();
		}
		}

		repaint();

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

