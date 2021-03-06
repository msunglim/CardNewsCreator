package lib;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import panels.CardNews;
import panels.CardNewsEditor;
import panels.ScrollPanel;
import panels.TextManager;

public interface KeyControl {

	default void setKeyListener(CardNewsEditor component,ScrollPanel sp) {

		
		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
		component.getActionMap().put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getCurrTextManager();
//				System.out.println("curr"+ curr.getContent());

//				System.out.println("sp"+ sp.getCurrCardNews().getContent());				
				if (sp.getEditImage()) {

					curr.setImageY(curr.getImageY() - 10);
				} else {
					curr.setTextY(tm,-10);
				}

			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
		component.getActionMap().put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getCurrTextManager();
				//				System.out.println("down");
				if (sp.getEditImage()) {
					curr.setImageY(curr.getImageY() + 10);
				} else {
					curr.setTextY(tm,10);
				}

			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
		component.getActionMap().put("left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getCurrTextManager();
//				System.out.println("left");
				if (sp.getEditImage()) {
					curr.setImageX(curr.getImageX() - 10);
				} else {
					curr.setTextX(tm,-10);
				}

			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
		component.getActionMap().put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getCurrTextManager();
//				System.out.println("right");
				if (sp.getEditImage()) {
					curr.setImageX(curr.getImageX() + 10);
				} else {
//					System.out.println("??zz");
					curr.setTextX(tm,10);
				}
			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, KeyEvent.CTRL_DOWN_MASK), "expand");
		component.getActionMap().put("expand", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getCurrTextManager();
				if (sp.getEditImage()) {
					curr.resize(5);
				} else {
					curr.setFontSize(tm,5);
				}
			}
		});
		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, KeyEvent.CTRL_DOWN_MASK), "shrink");
		component.getActionMap().put("shrink", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				TextManager tm = curr.getCurrTextManager();
//				System.out.println("right");
				if (sp.getEditImage()) {
					curr.resize(-5);
				} else {
					curr.setFontSize(tm,-5);
				}
			}
		});

	}
}
