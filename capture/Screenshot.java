package capture;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

public class Screenshot {

	public Screenshot() throws IOException, AWTException {
		Robot robot = new Robot();
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("?");
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("!");
		// robot.mouseMove(1200,200);

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		f.pack();
//		f.setLocationRelativeTo(null);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);

		f.setUndecorated(true);
		f.setVisible(true);
		f.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));

		f.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Point location = MouseInfo.getPointerInfo().getLocation();
				int x = (int) location.getX();
				int y = (int) location.getY();

				System.out.println(x + "," + y);
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

		int width = 300;
		int height = 300;
//		Rectangle area = new Rectangle(x, y, width, height);
//		BufferedImage bufferedImage = robot.createScreenCapture(area);
//		ImageIO.write(bufferedImage, "jpg",
//				new File("C:\\Users\\Moungsung Im\\Desktop\\코딩공부\\CardNewsCreator\\aa.jpg"));

	}
}
