package log;

import java.util.ArrayList;
import java.util.List;

import command.AddShapeCommand;
import command.Command;
import command.RemoveShapeCommand;
import command.UpdateShapeCommand;
import geometry.Shape;

public class CommandLogger {
    private List<String> log = new ArrayList<>();
    
    public void logCommand(Command c) {
    	
        String text = "";
        if (c instanceof AddShapeCommand addCmd) {
            Shape s = addCmd.getShape();
            text = "AddShape: " + s.toString();
        } else if (c instanceof RemoveShapeCommand removeCmd) {
        	text = "RemoveShape: " + removeCmd.getShapesDescription();
        } else if (c instanceof UpdateShapeCommand updateCmd) {
        	text = "UpdateShape: " + updateCmd.getOriginal().toString() +
                    " -> " + updateCmd.getNewState().toString();
        } 

        log.add(text);
    }
    
    public List<String> getLog() {
        return log;
    }

 

}
