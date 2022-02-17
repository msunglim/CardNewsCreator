package lib;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import capture.Screenshot;
import panels.CardNewsEditor;

public class FileUpload {

	private File selectedFile;
	private Screenshot sc;
	public FileUpload(JComponent component) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+"/Desktop"));
		int result = fileChooser.showOpenDialog(component);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
		}

	}
	public FileUpload(CardNewsEditor cne) {
		 try {
			sc = new Screenshot(cne);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public BufferedImage getScreenShot()  {
		
		return sc.getScreenShot();
		
	}
}
