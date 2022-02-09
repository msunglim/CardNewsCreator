package panels;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScrollPanel extends JPanel{

	public ScrollPanel() {

		setPreferredSize(new Dimension(1380, 500));
		
	}
	
	public JScrollPane getScrollPane() {
	
		JScrollPane sp = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(1280,500));
		
		return sp;
	}
	public void addCardNews() {
		
		CardNews cn = new CardNews();
		add(cn);
	}
}
