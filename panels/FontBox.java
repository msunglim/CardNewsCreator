package panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class FontBox extends JPanel {

	public FontBox(ScrollPanel sp) {
		setPreferredSize(new Dimension(300,50));
		String[] fontlist = { "휴먼매직체", "HY견명조", "HY엽서M","Gazzarelli" };
		JComboBox fontList = new JComboBox(fontlist);
//		fontList.setUI(new BasicComboBoxUI());
		fontList.setSelectedIndex(0);
		fontList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox) e.getSource();
				String fontName = (String) cb.getSelectedItem();
				
				sp.getCurrCardNews().setFont(fontName);
			
			}

		});
		add(fontList);
		
		//current font apply all cardnews button
		JButton fabt = new JButton("Apply All");
		fabt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<CardNews> list = sp.getAllCardNews();
				
				String font = sp.getCurrCardNews().getFontName();
				
				for(CardNews c : list) {
					c.setFont(font);
				}
			}
			
		});
		add(fabt);
		
		
		
		ColorPanel cp = new ColorPanel(sp);
		add(cp);
		
		
	}
}
