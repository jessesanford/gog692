import javax.swing.JFrame;

public class LineAnalysis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Line Analysis");
		frame.add(new Canvas());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

