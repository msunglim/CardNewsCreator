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
//	private JLabel text;
//	private String content; // content of text
//	private String fontName;
//	private String fontColor;
//	private int fontSize;
//	private int s0, s1; //highlighted area index

	final int width = 500, height = 500;

	private boolean editImage;

	public CardNews() {

//		setKeyListener(this);
		setPreferredSize(new Dimension(width, height));

		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.WHITE);
		setLayout(null);

//		String id = "" + System.currentTimeMillis();
//		JLabel l = new JLabel(id);
//	
//		add(l);

		// default coordinate of iamge
		imgX = 0;
		imgY = 0;

		// edit image is default value (use arrows/ +- keys)
		editImage = true;

//		fontColor = "red";
//		this.text = new JLabel();
//		fontName = "휴먼매직체";
//		fontSize = 20;

		mainText = new TextManager();
		subText = new TextManager();
		
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

	public void setImage(BufferedImage img) {
		if (img != null) {

			int newW = width / 2;
			int newH = height / 2;

			this.img = resizeImage(img, newW, newH);

		} else {
			this.img = null;
		}
	}

	public void resize(int size) {
		if (img == null) {
			return;
		}
		int newW = img.getWidth() + size;
		int newH = img.getHeight() + size;
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
		// tm.setFontLabel(new Font(tm.getFontName(), 1, tm.getFontSize()));

		repaint();
		revalidate();
	}

	public String getText(TextManager tm) {
		return tm.getText();
	}

	public void setFontSize(TextManager tm, int size) {

		tm.setFontSize(size);
//		this.text.setFont(new Font(fontName, 1, fontSize + size));
//		fontSize += size;

	}

	public int getTextX(TextManager tm) {
		return tm.getTextX();

	}

	public int getTextY(TextManager tm) {
		return tm.getTextY();

	}

	public void setTextX(TextManager tm,int x) {
		tm.setTextX(x);
//		text.setBounds(text.getX() + x, text.getY(), text.getWidth(), text.getHeight());
		repaint();
		revalidate();
	}

	public void setTextY(TextManager tm,int y) {

		tm.setTextY(y);
		
//		text.setBounds(text.getX(), text.getY() + y, text.getWidth(), text.getHeight());
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
//		fontName = newFont;
//		this.text.setFont(new Font(fontName, 1, fontSize));

		tm.setFontLabel(newFont);
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

	public boolean getEditImage() {
		return editImage;
	}

	public void setEditImage(boolean tf) {
		editImage = tf;
	}

	public BufferedImage getBackgroundImage() {
		return background;
	}
}
