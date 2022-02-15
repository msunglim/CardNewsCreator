package panels;

import java.awt.BorderLayout;
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

		setPreferredSize(new Dimension(1580, 920));
		setLayout(new BorderLayout());
		
		JButton saveButton = new JButton("S");
		JButton addCardButton = new JButton("+");
		JButton removeCardButton = new JButton("-");
		JPanel btp = new JPanel();
		
		btp.add(saveButton);
		btp.add(addCardButton);
		btp.add(removeCardButton);

		add(btp, BorderLayout.NORTH);
		
		
		sp = new ScrollPanel();
		add(sp.getScrollPane(), BorderLayout.CENTER);

		sp.addCardNews();
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (sp.getCurrCardNews() != null) {
					
					for(CardNews c : sp.getAllCardNews()) {
						Capture ct = new Capture(c);
						img = ct.getScreenshot();
						Save s = new Save(img);	
					}
					
				}

			}
		});

		addCardButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sp.addCardNews();
				CardNewsEditor.refreshTF();

			}
		});

		removeCardButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sp.removeCardNews();

			}
		});

		CardNewsEditor cep = new CardNewsEditor(sp);
		add(cep, BorderLayout.SOUTH);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

}
