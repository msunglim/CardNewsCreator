package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import lib.FileUpload;

public class CardNewsEditor extends JPanel {

	public CardNewsEditor(ScrollPanel sp) {

		setLayout(new BorderLayout());
		JButton addBackgroundButton = new JButton("B");
		JButton addImageButton = new JButton("I");
		JButton addTextButton = new JButton("T");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addBackgroundButton);
		buttonPanel.add(addImageButton);
		buttonPanel.add(addTextButton);

		add(buttonPanel, BorderLayout.CENTER);
		addBackgroundButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					FileUpload fu = new FileUpload(curr);

					if (fu.getImage() != null) {
						curr.setBackgroundImage(fu.getImage());

					}
				}
			}
		});

		addImageButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					FileUpload fu = new FileUpload(curr);

					if (fu.getImage() != null) {
						curr.setImage(fu.getImage());

					}
				}
			}
		});

		JTextField tf = new JTextField(50);
		TextInputPanel tip = new TextInputPanel(this, tf);
//		tf.addMouseListener(new MouseAdapter() {
//			public void mouseReleased(MouseEvent e) {
//				System.out.println(e);
//				System.out.println(tf.getSelectedText());
//			}
//		});

//		JScrollPane jsptf = new JScrollPane(tf);

		
		addTextButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {

				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {

					if (java.util.Arrays.asList(getComponents()).contains(tip)) {
						remove(tip);
						
					} else {

						add(tip, BorderLayout.SOUTH);
					}
					repaint();
					revalidate();
					// curr.setText("aaaa");

				}

			}
		});

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		getActionMap().put("enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("enter");
				sp.getCurrCardNews().setText(tf.getText());
				remove(tip);
				repaint();
				revalidate();

			}
		});
	}

}
