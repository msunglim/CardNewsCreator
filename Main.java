import javax.swing.JFrame;
import javax.swing.JPanel;

import panels.MainPanel;

public class Main {
	public static void main(String[] args)  {

		JFrame f = new JFrame();
		JPanel p = new MainPanel();
//		f.setFocusable(true);
//		   class key implements KeyListener{
//	            
//	            public void keyPressed(KeyEvent e) {
//
//	                System.out.println( e );
//	            }
//
//	            public void keyReleased(KeyEvent e){ }          
//	            public void keyTyped(KeyEvent e) { }            
//	                        
//	        }       
//		f.addKeyListener(new key(){
//
//			public void keyPressed(KeyEvent e) {
//				System.out.println("??");
//				if(e.getKeyCode() >0) {
//					System.exit(0);
//				}
//            }
//		});
		
	//	CloseWithKey.setKey(f);
		
		f.setContentPane(p);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}


}