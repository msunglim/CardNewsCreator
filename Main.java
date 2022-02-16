import java.awt.AWTException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import capture.Screenshot;
import panels.MainPanel;

public class Main {
	public static void main(String[] args) throws AWTException, IOException {

		JFrame f = new JFrame();
		JPanel p = new MainPanel();

		f.setContentPane(p);

		Screenshot sc =new Screenshot();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

}