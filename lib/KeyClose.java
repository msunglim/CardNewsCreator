package lib;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public interface KeyClose {

	default void setKeyListener(JComponent component) {
		Action task = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// do nothing
				System.out.println("?");
			}
		};
		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Q"),
				"doSomething");
		component.getActionMap().put("doSomething", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
//
//		System.out.println("hello!" + component);
//		component.setFocusable(true);
//		component.requestFocusInWindow();
//		class key implements KeyListener {
//
//			public void keyPressed(KeyEvent e) {
//
//				System.out.println(e);
//			}
//
//			public void keyReleased(KeyEvent e) {
//			}
//
//			public void keyTyped(KeyEvent e) {
//			}
//
//		}
//		component.addKeyListener(new key() {
//
//			public void keyPressed(KeyEvent e) {
//
//				System.out.println("hi!" + component);
//				if (e.getKeyCode() > 0) {
//				//	System.exit(0);
//				}
//			}
//		});
	}
}
