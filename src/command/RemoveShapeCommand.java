package command;

import java.util.ArrayList;
import java.util.List;
import geometry.Shape;
import mvc.DrawingModel;

public class RemoveShapeCommand implements Command {
	private DrawingModel model;
    private List<Shape> removedShapes = new ArrayList<>();
	

	public RemoveShapeCommand(DrawingModel model, List<Shape> shapesToRemove) {
		this.model = model;
        this.removedShapes.addAll(shapesToRemove);
	}

	@Override
	public void execute() {
		for (Shape s : removedShapes) {
            model.remove(s);
        }	}

	@Override
	public void unexecute() {
        for (Shape s : removedShapes) {
            model.add(s);
        }
	}
	public String getShapesDescription() {
	    String description = "";
	    for (Shape shape : removedShapes) {
	        description= description+ shape.toString() + "; ";
	    }
	    return description;
	}

	}


