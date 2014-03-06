import javax.swing.JFrame;

public class MultiLineDrawing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Multi Line Drawing");
		frame.add(new Canvas());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

