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

	private int s0, s1;

	public TextInputPanel(ScrollPanel sp, JTextField tf) {
		super(tf);
		this.sp = sp;
		this.tf = tf;
//		 CardNews curr = sp.getCurrCardNews();
//		setList("");

		tf.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				CardNews curr = sp.getCurrCardNews();
//				System.out.println("enteredKey"+e.getKeyChar());
				setCurrText();

//				curr.setText(getHTMLizedText());
//            	 list.add(""+e.getKeyChar());
//            	 System.out.println(e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

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
//				System.out.println(selected);
				if (selected != null) {
					s0 = tf.getSelectionStart();
					s1 = tf.getSelectionEnd();
					setCurrText();
					System.out.println("s0:"+ s0 + ", s1:"+ s1);
//					CardNews curr = sp.getCurrCardNews();
//					CardNews curr = sp.getCurrCardNews();
//					setList(tf.getText());
//					int excuse = 1;
//					for (int i = 1; i < list.size(); i++) {
//						if (list.get(i).length() > 1) {
//							excuse++;
//						} else {
//							if (i == s0 + excuse) {
//								System.out.println(i);
////								list.add(s1 + excuse, "</font>");
//
////								list.add(s0 + excuse, "<font color='red'>");
//							}
//						}
//					}

//					curr.setText(getHTMLizedText());
				}

			}
		});

//		JScrollPane jsptf = new JScrollPane(tf);

	}

	public void setCurrText() {
		CardNews curr = sp.getCurrCardNews();

		list = new LinkedList<>();
		list.add("<html>");
//		list.add(tf.getText());

		System.out.println("CURRENT s0:"+ s0 + ", s1:"+ s1);
		int excuse = 0;
		for (int i = 1; i < tf.getText().length()+1; i++) {

			
			if (i == s0+1 && s0!=s1) {
				list.add(i, "<font color='red'>");
				excuse++;
				list.add(i + excuse, "" + tf.getText().charAt(i-1));
				
				
				
				
			} else if (i == s1  && s0!=s1) {
				list.add(i + excuse, "" + tf.getText().charAt(i-1));
				excuse++;
				list.add(i + excuse, "</font>");

			} else {
				list.add(i + excuse, ""+tf.getText().charAt(i-1));
			}
		}
		list.add("</html>");
		curr.setText(getHTMLizedText());

	}

//	public void setCurrText(ScrollPanel sp, JTextField tf) {
//		CardNews curr = sp.getCurrCardNews();
//		setList(tf.getText());
//		curr.setText(getHTMLizedText());
//	}

	public void setList(String s) {
		html = "";
//		System.out.println("s:" + s);
		list = new LinkedList<>();
		list.add("<html>");
		for (int i = 0; i < s.length(); i++) {
			list.add("" + s.charAt(i));
		}
		list.add("</html>");

	}

	public String getHTMLizedText() {
		if (list == null)
			return null;
		html = "";

		for (int i = 0; i < list.size(); i++) {
			html += list.get(i);
//			System.out.println("add" + list.get(i));
		}
		System.out.println("html:"+ html);
		return html;
	}

//	public String getHTMLizedText(String s) {
//		setList(s);
//
//		for (int i = 0; i < list.size(); i++) {
//			html += list.get(i);
//		}
//		return html;
//	}
}
