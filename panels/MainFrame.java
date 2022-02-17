package panels;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	public MainFrame() {

		JPanel p = new MainPanel();

		setContentPane(p);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void minimize() {
		setState(JFrame.ICONIFIED);
	}

	public void normalize() {
		setState(JFrame.NORMAL);
	}

}
