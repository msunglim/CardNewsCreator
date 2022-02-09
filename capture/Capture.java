package capture;

import java.awt.Component;
import java.awt.image.BufferedImage;

public class Capture {
	private BufferedImage image;

	public Capture(Component component) {
		this.image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
		// call the Component's paint method, using
		// the Graphics object of the image.
		component.paint(image.getGraphics()); // alternately use .printAll(..)
	}

	public BufferedImage getScreenshot() {

		return this.image;
	}
}
