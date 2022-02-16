package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import lib.FileUpload;
import lib.KeyControl;

public class CardNewsEditor extends JPanel implements KeyControl {

	private static JTextField tf, tf2;
	private static ScrollPanel sp;
	private static TextInputPanel tip, tip2;

	public CardNewsEditor(ScrollPanel sp) {
		this.sp = sp;
		setLayout(new BorderLayout());

		setPreferredSize(new Dimension(1500, 350));
		JButton addBackgroundButton = new JButton("Background");
		JButton applyBackgroundAllButton = new JButton("Apply All");

		JButton addImageButton = new JButton("Image");
		JButton addTextButton = new JButton("Edit Text");

		JPanel buttonPanel = new JPanel();

		JPanel backgroundPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		backgroundPanel.setPreferredSize(new Dimension(100, 50));
		addBackgroundButton.setMargin(new Insets(0, 10, 0, 10));
		applyBackgroundAllButton.setMargin(new Insets(0, 0, 0, 0));
		backgroundPanel.add(addBackgroundButton);
		backgroundPanel.add(applyBackgroundAllButton);
		applyBackgroundAllButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					for (CardNews c : sp.getAllCardNews()) {
						c.setBackgroundImage(curr.getBackgroundImage());
					}
				}
			}

		});

		buttonPanel.add(backgroundPanel);

		buttonPanel.add(addImageButton);
		buttonPanel.add(addTextButton);

		add(buttonPanel, BorderLayout.NORTH);
		addBackgroundButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					if (curr.getBackgroundImage() != null) {
						curr.setBackgroundImage(null);
					} else {
						FileUpload fu = new FileUpload(curr);

						if (fu.getImage() != null) {
							curr.setBackgroundImage(fu.getImage());

						}
					}
				}
			}
		});

		addImageButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					if (curr.getImage() != null) {
						curr.setImage(null);
					} else {

						FileUpload fu = new FileUpload(curr);

						if (fu.getImage() != null) {
							curr.setImage(fu.getImage());

						}
					}

				}
			}
		});

		JPanel textPanel = new JPanel();
		tf = new JTextField();
		// if mainText the third parameter is zero, else one.
		tip = new TextInputPanel(sp, tf, 0);

		tf2 = new JTextField();
		tip2 = new TextInputPanel(sp, tf2, 1);
		textPanel.setPreferredSize(new Dimension(1200, 230));
		
		
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getMainTextManager();
				tm.setOnUse(true);
				
				curr.getSubTextManager().setOnUse(false);
			}
			
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getSubTextManager();
				tm.setOnUse(true);
				
				curr.getMainTextManager().setOnUse(false);				
			}
			
		});
		textPanel.add(b1);
		textPanel.add(tip);
		
		textPanel.add(b2);
		textPanel.add(tf2);

		add(textPanel, BorderLayout.SOUTH);
		addTextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				sp.setEditImage(!sp.getEditImage());

				if (sp.getEditImage()) {
					addTextButton.setText("Edit Text");

				} else {
					addTextButton.setText("Edit Image");
				}

			}
		});

		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		getActionMap().put("enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("enter");

				tip.setCurrText(sp.getCurrCardNews().getMainTextManager(), sp.getCurrCardNews());
				tip2.setCurrText(sp.getCurrCardNews().getSubTextManager(), sp.getCurrCardNews());

				repaint();
				revalidate();

			}
		});

		setKeyListener(this, sp);

		FontBox comboPanel = new FontBox(sp);
		comboPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		add(comboPanel, BorderLayout.CENTER);
	}

	public static void refreshTF() {
		tf.setText(sp.getCurrCardNews().getMainTextManager().getContent());
		tf2.setText(sp.getCurrCardNews().getSubTextManager().getContent());
	}

	public static TextInputPanel getTip() {
		return tip;
	}

	public static TextInputPanel getTip2() {
		return tip2;
	}
}
