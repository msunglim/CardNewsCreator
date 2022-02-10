package lib;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

public class FileUpload {

	private File selectedFile;

	public FileUpload(JComponent component) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+"/Desktop"));
		int result = fileChooser.showOpenDialog(component);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}

	}

	public BufferedImage getImage() {

		try {
			
			if(selectedFile !=null) {
				return (ImageIO.read(selectedFile));
					
			}else {
				return null;
			}
			} catch (IOException e) {
			System.out.println("fail to return image");
			return null;
		}
	}
}
