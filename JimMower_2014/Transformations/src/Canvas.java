import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import MatrixMult.*;

public class Canvas extends JComponent implements MouseListener, MouseMotionListener {
	
	ArrayList<Box> boxes;
	
	public Canvas () {
			
		addMouseListener(this);	
		addMouseMotionListener(this);
		
		boxes = new ArrayList<Box>();
	
	}
	
	public void paintComponent( Graphics g) {
		Graphics2D g2 = (Graphics2D)g; 
		
		for (int i = 0; i < boxes.size(); i++) {
			Box aBox = boxes.get(i); 
			g2.drawLine((int)aBox.vertices.get(0).x + aBox.clickPoint.x,
			       (int)aBox.vertices.get(0).y + aBox.clickPoint.y,
			       (int)aBox.vertices.get(1).x + aBox.clickPoint.x,
			       (int)aBox.vertices.get(1).y + aBox.clickPoint.y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	   
	    Box mybox = new Box(arg0.getPoint());
		boxes.add(mybox);
		
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

