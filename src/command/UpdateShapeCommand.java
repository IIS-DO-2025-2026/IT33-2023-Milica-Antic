package command;

import geometry.Shape;
import mvc.DrawingModel;

public class UpdateShapeCommand implements Command {

    private DrawingModel model;
    private Shape original;
    private Shape oldState;
    private Shape newState;

    public UpdateShapeCommand(DrawingModel model, Shape originalShape, Shape newState) {
        this.model = model;
        this.original = originalShape;
        this.oldState = originalShape.clone(); 
        this.newState = newState.clone();      
    }

    @Override
    public void execute() {
        applyState(newState);
    }

    @Override
    public void unexecute() {
        applyState(oldState);
    }

    private void applyState(Shape state) {
        int index = model.getListOfShapes().indexOf(original);
        model.getListOfShapes().set(index, state);
        original = state;
    }
}
