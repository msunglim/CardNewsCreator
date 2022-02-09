
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CloseWithKey {

	public CloseWithKey(Component component) {

		class key implements KeyListener {

			public void keyPressed(KeyEvent e) {

				System.out.println(e);
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		}
		component.addKeyListener(new key() {

			public void keyPressed(KeyEvent e) {
				System.out.println("??");
				if (e.getKeyCode() > 0) {
					System.exit(0);
				}
			}
		});
	}
	public static void setKey(Component component) {
		
		component.setFocusable(true);
	
		class key implements KeyListener {

			public void keyPressed(KeyEvent e) {

				System.out.println(e);
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		}
		component.addKeyListener(new key() {

			public void keyPressed(KeyEvent e) {

				System.out.println("cc");
				if (e.getKeyCode() > 0) {
					//System.exit(0);
				}
			}
		});
	}
}
