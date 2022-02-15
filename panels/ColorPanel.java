package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	public ColorPanel(ScrollPanel sp) {
		setPreferredSize(new Dimension(100, 50));
		setBorder(BorderFactory.createLineBorder(Color.black));

		String[] colorList = { "#000000", "#0000FF", "green", "00FFFF", "red", "#FF00FF", "yellow", "white" };
		int index = 0;
		int r = 0;
		for (int i = 0; i < 2; i++) {
			int g = 0;
			for (int j = 0; j < 2; j++) {
				int b = 0;
				for (int k = 0; k < 2; k++) {
					ColorBox cb = new ColorBox(sp, r, g, b, colorList[index]);
					index++;
					b += 255;
					add(cb);
				}
				g += 255;
			}

			r += 255;
		}
	}
}

class ColorBox extends JPanel {
	private int r, g, b;
	private String color;

	public ColorBox(ScrollPanel sp, int r, int g, int b, String color) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.color = color;
		setPreferredSize(new Dimension(15, 15));
		setBackground(new Color(r, g, b));
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				CardNews curr = sp.getCurrCardNews();
				TextManager currTM = curr.getMainTextManager().getOnUse() ? curr.getMainTextManager()
						: curr.getSubTextManager();
				
				curr.setFontColor(currTM, color);
				if(currTM == curr.getMainTextManager()) {
					System.out.println("Main");
					CardNewsEditor.getTip().setCurrText(currTM, sp.getCurrCardNews());
				}else {
					System.out.println("Sub");
					CardNewsEditor.getTip2().setCurrText(currTM, sp.getCurrCardNews());
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

}