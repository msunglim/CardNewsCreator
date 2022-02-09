package panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CardNews extends JPanel {

	public CardNews() {
		
		setPreferredSize(new Dimension(500,500));
		
		setBorder(BorderFactory.createLineBorder(Color.black));
		
	}
}
