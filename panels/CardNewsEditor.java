package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import lib.FileUpload;

public class CardNewsEditor extends JPanel {

	public CardNewsEditor(ScrollPanel sp) {

		JButton addBackgroundButton = new JButton("B");
		JButton addImageButton = new JButton("I");
		JButton addTextButton = new JButton("T");
		add(addBackgroundButton);
		add(addImageButton);
		add(addTextButton);

		addBackgroundButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					FileUpload fu = new FileUpload(curr);

					if (fu.getImage() != null) {
						curr.setBackgroundImage(fu.getImage());

					}
				}
			}
		});

		addImageButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {
					FileUpload fu = new FileUpload(curr);

					if (fu.getImage() != null) {
						curr.setImage(fu.getImage());

					}
				}
			}
		});

		addTextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CardNews curr = sp.getCurrCardNews();
				if (curr != null) {

					curr.setText("aaaa");

				}

			}
		});
	}
}
