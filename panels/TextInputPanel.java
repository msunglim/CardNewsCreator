package panels;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TextInputPanel extends JScrollPane {

	private LinkedList<String> list;
	private String html;
	private ScrollPanel sp;
	private JTextField tf;

	public TextInputPanel(ScrollPanel sp, JTextField tf) {
		super(tf);
		this.sp = sp;
		this.tf = tf;
//		 CardNews curr = sp.getCurrCardNews();
//		setList("");

		tf.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

//				curr.setText(getHTMLizedText());
//            	 list.add(""+e.getKeyChar());
//            	 System.out.println(e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				setCurrText();
				CardNews curr = sp.getCurrCardNews();
//				System.out.println("index:"+tf.getCaretPosition());
				int caret = tf.getCaretPosition();
				int s0 = curr.getColoredArea()[0];
				int s1 = curr.getColoredArea()[1];
//				System.out.println("key:"+ e.getKeyCode());

				int inputKey = e.getKeyCode();
				if (inputKey == KeyEvent.VK_BACK_SPACE) {
					System.out.println("caret:" + caret);
					if (caret <= s0) {
						curr.setColoredArea(s0 - 1, s1 - 1);
					} else if (caret > s0 && caret <= s1) {
						curr.setColoredArea(s0, s1 - 1);

					}

				} else if (inputKey != KeyEvent.VK_CAPS_LOCK && inputKey != KeyEvent.VK_SHIFT
						&& inputKey != KeyEvent.VK_SPACE && inputKey != KeyEvent.VK_CONTROL
						&& inputKey != KeyEvent.VK_ENTER && inputKey != KeyEvent.VK_UP && inputKey != KeyEvent.VK_DOWN
						&& inputKey != KeyEvent.VK_RIGHT && inputKey != KeyEvent.VK_LEFT) {
					System.out.println("Input");
					if (caret <= s0) {
						curr.setColoredArea(s0 + 1, s1 + 1);
					} else if (caret > s0 && caret <= s1) {
						curr.setColoredArea(s0, s1 + 1);

					}

				}
				// TODO Auto-generated method stub

//				System.out.println("enteredKey"+e.getKeyChar());

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		tf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {
				String selected = tf.getSelectedText();

				if (selected != null) {
					CardNews curr = sp.getCurrCardNews();
					int s0 = tf.getSelectionStart();
					int s1 = tf.getSelectionEnd();
					curr.setColoredArea(s0, s1);
					setCurrText();
//					System.out.println("s0:"+ s0 + ", s1:"+ s1);

				}

			}
		});

	}

	public void setCurrText() {
		CardNews curr = sp.getCurrCardNews();

		list = new LinkedList<>();
		list.add("<html>");
//		list.add(tf.getText());

//		System.out.println("CURRENT s0:"+ s0 + ", s1:"+ s1);
		int excuse = 0;
		int s0 = curr.getColoredArea()[0];

		int s1 = curr.getColoredArea()[1];
		System.out.println("s0:" + s0 + ", s1:" + s1);
		for (int i = 1; i < tf.getText().length() + 1; i++) {

			if (i == s0 + 1 && s0 != s1) {
				list.add(i, "<font color='red'>");
				excuse++;
				list.add(i + excuse, "" + tf.getText().charAt(i - 1));

			} else if (i == s1 && s0 != s1) {
				list.add(i + excuse, "" + tf.getText().charAt(i - 1));
				excuse++;
				list.add(i + excuse, "</font>");

			} else {
				list.add(i + excuse, "" + tf.getText().charAt(i - 1));
			}
		}
		list.add("</html>");
		curr.setText(getHTMLizedText());
		curr.setContent(tf.getText());
		System.out.println("text:" + tf.getText());
	}

	public String getHTMLizedText() {
		if (list == null)
			return null;
		html = "";

		for (int i = 0; i < list.size(); i++) {
			html += list.get(i);
//			System.out.println("add" + list.get(i));
		}
//		System.out.println("html:"+ html);

		return html;
	}

}
