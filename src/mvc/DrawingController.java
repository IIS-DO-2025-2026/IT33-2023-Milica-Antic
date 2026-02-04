package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;

import geometry.Circle;
import geometry.DlgCircle;
import geometry.DlgDelete;
import geometry.DlgDonut;
import geometry.DlgLine;
import geometry.DlgPoint;
import geometry.DlgRectangle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;



public class DrawingController {
	
    private DrawingModel model;
    private DrawingFrame frame;
    private Point point1 = null;

    public DrawingController(DrawingModel model, DrawingFrame frame) {
        this.model = model;
        this.frame=frame;
    }

    public void drawing(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());

        switch (frame.getWord()) {
        case "point": {
            DlgPoint dlgPoint = new DlgPoint();
            dlgPoint.getTxtFieldPointX().setText(String.valueOf(e.getX()));
            dlgPoint.getTxtFieldPointY().setText(String.valueOf(e.getY()));
            dlgPoint.getTxtFieldPointX().setEditable(false);
            dlgPoint.getTxtFieldPointY().setEditable(false);
            dlgPoint.setVisible(true);
            if (dlgPoint.isOk()) {
                if (dlgPoint.getBackColor() == null) {
                	point.setBorderColor(Color.black);
                }
                else {
                	point.setBorderColor(dlgPoint.getBackColor());
                }
                model.add(point);
            }
        } break;

        case "line": {
            if (point1 == null) {
                point1 = new Point(e.getX(), e.getY());
            } 
            else {
                Line line = new Line(point1, point);
                DlgLine dlgLine = new DlgLine();
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
                    if (dlgLine.getBackColor() == null) line.setBorderColor(Color.black);
                    else {
                    	line.setBorderColor(dlgLine.getBackColor());
                    }
                    model.add(line);
                }
                point1 = null;
            }
        } break;

        case "rectangle": {
            DlgRectangle dlgRectangle = new DlgRectangle();
            dlgRectangle.getTxtFieldPointX().setText(String.valueOf(e.getX()));
            dlgRectangle.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgRectangle.getLblChooseASurfaceColor().setForeground(Color.white);
            dlgRectangle.getTxtFieldPointX().setEditable(false);
            dlgRectangle.getTxtFieldPointY().setEditable(false);
            dlgRectangle.setVisible(true);
            if (dlgRectangle.isOk()) {
                Rectangle rect = new Rectangle(point, Integer.parseInt(dlgRectangle.getTxtFieldWidth().getText()),Integer.parseInt(dlgRectangle.getTxtFieldHeight().getText()));
                if (dlgRectangle.getBackColor() == null) {
                	rect.setBorderColor(Color.black);
                }
                else {
                	rect.setBorderColor(dlgRectangle.getBackColor());
                }
                if (dlgRectangle.getSurfaceColor() == null) {
                	rect.setSurfaceColor(frame.getView().getBackground());
                }
                else {
                	rect.setSurfaceColor(dlgRectangle.getSurfaceColor());
                }
                model.add(rect);
            }
        } break;

        case "circle": {
            DlgCircle dlgCircle = new DlgCircle();
            dlgCircle.getTxtFieldPointX().setText(String.valueOf(e.getX()));
            dlgCircle.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgCircle.getLblChooseASurfaceColor().setForeground(Color.white);
            dlgCircle.getTxtFieldPointX().setEditable(false);
            dlgCircle.getTxtFieldPointY().setEditable(false);
            dlgCircle.setVisible(true);
            if (dlgCircle.isOk()) {
                Circle circle = new Circle(point, Integer.parseInt(dlgCircle.getTxtFieldRadius().getText()));
                if (dlgCircle.getBackColor() == null) {
                	circle.setBorderColor(Color.black);
                }
                else {
                	circle.setBorderColor(dlgCircle.getBackColor());
                }
                if (dlgCircle.getSurfaceColor() == null) {
                	circle.setSurfaceColor(frame.getView().getBackground());
                }
                else {
                	circle.setSurfaceColor(dlgCircle.getSurfaceColor());
                }
                model.add(circle);
            }
        } break;

        case "donut": {
            DlgDonut dlgDonut = new DlgDonut();
            dlgDonut.getTxtFieldPointX().setText(String.valueOf(e.getX()));
            dlgDonut.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgDonut.getLblChooseASurfaceColor().setForeground(Color.white);
            dlgDonut.getTxtFieldPointX().setEditable(false);
            dlgDonut.getTxtFieldPointY().setEditable(false);
            dlgDonut.setVisible(true);
            if (dlgDonut.isOk()) {
                Donut donut = new Donut(point, Integer.parseInt(dlgDonut.getTxtFieldBiggerRadius().getText()),Integer.parseInt(dlgDonut.getTxtFieldSmallerRadius().getText()));
                donut.setBorderColor(dlgDonut.getBackColor() != null ? dlgDonut.getBackColor() : Color.BLACK);
                donut.setSurfaceColor(dlgDonut.getSurfaceColor() != null ? dlgDonut.getSurfaceColor() : Color.WHITE);
                model.add(donut);
            }
        } break;
            
        case "selected": {
            Collections.reverse(model.getListOfShapes());
            boolean found = false; 
            Iterator<Shape> itShape = model.getListOfShapes().iterator();
            while (itShape.hasNext()) {
                Shape tempShape = itShape.next();
                if (tempShape.contains(e.getX(), e.getY())) {
                    tempShape.setSelected(!tempShape.isSelected());
                    found = true; 
                    break;
                }
            }
            if (!found) {
                for (Shape s : model.getListOfShapes()) {
                	s.setSelected(false);
                }
            }
            Collections.reverse(model.getListOfShapes());
        } break;
        }
        frame.getView().repaint();
    }

    public void delete() {
        DlgDelete dlgDelete = new DlgDelete();
        dlgDelete.setVisible(true);
        if (dlgDelete.isOk()) {
            Iterator<Shape> itShape = model.getListOfShapes().iterator();
            while (itShape.hasNext()) {
                Shape tempShape = itShape.next();
                if (tempShape.isSelected()) { 
                    itShape.remove();
                }
            }
        }
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
            Point temp = (Point) selectedShape;
            DlgPoint dlgPoint = new DlgPoint();
            dlgPoint.getTxtFieldPointX().setText(String.valueOf(temp.getX()));
            dlgPoint.getTxtFieldPointY().setText(String.valueOf(temp.getY()));
            dlgPoint.setVisible(true);
            if (dlgPoint.isOk()) {
                temp.setX(Integer.parseInt(dlgPoint.getTxtFieldPointX().getText()));
                temp.setY(Integer.parseInt(dlgPoint.getTxtFieldPointY().getText()));
                if (dlgPoint.getBackColor() != null) {
                	temp.setBorderColor(dlgPoint.getBackColor());
                }
                temp.setSelected(false);
            }
        } else if (selectedShape instanceof Line) {
            Line temp = (Line) selectedShape ;
            DlgLine dlgLine = new DlgLine();
            dlgLine.getTxtFieldStartPointX().setText(String.valueOf(temp.getStartPoint().getX()));
            dlgLine.getTxtFieldStartPointY().setText(String.valueOf(temp.getStartPoint().getY()));
            dlgLine.getTxtFieldEndPointX().setText(String.valueOf(temp.getEndPoint().getX()));
            dlgLine.getTxtFieldEndPointY().setText(String.valueOf(temp.getEndPoint().getY()));
            dlgLine.setVisible(true);
            if (dlgLine.isOk()) {
                temp.getStartPoint().setX(Integer.parseInt(dlgLine.getTxtFieldStartPointX().getText()));
                temp.getStartPoint().setY(Integer.parseInt(dlgLine.getTxtFieldStartPointY().getText()));
                temp.getEndPoint().setX(Integer.parseInt(dlgLine.getTxtFieldEndPointX().getText()));
                temp.getEndPoint().setY(Integer.parseInt(dlgLine.getTxtFieldEndPointY().getText()));
                if (dlgLine.getBackColor() != null) {
                	temp.setBorderColor(dlgLine.getBackColor());
                }
                temp.setSelected(false);
            }
        } else if (selectedShape instanceof Rectangle) {
            Rectangle temp = (Rectangle) selectedShape;
            DlgRectangle dlgRectangle = new DlgRectangle();
            dlgRectangle.getTxtFieldPointX().setText(String.valueOf(temp.getUpperLeftPoint().getX()));
            dlgRectangle.getTxtFieldPointY().setText(String.valueOf(temp.getUpperLeftPoint().getY()));
            dlgRectangle.getTxtFieldWidth().setText(String.valueOf(temp.getWidth()));
            dlgRectangle.getTxtFieldHeight().setText(String.valueOf(temp.getHeight()));
            dlgRectangle.setVisible(true);
            if (dlgRectangle.isOk()) {
                temp.getUpperLeftPoint().setX(Integer.parseInt(dlgRectangle.getTxtFieldPointX().getText()));
                temp.getUpperLeftPoint().setY(Integer.parseInt(dlgRectangle.getTxtFieldPointY().getText()));
                temp.setHeight(Integer.parseInt(dlgRectangle.getTxtFieldHeight().getText()));
                temp.setWidth(Integer.parseInt(dlgRectangle.getTxtFieldWidth().getText()));
                if (dlgRectangle.getBackColor() != null) {
                	temp.setBorderColor(dlgRectangle.getBackColor());
                }
                if (dlgRectangle.getSurfaceColor() != null) {
                	temp.setSurfaceColor(dlgRectangle.getSurfaceColor());
                }
                temp.setSelected(false);
            }
        } else if (selectedShape instanceof Donut) {
            Donut temp = (Donut) selectedShape;
            DlgDonut dlgDonut = new DlgDonut();
            dlgDonut.getTxtFieldPointX().setText(String.valueOf(temp.getCenter().getX()));
            dlgDonut.getTxtFieldPointY().setText(String.valueOf(temp.getCenter().getY()));
            dlgDonut.getTxtFieldBiggerRadius().setText(String.valueOf(temp.getRadius()));
            dlgDonut.getTxtFieldSmallerRadius().setText(String.valueOf(temp.getInnerRadius()));
            dlgDonut.setVisible(true);
            if (dlgDonut.isOk()) {
                temp.getCenter().setX(Integer.parseInt(dlgDonut.getTxtFieldPointX().getText()));
                temp.getCenter().setY(Integer.parseInt(dlgDonut.getTxtFieldPointY().getText()));
                temp.setRadius(Integer.parseInt(dlgDonut.getTxtFieldBiggerRadius().getText()));
                temp.setInnerRadius(Integer.parseInt(dlgDonut.getTxtFieldSmallerRadius().getText()));
                if (dlgDonut.getBackColor() != null) {
                	temp.setBorderColor(dlgDonut.getBackColor());
                }
                if (dlgDonut.getSurfaceColor() != null) {
                	temp.setSurfaceColor(dlgDonut.getSurfaceColor());
                }
                temp.setSelected(false);
            }
        } else if (selectedShape instanceof Circle) {
            Circle temp = (Circle) selectedShape;
            DlgCircle dlgCircle = new DlgCircle();
            dlgCircle.getTxtFieldPointX().setText(String.valueOf(temp.getCenter().getX()));
            dlgCircle.getTxtFieldPointY().setText(String.valueOf(temp.getCenter().getY()));
            dlgCircle.getTxtFieldRadius().setText(String.valueOf(temp.getRadius()));
            dlgCircle.setVisible(true);
            if (dlgCircle.isOk()) {
                temp.getCenter().setX(Integer.parseInt(dlgCircle.getTxtFieldPointX().getText()));
                temp.getCenter().setY(Integer.parseInt(dlgCircle.getTxtFieldPointY().getText()));
                temp.setRadius(Integer.parseInt(dlgCircle.getTxtFieldRadius().getText()));
                if (dlgCircle.getBackColor() != null) {
                	temp.setBorderColor(dlgCircle.getBackColor());
                }
                if (dlgCircle.getSurfaceColor() != null) {
                	temp.setSurfaceColor(dlgCircle.getSurfaceColor());
                }
                temp.setSelected(false);
            }
        }
        frame.getView().repaint();
    }
    public void onModeChanged() {
    	   for (Shape s : model.getListOfShapes()) {
               s.setSelected(false);
           } 	
    		frame.getView().repaint();
    	}
    
    public void selectMode() {
    	if (model.getListOfShapes().size()<1) {
    		JOptionPane.showMessageDialog(null, "There are no drawn shapes", "Error Message",JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}

    	onModeChanged();
    	
    }
    public void modifyRequest() {
    	if (model.getListOfShapes().size()<1) {
    		JOptionPane.showMessageDialog( null,"There are no drawn shapes", "Error Message", JOptionPane.INFORMATION_MESSAGE
    		);
    		return;
    		}
        boolean isSelected = false;
        int count=0;
        for (Shape s : model.getListOfShapes()) {
            if (s.isSelected()) {
                isSelected = true;
                break;
            }
        }
         if(model.getListOfShapes().size()>1){
        	for (Shape s : model.getListOfShapes()) {
                if(s.isSelected()) count++;
        	}
        	if(count>1)
           JOptionPane.showMessageDialog(null, "Cant modify multiple shapes", "Error Message",JOptionPane.INFORMATION_MESSAGE);
    	   return;
    	}

    	if (!isSelected) {
    		JOptionPane.showMessageDialog(null,"Nothing is selected", "Error Message", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}

    	modify(); 
    	frame.getView().repaint();
    }
    public void deleteRequest() {
    	if (model.getListOfShapes().size()<1) {
    		JOptionPane.showMessageDialog( null,"There are no drawn shapes", "Error Message", JOptionPane.INFORMATION_MESSAGE
    		);
    		return;
    	}
    	boolean isSelected = false;
        for (Shape s : model.getListOfShapes()) {
            if (s.isSelected()) {
                isSelected = true;
                break;
            }
        }
    	if (!isSelected) {
    		JOptionPane.showMessageDialog(null,"Nothing is selected", "Error Message", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}

    	delete(); 
    	frame.getView().repaint();
    }

   
}