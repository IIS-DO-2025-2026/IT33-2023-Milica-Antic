package command;

import geometry.Shape;
import mvc.DrawingModel;

public class ChangeZOrderCommand implements Command {
    private DrawingModel model;
    private Shape shape;
    private int oldIndex;
    private int newIndex;

    public ChangeZOrderCommand(DrawingModel model, Shape shape, int newIndex) {
        this.model = model;
        this.shape = shape;
        this.oldIndex = model.indexOf(shape);
        this.newIndex = newIndex;
    }

    @Override
    public void execute() {
        model.moveShape(shape, newIndex);
    }

    @Override
    public void unexecute() {
        model.moveShape(shape, oldIndex);
    }
    public String getDescription() {
        return  shape.toString() + ";toIndex=" + newIndex;
    }
}
