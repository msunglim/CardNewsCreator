package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import lib.ImageResize;

public class CardNews extends JPanel implements ImageResize {

	private BufferedImage background;
	private BufferedImage img;
	private int imgX, imgY;

	private TextManager mainText, subText;

	final int width = 500, height = 500;

//	private boolean editImage;

	public CardNews() {

//		setKeyListener(this);
		setPreferredSize(new Dimension(width, height));

		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.WHITE);
		setLayout(null);

		imgX = 0;
		imgY = 0;

//		editImage = true;


		mainText = new TextManager();
		subText = new TextManager();

		mainText.setFontSize(65);
		mainText.setTextY(-100);
		subText.setFontSize(15);
		subText.setTextY(100);
		add(mainText.getTextLabel());
		add(subText.getTextLabel());

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				ScrollPanel.setCurrentCardNews(CardNews.this);

//				setKeyListener(CardNews.this);
				setFocusable(true);
				CardNewsEditor.refreshTF();
			}
		});

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, this);

		g.drawImage(img, imgX, imgY, this);

		repaint();
		revalidate();
	}
	public TextManager getCurrTextManager() {
		return (mainText.getOnUse())? mainText : subText;
	}
	public TextManager getMainTextManager() {
		return mainText;
	}
	public TextManager getSubTextManager() {
		return subText;
	}

	public void setBackgroundImage(BufferedImage img) {

		if (img != null) {

			BufferedImage dimg = new BufferedImage(width, height, img.getType());
			Graphics2D g = dimg.createGraphics();

			g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(), img.getHeight(), null);
			g.dispose();

			background = dimg;

		} else {
			background = null;
		}
	}
	
	//it would be null
	public void setImage(BufferedImage img) {
		
			this.img = null;
		
	}
	public void setImage(BufferedImage img, int newW, int newH) {
		if (img != null) {

//			int newW = width / 2;
//			int newH = height / 2;

			this.img = resizeImage(img, newW, newH);

		} else {
			this.img = null;
		}
	}

	public void resize(int size) {
		if (img == null) {
			return;
		}
		double constant = (size >0)? 1.5 : 0.75;
		int newW = (int)(img.getWidth() * constant);
		int newH = (int) (img.getHeight() * constant);
		if (newW <= 0 || newH <= 0) {
			return;
		}

		img = resizeImage(img, newW, newH);
	}

	public String getFontColor(TextManager tm) {
		return tm.getFontColor();
	}

	public void setFontColor(TextManager tm, String c) {
//		fontColor = c;
		tm.setFontColor(c);
	}

	public void setText(TextManager tm, String text) {

		tm.setText(text);

		repaint();
		revalidate();
	}

	public String getText(TextManager tm) {
		return tm.getText();
	}

	public void setFontSize(TextManager tm, int size) {

		tm.setFontSize(size);

	}

	public int getTextX(TextManager tm) {
		return tm.getTextX();

	}

	public int getTextY(TextManager tm) {
		return tm.getTextY();

	}

	public void setTextX(TextManager tm,int x) {
		tm.setTextX(x);
		repaint();
		revalidate();
	}

	public void setTextY(TextManager tm,int y) {

		tm.setTextY(y);
		
		repaint();
		revalidate();

	}

	public String getContent(TextManager tm) {
		return tm.getContent();
	}

	public void setContent(TextManager tm,String s) {
//		content = s;
		tm.setContent(s);
		if (s == "") {
			tm.setColoredArea(0, 0);
		}
	}

	public void setColoredArea(TextManager tm, int s0, int s1) {
		tm.setColoredArea(s0, s1);
	}

	public int[] getColoredArea(TextManager tm) {
//		int[] ca = { s0, s1 };
		return tm.getColoredArea();
	}

	public void setFontLabel(TextManager tm, String newFont) {

		tm.setFontLabel(newFont);
//		System.out.println(newFont);
		repaint();
		revalidate();
	}

	public String getFontName(TextManager tm) {
		return tm.getFontName();
	}

	public void fontSize(TextManager tm,int size) {
//		fontSize = size;
		tm.setFontSize(size);
	}

	public int getFontSize(TextManager tm) {
		return tm.getFontSize();
	}

	public void setImageX(int x) {
		imgX = x;
	}

	public void setImageY(int y) {
		imgY = y;
	}

	public BufferedImage getImage() {
		return img;
	}

	public int getImageX() {
		return imgX;
	}

	public int getImageY() {
		return imgY;
	}

//	public boolean getEditImage() {
//		return editImage;
//	}
//
//	public void setEditImage(boolean tf) {
//		editImage = tf;
//	}

	public BufferedImage getBackgroundImage() {
		return background;
	}
}
