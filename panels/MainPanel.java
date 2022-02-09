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

public class MainPanel extends JPanel {

	private BufferedImage img;

	int x = 0;

	public MainPanel() {

		setPreferredSize(new Dimension(1280, 720));

		JButton saveButton = new JButton("Save");
		JButton addCardButton = new JButton("+");
		add(saveButton);
		add(addCardButton);

		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Capture ct = new Capture(MainPanel.this);
				img = ct.getScreenshot();
				Save s = new Save(img);

			}
		});

		addCardButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
			}
		});
		

		ScrollPanel sp = new ScrollPanel();
		add(sp.getScrollPane());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}
