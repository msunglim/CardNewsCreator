package panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import capture.Capture;
import capture.Save;
import lib.KeyClose;

public class MainPanel extends JPanel implements KeyClose {

	private BufferedImage img;

	private ScrollPanel sp;

	public MainPanel() {

		setKeyListener(this);

		setPreferredSize(new Dimension(1280, 720));

		JButton saveButton = new JButton("S");
		JButton addCardButton = new JButton("+");
		JButton removeCardButton = new JButton("-");
		add(saveButton);
		add(addCardButton);
		add(removeCardButton);

		sp = new ScrollPanel();
		add(sp.getScrollPane());

		sp.addCardNews();
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (sp.getCurrCardNews() != null) {
					Capture ct = new Capture(sp.getCurrCardNews());
					img = ct.getScreenshot();
					Save s = new Save(img);
				}

			}
		});

		addCardButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sp.addCardNews();

			}
		});

		removeCardButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sp.removeCardNews();

			}
		});

		CardNewsEditor cep = new CardNewsEditor(sp);
		add(cep);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}
