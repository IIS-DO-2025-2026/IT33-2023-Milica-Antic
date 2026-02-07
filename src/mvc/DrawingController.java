	package mvc;
	
	import java.awt.Color;
	import java.awt.event.MouseEvent;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Stack;
	import geometry.Circle;
	import geometry.DlgCircle;
	import geometry.DlgDelete;
	import geometry.DlgDonut;
	import geometry.DlgHexagon;
	import geometry.DlgLine;
	import geometry.DlgPoint;
	import geometry.DlgRectangle;
	import geometry.Donut;
	import geometry.HexagonAdapter;
	import geometry.Line;
	import geometry.Point;
	import geometry.Rectangle;
	import geometry.Shape;
	import hexagon.Hexagon;
	import log.CommandLogger;
import strategy.BinarySave;
import strategy.SaveContext;
	import command.AddShapeCommand;
import command.ChangeZOrderCommand;
import command.Command;
	import command.RemoveShapeCommand;
	import command.UpdateShapeCommand;
	
	public class DrawingController {
		
	    private DrawingModel model;
	    private DrawingFrame frame;
	    private Point point1 = null;
		private Stack<Command> undoStack = new Stack<>();
	    private Stack<Command> redoStack = new Stack<>();
	    private CommandLogger logger = new CommandLogger();

	
	    public DrawingController(DrawingModel model, DrawingFrame frame) {
	        this.model = model;
	        this.frame=frame;
	    }
	    

	
		public void drawing(MouseEvent e) {
	        Point point = new Point(e.getX(), e.getY());
	
	        switch (frame.getWord()) {
	        case "point": {
	            DlgPoint dlgPoint = new DlgPoint();
	            dlgPoint.setInitialBorderColor(model.getActiveBorderColor());
	            dlgPoint.getTxtFieldPointX().setText(String.valueOf(e.getX()));
	            dlgPoint.getTxtFieldPointY().setText(String.valueOf(e.getY()));
	            dlgPoint.getTxtFieldPointX().setEditable(false);
	            dlgPoint.getTxtFieldPointY().setEditable(false);
	            dlgPoint.setVisible(true);
	            if (dlgPoint.isOk()) {
	                if (dlgPoint.getBackColor() == null) {
	                	point.setBorderColor(model.getActiveBorderColor());
	                }
	                else {
	                	point.setBorderColor(dlgPoint.getBackColor());
	                }
	                executeCommand( new AddShapeCommand(model, point));

	            }
	        } break;
	
	        case "line": {
	            if (point1 == null) {
	                point1 = new Point(e.getX(), e.getY());
	            } 
	            else {
	                Line line = new Line(point1, point);
	                DlgLine dlgLine = new DlgLine();
	                dlgLine.setInitialBorderColor(model.getActiveBorderColor());
	                dlgLine.getTxtFieldStartPointX().setText(String.valueOf(point1.getX()));
	                dlgLine.getTxtFieldStartPointY().setText(String.valueOf(point1.getY()));
	                dlgLine.getTxtFieldEndPointX().setText(String.valueOf(point.getX()));
	                dlgLine.getTxtFieldEndPointY().setText(String.valueOf(point.getY()));
	                dlgLine.getTxtFieldStartPointX().setEditable(false);
	                dlgLine.getTxtFieldStartPointY().setEditable(false);
	                dlgLine.getTxtFieldEndPointX().setEditable(false);
	                dlgLine.getTxtFieldEndPointY().setEditable(false);
	                dlgLine.setVisible(true);
	                if (dlgLine.isOk()) {
	                    if (dlgLine.getBackColor() == null) {
	                    	line.setBorderColor(model.getActiveBorderColor());
	                    }
	                    else {
	                    	line.setBorderColor(dlgLine.getBackColor());
	                    }
	                    executeCommand( new AddShapeCommand(model, line));
	                }
	                point1 = null;
	            }
	        } break;
	
	        case "rectangle": {
	            DlgRectangle dlgRectangle = new DlgRectangle();
	            dlgRectangle.setInitialBorderColor(model.getActiveBorderColor());
	            dlgRectangle.setInitialSurfaceColor(model.getActiveSurfaceColor());
	            dlgRectangle.getTxtFieldPointX().setText(String.valueOf(e.getX()));
	            dlgRectangle.getTxtFieldPointY().setText(String.valueOf(e.getY()));
	            dlgRectangle.getTxtFieldPointX().setEditable(false);
	            dlgRectangle.getTxtFieldPointY().setEditable(false);
	            dlgRectangle.setVisible(true);
	            if (dlgRectangle.isOk()) {
	                Rectangle rect = new Rectangle(point, Integer.parseInt(dlgRectangle.getTxtFieldWidth().getText()),Integer.parseInt(dlgRectangle.getTxtFieldHeight().getText()));
	                if (dlgRectangle.getBackColor() == null) {
	                	rect.setBorderColor(model.getActiveBorderColor());
	                }
	                else {
	                	rect.setBorderColor(dlgRectangle.getBackColor());
	                }
	                if (dlgRectangle.getSurfaceColor() == null) {
	                	rect.setSurfaceColor(model.getActiveSurfaceColor());
	                }
	                else {
	                	rect.setSurfaceColor(dlgRectangle.getSurfaceColor());
	                }
	                executeCommand(new AddShapeCommand(model, rect));
	            }
	        } break;
	
	        case "circle": {
	            DlgCircle dlgCircle = new DlgCircle();
	            dlgCircle.setInitialBorderColor(model.getActiveBorderColor());
	            dlgCircle.setInitialSurfaceColor(model.getActiveSurfaceColor());
	            dlgCircle.getTxtFieldPointX().setText(String.valueOf(e.getX()));
	            dlgCircle.getTxtFieldPointY().setText(String.valueOf(e.getY()));
	            dlgCircle.getTxtFieldPointX().setEditable(false);
	            dlgCircle.getTxtFieldPointY().setEditable(false);
	            dlgCircle.setVisible(true);
	            if (dlgCircle.isOk()) {
	                Circle circle = new Circle(point, Integer.parseInt(dlgCircle.getTxtFieldRadius().getText()));
	                if (dlgCircle.getBackColor() == null) {
	                	circle.setBorderColor(model.getActiveBorderColor());
	                }
	                else {
	                	circle.setBorderColor(dlgCircle.getBackColor());
	                }
	                if (dlgCircle.getSurfaceColor() == null) {
	                	circle.setSurfaceColor(model.getActiveSurfaceColor());
	                }
	                else {
	                	circle.setSurfaceColor(dlgCircle.getSurfaceColor());
	                }
	                executeCommand(new AddShapeCommand(model, circle));
	            }
	        } break;
	
	        case "donut": {
	            DlgDonut dlgDonut = new DlgDonut();
	            dlgDonut.setInitialBorderColor(model.getActiveBorderColor());
	            dlgDonut.setInitialSurfaceColor(model.getActiveSurfaceColor());
	            dlgDonut.getTxtFieldPointX().setText(String.valueOf(e.getX()));
	            dlgDonut.getTxtFieldPointY().setText(String.valueOf(e.getY()));
	            dlgDonut.getTxtFieldPointX().setEditable(false);
	            dlgDonut.getTxtFieldPointY().setEditable(false);
	            dlgDonut.setVisible(true);
	            if (dlgDonut.isOk()) {
	                Donut donut = new Donut(point, Integer.parseInt(dlgDonut.getTxtFieldBiggerRadius().getText()),Integer.parseInt(dlgDonut.getTxtFieldSmallerRadius().getText()));
	                donut.setBorderColor(dlgDonut.getBackColor() != null ? dlgDonut.getBackColor() : model.getActiveBorderColor());
	                donut.setSurfaceColor(dlgDonut.getSurfaceColor() != null ? dlgDonut.getSurfaceColor() : model.getActiveSurfaceColor());
	                executeCommand(new AddShapeCommand(model, donut));
	            }
	        } break;
	        case "hexagon": {
	            DlgHexagon dlgHexagon = new DlgHexagon();
	            dlgHexagon.setInitialBorderColor(model.getActiveBorderColor());
	            dlgHexagon.setInitialSurfaceColor(model.getActiveSurfaceColor());
	            dlgHexagon.getTextFieldXcoordinate().setText(String.valueOf(e.getX()));
	            dlgHexagon.getTextFieldYcoordinate().setText(String.valueOf(e.getY()));
	            dlgHexagon.getTextFieldXcoordinate().setEditable(false);
	            dlgHexagon.getTextFieldYcoordinate().setEditable(false);
	            dlgHexagon.setVisible(true);
	            if (dlgHexagon.isOk()) {
	                int x = Integer.parseInt(dlgHexagon.getTextFieldXcoordinate().getText());
	                int y = Integer.parseInt(dlgHexagon.getTextFieldYcoordinate().getText());
	                int r = Integer.parseInt(dlgHexagon.getTextFieldRadius().getText());
	
	                Hexagon h = new Hexagon(x, y, r);
	                h.setBorderColor(dlgHexagon.getBackColor() != null ? dlgHexagon.getBackColor() : model.getActiveBorderColor());
	                h.setAreaColor(dlgHexagon.getSurfaceColor() != null ? dlgHexagon.getSurfaceColor() : model.getActiveSurfaceColor());
	
	                HexagonAdapter hexAdapter = new HexagonAdapter(h);
	                executeCommand(new AddShapeCommand(model, hexAdapter));
	            }
	        } break;
	            
	
	        case "selected": {
	            Collections.reverse(model.getListOfShapes());
	            boolean found = false;

	            Iterator<Shape> it = model.getListOfShapes().iterator();
	            while (it.hasNext()) {
	                Shape tempShape = it.next();
	                if (tempShape.contains(e.getX(), e.getY())) {
	                    boolean newSelected = !tempShape.isSelected();
	                    tempShape.setSelected(newSelected);
	                    if (newSelected) {
	                        logger.getLog().add("SELECTED;" + tempShape.toString());
	                    } else {
	                        logger.getLog().add("UNSELECTED;" + tempShape.toString());
	                    }

	                    found = true;
	                    break; 
	                }
	            }

	            if (!found) {
	                Iterator<Shape> it2 = model.getListOfShapes().iterator();
	                while (it2.hasNext()) {
	                    Shape s = it2.next();
	                    if (s.isSelected()) {
	                        s.setSelected(false);
	                        logger.getLog().add("UNSELECTED;" + s.toString());
	                    }
	                }
	            }

	            Collections.reverse(model.getListOfShapes());
	            model.notifyObservers();
	            frame.updateLogArea(logger.getLog());
	            autoSave();
	        } break;

	        }
	        frame.getView().repaint();
	    }

	
	    public void delete() {
	        DlgDelete dlgDelete = new DlgDelete();
	        dlgDelete.setVisible(true);
	        if (dlgDelete.isOk()) {
	            List<Shape> selectedShapes = new ArrayList<>();

	            for (Shape s : model.getListOfShapes()) {
	                if (s.isSelected()) {
	                    selectedShapes.add(s);
	                }
	            }

	            if (!selectedShapes.isEmpty()) {
	                executeCommand(new RemoveShapeCommand(model, selectedShapes));
	            }
	        }
	        model.notifyObservers();
	        frame.getView().repaint();
	    }
	
	
	    public void modify() {
	    	
	    	Shape selectedShape = null;
	        for (Shape s : model.getListOfShapes()) {
	            if (s.isSelected()) {
	                selectedShape = s;
	                break;
	            }
	        }      
	        
	
	        if (selectedShape instanceof Point) {
	        	Point original = (Point) selectedShape;
	        	Point edited = (Point) original.clone();
	        	DlgPoint dlg = new DlgPoint();
	        	dlg.getTxtFieldPointX().setText(String.valueOf(original.getX()));
	            dlg.getTxtFieldPointY().setText(String.valueOf(original.getY()));
	            dlg.setInitialBorderColor(original.getBorderColor());
	            dlg.setVisible(true);

	            if (dlg.isOk()) {
	                edited.setX(Integer.parseInt(dlg.getTxtFieldPointX().getText()));
	                edited.setY(Integer.parseInt(dlg.getTxtFieldPointY().getText()));
	                if (dlg.getBackColor() != null)
	                    edited.setBorderColor(dlg.getBackColor());

	                executeCommand(new UpdateShapeCommand(model, original, edited));
	            }
	        } else if (selectedShape instanceof Line) {
	            Line original = (Line) selectedShape;
	            Line edited = (Line) original.clone();

	            DlgLine dlg = new DlgLine();
	            dlg.getTxtFieldStartPointX().setText(String.valueOf(original.getStartPoint().getX()));
	            dlg.getTxtFieldStartPointY().setText(String.valueOf(original.getStartPoint().getY()));
	            dlg.getTxtFieldEndPointX().setText(String.valueOf(original.getEndPoint().getX()));
	            dlg.getTxtFieldEndPointY().setText(String.valueOf(original.getEndPoint().getY()));
	            dlg.setInitialBorderColor(original.getBorderColor());
	            dlg.setVisible(true);

	            if (dlg.isOk()) {
	                edited.getStartPoint().setX(Integer.parseInt(dlg.getTxtFieldStartPointX().getText()));
	                edited.getStartPoint().setY(Integer.parseInt(dlg.getTxtFieldStartPointY().getText()));
	                edited.getEndPoint().setX(Integer.parseInt(dlg.getTxtFieldEndPointX().getText()));
	                edited.getEndPoint().setY(Integer.parseInt(dlg.getTxtFieldEndPointY().getText()));
	                if (dlg.getBackColor() != null)
	                    edited.setBorderColor(dlg.getBackColor());

	                executeCommand(new UpdateShapeCommand(model, original, edited));
	            }
	        }

	        else if (selectedShape instanceof Rectangle) {
	            Rectangle original = (Rectangle) selectedShape;
	            Rectangle edited = (Rectangle) original.clone();

	            DlgRectangle dlg = new DlgRectangle();
	            dlg.getTxtFieldPointX().setText(String.valueOf(original.getUpperLeftPoint().getX()));
	            dlg.getTxtFieldPointY().setText(String.valueOf(original.getUpperLeftPoint().getY()));
	            dlg.getTxtFieldWidth().setText(String.valueOf(original.getWidth()));
	            dlg.getTxtFieldHeight().setText(String.valueOf(original.getHeight()));
	            dlg.setInitialBorderColor(original.getBorderColor());
	            dlg.setInitialSurfaceColor(original.getSurfaceColor());
	            dlg.setVisible(true);

	            if (dlg.isOk()) {
	                edited.getUpperLeftPoint().setX(Integer.parseInt(dlg.getTxtFieldPointX().getText()));
	                edited.getUpperLeftPoint().setY(Integer.parseInt(dlg.getTxtFieldPointY().getText()));
	                edited.setWidth(Integer.parseInt(dlg.getTxtFieldWidth().getText()));
	                edited.setHeight(Integer.parseInt(dlg.getTxtFieldHeight().getText()));
	                if (dlg.getBackColor() != null)
	                    edited.setBorderColor(dlg.getBackColor());
	                if (dlg.getSurfaceColor() != null)
	                    edited.setSurfaceColor(dlg.getSurfaceColor());

	                executeCommand(new UpdateShapeCommand(model, original, edited));
	            }
	        }
	        else if (selectedShape instanceof Circle) {
	            Circle original = (Circle) selectedShape;
	            Circle edited = (Circle) original.clone();

	            DlgCircle dlg = new DlgCircle();
	            dlg.getTxtFieldPointX().setText(String.valueOf(original.getCenter().getX()));
	            dlg.getTxtFieldPointY().setText(String.valueOf(original.getCenter().getY()));
	            dlg.getTxtFieldRadius().setText(String.valueOf(original.getRadius()));
	            dlg.setInitialBorderColor(original.getBorderColor());
	            dlg.setInitialSurfaceColor(original.getSurfaceColor());
	            dlg.setVisible(true);

	            if (dlg.isOk()) {
	                edited.getCenter().setX(Integer.parseInt(dlg.getTxtFieldPointX().getText()));
	                edited.getCenter().setY(Integer.parseInt(dlg.getTxtFieldPointY().getText()));
	                edited.setRadius(Integer.parseInt(dlg.getTxtFieldRadius().getText()));
	                if (dlg.getBackColor() != null)
	                    edited.setBorderColor(dlg.getBackColor());
	                if (dlg.getSurfaceColor() != null)
	                    edited.setSurfaceColor(dlg.getSurfaceColor());

	                executeCommand(new UpdateShapeCommand(model, original, edited));
	            }
	        }
	        else if (selectedShape instanceof Donut) {
	            Donut original = (Donut) selectedShape;
	            Donut edited = (Donut) original.clone();

	            DlgDonut dlg = new DlgDonut();
	            dlg.getTxtFieldPointX().setText(String.valueOf(original.getCenter().getX()));
	            dlg.getTxtFieldPointY().setText(String.valueOf(original.getCenter().getY()));
	            dlg.getTxtFieldBiggerRadius().setText(String.valueOf(original.getRadius()));
	            dlg.getTxtFieldSmallerRadius().setText(String.valueOf(original.getInnerRadius()));
	            dlg.setInitialBorderColor(original.getBorderColor());
	            dlg.setInitialSurfaceColor(original.getSurfaceColor());
	            dlg.setVisible(true);

	            if (dlg.isOk()) {
	                edited.getCenter().setX(Integer.parseInt(dlg.getTxtFieldPointX().getText()));
	                edited.getCenter().setY(Integer.parseInt(dlg.getTxtFieldPointY().getText()));
	                edited.setRadius(Integer.parseInt(dlg.getTxtFieldBiggerRadius().getText()));
	                edited.setInnerRadius(Integer.parseInt(dlg.getTxtFieldSmallerRadius().getText()));
	                if (dlg.getBackColor() != null)
	                    edited.setBorderColor(dlg.getBackColor());
	                if (dlg.getSurfaceColor() != null)
	                    edited.setSurfaceColor(dlg.getSurfaceColor());

	                executeCommand(new UpdateShapeCommand(model, original, edited));
	            }
	        }
	        else if (selectedShape instanceof HexagonAdapter) {
	            HexagonAdapter original = (HexagonAdapter) selectedShape;
	            HexagonAdapter edited = original.clone();

	            DlgHexagon dlg = new DlgHexagon();
	            dlg.getTextFieldXcoordinate().setText(String.valueOf(original.getX()));
	            dlg.getTextFieldYcoordinate().setText(String.valueOf(original.getY()));
	            dlg.getTextFieldRadius().setText(String.valueOf(original.getR()));
	            dlg.setInitialBorderColor(original.getBorderColor());
	            dlg.setInitialSurfaceColor(original.getSurfaceColor());
	            dlg.setVisible(true);

	            if (dlg.isOk()) {
	                edited.setX(Integer.parseInt(dlg.getTextFieldXcoordinate().getText()));
	                edited.setY(Integer.parseInt(dlg.getTextFieldYcoordinate().getText()));
	                edited.setR(Integer.parseInt(dlg.getTextFieldRadius().getText()));
	                if (dlg.getBackColor() != null)
	                    edited.setBorderColor(dlg.getBackColor());
	                if (dlg.getSurfaceColor() != null)
	                    edited.setSurfaceColor(dlg.getSurfaceColor());

	                executeCommand(new UpdateShapeCommand(model, original, edited));
	            }
	        }
	        
	
	       frame.getView().repaint();
	    }
	    public void onModeChanged() {
	    	   for (Shape s : model.getListOfShapes()) {
	               s.setSelected(false);
	           } 	
	    	   model.notifyObservers();
	    	   frame.getView().repaint();
	    	}
	   
	    public void executeCommand(Command command) {
	        undoStack.push(command);
	    	command.execute();
	    	logger.logCommand(command);
	    	frame.updateLogArea(logger.getLog());
	        redoStack.clear(); 
	        model.notifyObservers();
	        autoSave();
	        autoSaveBinary();

	    }
	
	    public void undo() {
	    	
	        if (!undoStack.isEmpty()) {
	            Command command = undoStack.pop();
	            command.unexecute();
	            redoStack.push(command);
	            logger.logUndo(command);  
	            frame.updateLogArea(logger.getLog());
	            autoSave();
	            model.notifyObservers(); 
	        }
	        
	    }

	    public void redo() {
	        if (!redoStack.isEmpty()) {
	            Command command = redoStack.pop();
	            command.execute();
	            undoStack.push(command);
	            logger.logRedo(command);   
	            frame.updateLogArea(logger.getLog());
	            autoSave();
	            model.notifyObservers(); 
	        }
	        
	    }
	    private void autoSave() {
	    	SaveContext context = new SaveContext();

	        context.setStrategy(new strategy.TextLogSave(this));
	        context.save("C:\\Users\\Milica\\Desktop\\textlog.txt");

	    }
	    private void autoSaveBinary() {
	        SaveContext context = new SaveContext();
	        context.setStrategy(new BinarySave(this));
	        context.save("C:\\Users\\Milica\\Desktop\\binlog.txt");
	    }

	    public CommandLogger getCommandLogger() {
	        return logger;
	    }
	    public void toFront() {
	        Shape selected = getSelectedShape();
	        if (selected != null) {
	            int index = model.indexOf(selected);
	            if (index < model.getShapeCount() - 1) {
	                executeCommand(new ChangeZOrderCommand(model, selected, index + 1));
	            }
	        }
	    }

	    public void toBack() {
	        Shape selected = getSelectedShape();
	        if (selected != null) {
	            int index = model.indexOf(selected);
	            if (index > 0) {
	                executeCommand(new ChangeZOrderCommand(model, selected, index - 1));
	            }
	        }
	    }

	    public void bringToFront() {
	        Shape selected = getSelectedShape();
	        if (selected != null) {
	            executeCommand(new ChangeZOrderCommand(model, selected, model.getShapeCount() - 1));
	        }
	    }

	    public void bringToBack() {
	        Shape selected = getSelectedShape();
	        if (selected != null) {
	            executeCommand(new ChangeZOrderCommand(model, selected, 0));
	        }
	    }

	    private Shape getSelectedShape() {
	        for (Shape s : model.getListOfShapes()) {
	            if (s.isSelected()) return s;
	        }
	        return null;
	    }



		public boolean hasShapes()
		{
			return !model.getListOfShapes().isEmpty();
		}
	    public int getSelectedCount() {
	        return model.getSelectedCount();
	    }
	    public void changeBorderColor(Color color) {
	        model.setActiveBorderColor(color);
	    }
	
	    public void changeSurfaceColor(Color color) {
	        model.setActiveSurfaceColor(color);
	    }
	
	    public void addShape(Shape shape) {
	        executeCommand(new command.AddShapeCommand(model, shape));
	    }
	
	    public void removeShape(Shape shape) {
	        executeCommand(new command.RemoveShapeCommand(model, java.util.List.of(shape)));
	    }
	
	    public void updateShape(Shape originalShape, Shape newShape) {
	        executeCommand(new command.UpdateShapeCommand(model, originalShape, newShape));
	    }
	    public Stack<Command> getUndoStack() {
				return undoStack;
			}

			public Stack<Command> getRedoStack() {
				return redoStack;
			}
			public DrawingModel getModel() { return model; }
			public int getCount() {return model.getShapeCount();}

	}