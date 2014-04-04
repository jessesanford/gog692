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
	
	}
	
	public void paintComponent( Graphics g) {
		Graphics2D g2 = (Graphics2D)g; 
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		boxes.add(new Box(e.getPoint()));
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

