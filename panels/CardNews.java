package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardNews extends JPanel{

	public CardNews() {

		setPreferredSize(new Dimension(500, 500));
		setBorder(BorderFactory.createLineBorder(Color.black));

		String id = ""+System.currentTimeMillis();
		JLabel l = new JLabel(id);
		add(l);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				ScrollPanel.setCurrentCardNews(CardNews.this);
//				System.out.println(id);
			}
		});

	}
}
