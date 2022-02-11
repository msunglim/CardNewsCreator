package panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TextInputPanel extends JScrollPane {

	public TextInputPanel(ScrollPanel sp, JTextField tf) {
		super(tf);

		tf.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				String selected = tf.getSelectedText();
				System.out.println(selected);
				if (selected != null) {
				int s0 = tf.getSelectionStart();
				int s1 = tf.getSelectionEnd();

				CardNews curr = sp.getCurrCardNews();

				String currText = curr.getText();

				String tmp = currText.substring(6, 6+ s0) + "<font color='red'>" + selected + "</font>"
						+ currText.substring(s1+6, currText.length()-7);

				System.out.println("s0" + s0);
				System.out.println("curr" + currText);
				System.out.println("" + currText.substring(0, s0));

				System.out.println("selected:" + selected);
				System.out.println("" + currText.substring(s1, currText.length()));
			
					curr.setText(tmp);
				}

			}
		});

//		JScrollPane jsptf = new JScrollPane(tf);

	}
}
