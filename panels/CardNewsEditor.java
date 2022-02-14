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
import lib.KeyControl;

public class CardNewsEditor extends JPanel implements KeyControl{

	private static JTextField tf;
	private static ScrollPanel sp;
	private static TextInputPanel tip;

	public CardNewsEditor(ScrollPanel sp) {
		this.sp = sp;
		setLayout(new BorderLayout());
		JButton addBackgroundButton = new JButton("B");
		JButton addImageButton = new JButton("I");
		JButton addTextButton = new JButton("T");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addBackgroundButton);
		buttonPanel.add(addImageButton);
		buttonPanel.add(addTextButton);

		add(buttonPanel, BorderLayout.NORTH);
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

		tf = new JTextField();
		tip = new TextInputPanel(sp, tf);

		add(tip, BorderLayout.SOUTH);
		addTextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

//				CardNews curr = sp.getCurrCardNews();
//				if (curr != null) {
//
//					repaint();
//					revalidate();
//
//				}

			}
		});

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		getActionMap().put("enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("enter");

				tip.setCurrText(sp.getCurrCardNews());

//				remove(tip);
				repaint();
				revalidate();

			}
		});
		
		setKeyListener(this,sp);
		
		FontBox comboPanel = new FontBox(sp);
		add(comboPanel,BorderLayout.CENTER);
	}

	public static void refreshTF() {
		tf.setText(sp.getCurrCardNews().getContent());
	}
	
	public static TextInputPanel getTip() {
		return tip;
	}
}
