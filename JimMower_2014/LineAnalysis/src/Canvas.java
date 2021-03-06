import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JComponent implements MouseListener { 
	
	int RADIUS = 10;
	Point2f P1, P2;
	
	public Canvas() {
		P1 = null;
		P2 = null;	
		
		addMouseListener(this);	
	}
	
	public void paintComponent( Graphics g) {
		Graphics2D g2 = (Graphics2D)g; 
		
		if (P1 != null) {
		    g2.fillArc((int) P1.getX() - (RADIUS/2), (int) P1.getY() - (RADIUS/2), RADIUS, RADIUS, 0, 360);
		}    
		if (P2 != null) {
			g2.fillArc((int) P2.getX() - (RADIUS/2), (int) P2.getY() - (RADIUS/2), RADIUS, RADIUS, 0, 360);   
		}	
		if (P1 != null && P2 != null) {
			LineSeg L1 = new LineSeg((int) P1.getX(), (int) P1.getY(), (int) P2.getX(), (int) P2.getY()); 
			g2.drawLine((int) P1.getX(),(int) P1.getY(),(int) P2.getX(),(int) P2.getY());
			g2.drawString(" a = " + L1.getA() + " b = " + L1.getB() + " c = " + L1.getC(), P2.getX() + RADIUS, P2.getY()); 
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Point MyPoint = e.getPoint();
		
		System.out.println("Clicked at x " + MyPoint.getX() + ",y " + MyPoint.getY());
		
		if (P1 == null) {
		     P1 = new Point2f((float) MyPoint.getX(), (float) MyPoint.getY());
		} else {
			if (P2 == null) {
				P2 = new Point2f((float) MyPoint.getX(), (float) MyPoint.getY());
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

