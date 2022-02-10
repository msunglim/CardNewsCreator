import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.MainPanel;

public class Main {
	public static void main(String[] args)  {

		JFrame f = new JFrame();
		JPanel p = new MainPanel();

		
		f.setContentPane(p);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}


}