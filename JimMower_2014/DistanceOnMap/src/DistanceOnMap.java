import javax.swing.JFrame;

public class DistanceOnMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Distance On Map");
		frame.add(new Canvas());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1029, 518);
		frame.setVisible(true);
	}
}

