package mvc;

import java.awt.EventQueue;
import javax.swing.JFrame;

import log.LogLoader;

public class Application {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingFrame frame = new DrawingFrame();
					DrawingModel model=new DrawingModel();
					frame.getView().setModel(model);
					DrawingController controller=new DrawingController(model,frame);
					frame.setController(controller);
					model.addObserver(frame);
				
					frame.setTitle("Antic Milica IT33/2023");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 1000, 400);
					
					frame.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
