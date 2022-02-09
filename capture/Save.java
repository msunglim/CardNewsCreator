package capture;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Save {

	//in the future, add a parameter String filename
	public Save(BufferedImage img) {
		// Insert code here
		try {
			
		
			// write the image as a PNG
			ImageIO.write(img, "png", new File("5.png"));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
