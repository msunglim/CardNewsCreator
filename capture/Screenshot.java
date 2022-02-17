package capture;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import panels.CardNewsEditor;
import panels.MainFrame;

/*
 * set Image of cne when mouse is dragged and released.
 * minimize the main frame at the first and then normalize it if mouse released.  
 */
public class Screenshot extends JFrame {

	private int x1, x2, y1, y2;
	
	private BufferedImage captured;
	public Screenshot(CardNewsEditor cne) throws IOException, AWTException {
		Robot robot = new Robot();
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		System.out.println("?");
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		System.out.println("!");
		// robot.mouseMove(1200,200);
		
//		JFrame f = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		f.pack();
//		f.setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	
		
		setUndecorated(true);
		setBackground(new Color(1.0f, 1.0f, 1.0f, 0.1f));
		setVisible(true);

		MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(cne);
		mainFrame.minimize();
		
		
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

//				System.out.println(x + "," + y);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				Point location = MouseInfo.getPointerInfo().getLocation();
				x1 = (int) location.getX();
				y1 = (int) location.getY();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				Point location = MouseInfo.getPointerInfo().getLocation();
				x2 = (int) location.getX();
				y2 = (int) location.getY();
				// the +/-1 is added to avoid having red lines on the screenshot.
				if(!(x2-x1-1 <=0 || y2-y1-1<=0)) {
					Rectangle area = new Rectangle(x1+1, y1+1, x2 - x1 -1, y2 - y1-1);
//					System.out.println(area);
					
					captured = robot.createScreenCapture(area);
					cne.setImage(captured, x2 - x1 , y2-y1);
					mainFrame.normalize();
//					try {
//						ImageIO.write(captured, "jpg",
//								new File("C:\\Users\\Moungsung Im\\Desktop\\코딩공부\\CardNewsCreator\\aa.jpg"));
//					} catch (IOException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
				}
				
				setVisible(false);

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



	}

	public void paint(Graphics g) {
		super.paint(g);
		Point location = MouseInfo.getPointerInfo().getLocation();
		Graphics2D g2 = (Graphics2D) g;
		Line2D lin = new Line2D.Float(0, (int)location.getY(), getWidth(), (int)location.getY());
		g2.setColor(Color.RED);
		g2.draw(lin);
		Line2D lin2 = new Line2D.Float((int)location.getX(),0,  (int)location.getX(), getHeight());
		g2.draw(lin2);
		g2.setColor(Color.RED);
		g2.drawRect(x1, y1, (int)location.getX() -x1, (int)location.getY()-y1);
		
		revalidate();
		repaint();

	}
	public BufferedImage getScreenShot() {
		System.out.println("hi");
		return captured;
	}
}
