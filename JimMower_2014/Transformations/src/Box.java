import MatrixMult.*;
import java.util.*;
import java.awt.*;

public class Box {
	
	ArrayList<Vector3dMM> vertices;
	Point clickPoint;
	
	public Box (Point p) {
		
		clickPoint = p;
		vertices = new ArrayList<Vector3dMM>();
		vertices.add(new Vector3dMM(1,1,1));
		vertices.add(new Vector3dMM(1,-1,1));
		vertices.add(new Vector3dMM(-1,-1,1));
		vertices.add(new Vector3dMM(-1,1,1));
		
	}
}

