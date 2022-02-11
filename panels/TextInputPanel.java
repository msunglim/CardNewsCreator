package panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TextInputPanel extends JScrollPane{

	public TextInputPanel(CardNewsEditor cwe, JTextField tf){
		super(tf);
		
		tf.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				System.out.println(e);
				System.out.println(tf.getSelectedText());
			}
		});

//		JScrollPane jsptf = new JScrollPane(tf);

	}
}
