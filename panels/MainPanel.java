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

	int x = 0;

	public MainPanel()  {
		
		setKeyListener(this);
		
		setPreferredSize(new Dimension(1280, 720));

		JButton saveButton = new JButton("Save");
		JButton addCardButton = new JButton("+");
		JButton removeCardButton = new JButton("Remove Curr");
		add(saveButton);
		add(addCardButton);
		add(removeCardButton);

		ScrollPanel sp = new ScrollPanel();
		add(sp.getScrollPane());
		
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Capture ct = new Capture(MainPanel.this);
				img = ct.getScreenshot();
				Save s = new Save(img);

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
		

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}
