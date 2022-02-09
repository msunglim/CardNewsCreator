package panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ScrollPanel extends JPanel {

	private JScrollPane sp;
	private JScrollBar sb;

	// current edited cardnews
	private static CardNews curr;

	private ArrayList<CardNews> list;

	public ScrollPanel() {

		
		setPreferredSize(new Dimension(500, 500));
		setLayout(new FlowLayout(FlowLayout.LEFT));

		sp = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sb = sp.getHorizontalScrollBar();

		list = new ArrayList<>();
	}

	public JScrollPane getScrollPane() {

		sp.setPreferredSize(new Dimension(1280, 500));

		return sp;
	}

	/*
	 * add to scroll panel, card list, set the new one as current card, expand
	 * scrollpanel, repaint.
	 */
	public void addCardNews() {

		CardNews cn = new CardNews();
		
		add(cn);

		list.add(cn);
		curr = cn;

		moveScrollBar(500);


	}

	public static void setCurrentCardNews(CardNews cd) {
		curr = cd;
	}

	/*
	 * remove current card and set previous card as curr if previous card doesn't
	 * exist, set the next as curr, if it also doesn't exist, set curr= null
	 */
	public void removeCardNews() {
		
		if(list.size()<=0) {
//		System.out.println("impossible");
			return;
		}
		remove(curr);
		if (list.size() == 1) {
			list.remove(curr);
			curr = null;
		
		} else {
			int index = list.indexOf(curr);
			list.remove(curr);
			System.out.println("index"+index);

			if(index ==0) {
			
				curr = list.get(index);
			}else {
				
				curr = list.get(index-1);
			}
			
		}

//		System.out.println(list.size());

		
		
		
		moveScrollBar(-500);
	}

	private void moveScrollBar(int newWidth) {
		// move scrollbar as one card added so that user can see the new one.
		setPreferredSize(new Dimension(getWidth()+newWidth, 500));
		
	
		sb.setValue(getWidth() - 1280 - newWidth);
		System.out.println(sb.getValue());
		
		//System.out.println(sb.getMaximum());
		revalidate();
		repaint();
	}

}
