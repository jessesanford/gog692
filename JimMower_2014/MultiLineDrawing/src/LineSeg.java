import java.awt.*;
public class LineSeg {
	private Point2f P1;
	private Point2f P2;
	private float a;
	private float b;
	private float c;
	private double length;
	
	public LineSeg(int startx, int starty, int endx, int endy) {
		P1 = new Point2f(startx, starty);
		P2 = new Point2f(endx, endy);
		calculateCoefficients();
	}
	public LineSeg(Point2f s, Point2f e) {
		P1 = s;
		P2 = e;
		calculateCoefficients();
	}
	private void calculateCoefficients() {
		a = P1.getY() - P2.getY();
		b = P2.getX() - P1.getX();
		c = P1.getX() * P2.getY() - P2.getX() * P1.getY();
		length = (float)Math.sqrt(a*a + b*b);	
	}
	
	public Point2f getP1() {
		return P1;
	}
	public Point2f getP2() {
		return P2;
	}
	
	public void setP1(int x, int y) {
		P1 = new Point2f(x,y);
		calculateCoefficients();
	}
	
	public void setP1(Point2f p) {
		P1 = p;
		calculateCoefficients();
	}
	
	public void setP2(int x, int y) {
		P2 = new Point2f(x,y);
		calculateCoefficients();
	}
	
	public void setP2(Point2f p) {
		P2 = p;
		calculateCoefficients();
	}
	
	public float getA() {
		return a;
	}
	public float getB() {
		return b;
	}
	public float getC() {
		return c;
	}
	public double getLength() {
		return length;
	}
	
}
