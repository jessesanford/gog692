import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Canvas extends JComponent implements MouseListener { 
	
	private ArrayList<LineSeg> lineSegs;
	private File img;
	private BufferedImage bimg;
	private Graphics g;
	
	int RADIUS = 10;
	Point2f P1, P2;
	
	public Canvas() {
		
		img = new File("map.png");
		try
		{
			bimg = ImageIO.read(img);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		lineSegs = new ArrayList<LineSeg>();
		
		P1 = null;
		P2 = null;	
		
		addMouseListener(this);	
	}
	

	public void paintComponent( Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		//g = bimg.createGraphics();
		//System.out.println(g.toString());
		
		g2.drawImage(bimg, null, 0, 0);
		
		if (P1 != null) {
		    g2.fillArc((int) P1.getX() - (RADIUS/2), (int) P1.getY() - (RADIUS/2), RADIUS, RADIUS, 0, 360);
		}    
		if (P2 != null) {
			g2.fillArc((int) P2.getX() - (RADIUS/2), (int) P2.getY() - (RADIUS/2), RADIUS, RADIUS, 0, 360);   
		}	
		if (P1 != null && P2 != null) {
			LineSeg L1 = new LineSeg((int) P1.getX(), (int) P1.getY(), (int) P2.getX(), (int) P2.getY()); 
			lineSegs.add(L1);
	
			
			for (int i = 0; i < lineSegs.size(); i++) {
					
				LineSeg myCurrentLineSeg = lineSegs.get(i);
				Point2f myPointP1 = myCurrentLineSeg.getP1();
				Point2f myPointP2 = myCurrentLineSeg.getP2();
				g2.fillArc((int) myPointP1.getX() - (RADIUS/2), (int) myPointP1.getY() - (RADIUS/2), RADIUS, RADIUS, 0, 360);
				g2.fillArc((int) myPointP2.getX() - (RADIUS/2), (int) myPointP2.getY() - (RADIUS/2), RADIUS, RADIUS, 0, 360);
				g2.drawLine((int) myPointP1.getX(), (int) myPointP1.getY(), (int) myPointP2.getX(), (int) myPointP2.getY());

			}
			
			P1 = null;
			P2 = null;
			
			
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

