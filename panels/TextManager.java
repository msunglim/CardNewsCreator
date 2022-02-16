package panels;

import java.awt.Font;

import javax.swing.JLabel;

public class TextManager {
	private JLabel text;
	private String content; // content of text
	private String fontName;
	private String fontColor;
	private int fontSize;
	private int s0, s1; //highlighted area index
	private boolean onUse;
	
	public TextManager() {
		fontColor = "red";
		text = new JLabel();

		text.setBounds(0, 0, 500, 500);
		
		onUse = false;
	}
	public void setOnUse(boolean tf) {
		onUse = tf;
	}
	
	public boolean getOnUse() {
		return onUse;
	}
	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String c) {
		fontColor = c;
	}

	public void setText(String text) {

		this.text.setText(text);
		this.text.setFont(new Font(fontName, 1, fontSize));

	}

	public JLabel getTextLabel() {
		return text;
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

		text.setBounds(text.getX() + x, text.getY(), text.getWidth(), text.getHeight());

	}

	public void setTextY(int y) {

		text.setBounds(text.getX(), text.getY() + y, text.getWidth(), text.getHeight());
	

	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String s) {
		content = s;
		if (s == "") {
			setColoredArea(0, 0);
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

	public void setFontLabel(String newFont) {
		fontName = newFont;
		text.setFont(new Font(fontName, 1, fontSize));

	
	}
	public String getFontName() {
		return fontName;
	}

	public void fontSize(int size) {
		fontSize = size;
	}

	public int getFontSize() {
		return fontSize;
	}
}
