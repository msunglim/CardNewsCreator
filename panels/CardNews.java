package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lib.KeyControl;

public class CardNews extends JPanel implements KeyControl {

	private BufferedImage background;
	private BufferedImage img;
	private JLabel text;

	final int width =500, height=500;
	public CardNews() {

		setKeyListener(this);
		setPreferredSize(new Dimension(width, height));

		setBorder(BorderFactory.createLineBorder(Color.black));

		String id = "" + System.currentTimeMillis();
		JLabel l = new JLabel(id);
		add(l);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				ScrollPanel.setCurrentCardNews(CardNews.this);
//				System.out.println(id);
			}
		});

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

		g.drawImage(img, 0, 0, this);
	
		repaint();
		revalidate();
	}

	public void setBackgroundImage(BufferedImage img) {
		
		BufferedImage dimg = new BufferedImage(width, height, img.getType());  
	    Graphics2D g = dimg.createGraphics();  
	    
	    g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(), img.getHeight(), null);  
	    g.dispose();  
	    background = dimg;
	    
	}

	public void setImage(BufferedImage img) {
		BufferedImage dimg = new BufferedImage(width/2, height/2, img.getType());  
	    Graphics2D g = dimg.createGraphics();  
	    
	    g.drawImage(img, 0, 0, width/2, height/2, 0, 0, img.getWidth(), img.getHeight(), null);  
	    g.dispose();  
	    this.img = dimg;
	}

	public void setText(String text) {
		this.text = new JLabel(text);
		this.text.setFont(new Font("Verdana", 1, 20));
		add(this.text);

		repaint();
		revalidate();
	}
}
