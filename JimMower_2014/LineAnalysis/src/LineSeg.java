
public class LineSeg {
	private Point2f P1;
	private Point2f P2;
	private float a;
	private float b;
	private float c;
	private float length;
	
	
	public LineSeg(Point2f myP1, Point2f myP2) {
		P1 = myP1; 
		P2 = myP2;
		calculateCoefficients(myP1, myP2);
	}
	
	private void calculateCoefficients(Point2f myPoint1, Point2f myPoint2) {
		float x1 = myPoint1.getX();
		float x2 = myPoint2.getX();
		float y1 = myPoint1.getY();
		float y2 = myPoint2.getY();
		
		this.a = y1 - y2;
		this.b = x2 - x1;
		this.c = (x1 * y2) - (x2 * y1);
		this.length = (float) Math.sqrt((a * a) + (b * b)); 	
		
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
	public float getLength() {
		return length;
	}
	public Point2f getP1() {
		return P1;
	}
	
	public Point2f getP2() {
		return P2;
	}
}
