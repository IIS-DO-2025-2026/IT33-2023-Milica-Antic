	package log;
	
	import java.util.ArrayList;
	import java.util.List;
	import command.AddShapeCommand;
	import command.ChangeZOrderCommand;
	import command.Command;
	import command.RemoveShapeCommand;
	import command.UpdateShapeCommand;
	import geometry.Shape;
	
	public class CommandLogger {
	    private List<String> log = new ArrayList<>();
	    public void logCommand(Command c) {
	        log.add(commandToText(c));
	    }
	
	    public void logUndo(Command c) {
	        log.add("UNDO;" + commandToText(c));
	    }
	
	    public void logRedo(Command c) {
	        log.add("REDO;" + commandToText(c));
	    }
	    private String commandToText(Command c) {
	
	        if (c instanceof AddShapeCommand addCmd) {
	            Shape s = addCmd.getShape();
	            return "ADD;" + s.toString();
	
	        } else if (c instanceof RemoveShapeCommand removeCmd) {
	            return "REMOVE;" + removeCmd.getShapesDescription();
	
	        } else if (c instanceof UpdateShapeCommand updateCmd) {
	            return "UPDATE;" +
	                   updateCmd.getOriginal().toString() +
	                   " -> " +
	                   updateCmd.getNewState().toString();
	
	        } else if (c instanceof ChangeZOrderCommand zCmd) {
	            return "ZORDER;" + zCmd.getDescription();
	        }
	
	        return "UNKNOWN";
	    }
	
	    public List<String> getLog() {
	        return log;
	    }
	
	 
	
	}
