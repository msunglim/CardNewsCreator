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

import lib.ImageResize;
import lib.KeyControl;

public class CardNews extends JPanel implements KeyControl, ImageResize {

	private BufferedImage background;
	private BufferedImage img;
	private int imgX, imgY;

	private JLabel text;
	private String content; // content of text

	final int width = 500, height = 500;

	private String fontName;
	private int fontSize;
	private boolean editImage;

	private int s0, s1;

	public CardNews() {

		setKeyListener(this);
		setPreferredSize(new Dimension(width, height));

		setBorder(BorderFactory.createLineBorder(Color.black));
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

		this.text = new JLabel();
		fontName = "Verdana";
		fontSize = 20;
		text.setBounds(0, 0, 500, 500);
		add(this.text);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				ScrollPanel.setCurrentCardNews(CardNews.this);
//				System.out.println(id);
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

	public void setBackgroundImage(BufferedImage img) {

		BufferedImage dimg = new BufferedImage(width, height, img.getType());
		Graphics2D g = dimg.createGraphics();

		g.drawImage(img, 0, 0, width, height, 0, 0, img.getWidth(), img.getHeight(), null);
		g.dispose();
		background = dimg;

	}

	public void setImage(BufferedImage img) {
		int newW = width / 2;
		int newH = height / 2;

		this.img = resizeImage(img, newW, newH);

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

	public void setText(String text) {
//		int index = text.length() / 20;
//		String tmp = "<html>";
//		for (int i = 0; i < index; i++) {
//			tmp += text.substring(i * 20, 20 * (i + 1)) + "<br/>";
//		}
//		if (index * 20 <= text.length()) {
////			System.out.println("??");
//			tmp += text.substring(index * 20, text.length());
//		}
//		tmp += "</html>";
		// String t = "<html>" + text + " </html>";
//		
		this.text.setText(text);
		this.text.setFont(new Font(fontName, 1, fontSize));

		// // this.text.setBounds(0,0,text.length()*10,text.length()*10);
////		System.out.println(tmp);
//		
//		String tt = "<html><font color='red'>" + text + "</font></html>";
//		JLabel j = new JLabel(tt);
//		j.setFont(new Font(fontName, 1, fontSize+5));
//		j.setBounds(this.text.getX(), this.text.getY(), 500,500);
//		add(j);
		repaint();
		revalidate();
	}

	public String getText() {
		return text.getText();
	}

	public void setFontSize(int size) {
		this.text.setFont(new Font(fontName, 1, fontSize + size));
		fontSize += size;
	}

	public int getTextX() {
		return text.getX();

	}

	public int getTextY() {
		return text.getY();
	}

	public void setTextX(int x) {
//		System.out.println("tex"+text.getX());
//		setLayout(null);
		text.setBounds(text.getX() + x, text.getY(), text.getWidth(), text.getHeight());
		repaint();
		revalidate();
	}

	public void setTextY(int y) {
		text.setBounds(text.getX(), text.getY() + y, text.getWidth(), text.getHeight());
		repaint();
		revalidate();

	}

	public void setImageX(int x) {
		imgX = x;
	}

	public void setImageY(int y) {
		imgY = y;
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

	public String getContent() {
		return content;
	}

	public void setContent(String s) {
		content = s;
		if(s =="") {
			setColoredArea(0,0);
		}
	}

	public void setColoredArea(int s0, int s1) {
		if (s0 >= 0) {
			this.s0 = s0;

		}
		if (s1 >= 0) {
			this.s1 = s1;

		}
	}

	public int[] getColoredArea() {
		int[] ca = { s0, s1 };
		return ca;
	}
}
