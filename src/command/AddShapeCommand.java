package command;

import geometry.Shape;
import mvc.DrawingModel;

public class AddShapeCommand implements Command {
	private DrawingModel model;
	private Shape shape;
	
	public AddShapeCommand(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}

	@Override
	public void execute() {
		model.add(shape);

	}

	@Override
	public void unexecute() {
		model.remove(shape);

	}
	public Shape getShape() {
	    return shape;
	}

}
