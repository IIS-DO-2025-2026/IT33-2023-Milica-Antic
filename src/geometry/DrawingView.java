package geometry;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingView extends JPanel {
	private static final long serialVersionUID = 1L;
	private DrawingModel model;

	public void setModel(DrawingModel model) {
		this.model = model;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (model != null) {
			for (Shape s : model.getListOfShapes()) {
				s.draw(g);
			}
		}
	}
}