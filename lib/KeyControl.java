package lib;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import panels.CardNews;

public interface KeyControl {

	default void setKeyListener(CardNews component) {

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "up");
		component.getActionMap().put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("up");
				if (component.getEditImage()) {
					component.setImageY(component.getImageY() - 10);
				} else {
					component.setTextY(-10);
				}

			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "down");
		component.getActionMap().put("down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("down");
				if (component.getEditImage()) {
					component.setImageY(component.getImageY() + 10);
				} else {
					component.setTextY(10);
				}

			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "left");
		component.getActionMap().put("left", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("left");
				if (component.getEditImage()) {
					component.setImageX(component.getImageX() - 10);
				} else {
					component.setTextX(-10);
				}

			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
		component.getActionMap().put("right", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("right");
				if (component.getEditImage()) {
					component.setImageX(component.getImageX() + 10);
				} else {
//					System.out.println("??zz");
					component.setTextX(10);
				}
			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, KeyEvent.CTRL_DOWN_MASK), "expand");
		component.getActionMap().put("expand", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (component.getEditImage()) {
					component.resize(5);
				} else {
					component.setFontSize(5);
				}
			}
		});
		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, KeyEvent.CTRL_DOWN_MASK), "shrink");
		component.getActionMap().put("shrink", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("right");
				if (component.getEditImage()) {
					component.resize(-5);
				} else {
					component.setFontSize(-5);
				}
			}
		});

		component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("Z"), "editAnother");

		component.getActionMap().put("editAnother", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("edit");

				component.setEditImage(!component.getEditImage());
			}
		});

	}
}
