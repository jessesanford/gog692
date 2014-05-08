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
	
	int mapWidth = 1029;
	int mapHeight = 518;
	
	int RADIUS = 10;
	Point2f P1, P2;
	
	public Canvas() {
		
		img = new File("equirectangular_map_small.jpg");
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
	
	private PointLatLng Point2fToPointLatLng(Point2f myPoint) {
		
		double lat = ((myPoint.getY() / (mapHeight / 180)) - 90) / -1;
		double lng = myPoint.getX() / (mapWidth / 360) - 180;
		
		return new PointLatLng (lat, lng);
	}
	
	public static double distFrom(double lat1, double lng1, double lat2, double lng2) {
	    double earthRadius = 3958.75;
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double sindLat = Math.sin(dLat / 2);
	    double sindLng = Math.sin(dLng / 2);
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
	            * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = earthRadius * c;

	    return dist;
	}
	
	public void paintComponent( Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

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
				PointLatLng myPointLatLngP1 = Point2fToPointLatLng(myPointP1);
				PointLatLng myPointLatLngP2 = Point2fToPointLatLng(myPointP2);
				
				double distance = distFrom(myPointLatLngP1.getLat(), myPointLatLngP1.getLng(), myPointLatLngP2.getLat(), myPointLatLngP2.getLng());
				String distanceTxt = "Distance between Points is: " + String.valueOf(Math.round(distance));
				
				g2.drawString(distanceTxt, myPointP1.getX() + 5, myPointP1.getY() - 5);
				
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

