package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	private Point point = new Point();
	private Point point1 = null;
	private DlgRectangle dlgRectangle;
	private DlgCircle dlgCircle;
	private DlgDonut dlgDonut;
	private DlgPoint dlgPoint;
	private DlgLine dlgLine;
	private Shape selectedShape;
	private ArrayList<Shape> listOfShapes = new ArrayList<>();

	/**
	 * Create the panel.
	 */

	public PnlDrawing() {

	}

	public void drawing(MouseEvent e, FrmDrawing frame) {

		point = new Point(e.getX(), e.getY());

		switch (frame.getWord()) {
		case "point": {
			dlgPoint = new DlgPoint();
			dlgPoint.getTxtFieldPointX().setText(String.valueOf(e.getX()));
			dlgPoint.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgPoint.getTxtFieldPointX().setEditable(false);
			dlgPoint.getTxtFieldPointY().setEditable(false);
			dlgPoint.setVisible(true);
			if (dlgPoint.isOk()) {
				if (dlgPoint.getBackColor() == null) {
					point.setBorderColor(Color.black);
				} else {

					point.setBorderColor(dlgPoint.getBackColor());
				}
				listOfShapes.add(point);

			}

		}
			break;

		case "line": {

			if (point1 == null)

			{
				point1 = new Point(e.getX(), e.getY());
			}

			else {
				Line line = new Line(point, point1);
				dlgLine = new DlgLine();
				dlgLine.getTxtFieldStartPointX().setText(String.valueOf(point.getX()));
				dlgLine.getTxtFieldStartPointY().setText(String.valueOf(point.getY()));
				dlgLine.getTxtFieldEndPointX().setText(String.valueOf(point1.getX()));
				dlgLine.getTxtFieldEndPointY().setText(String.valueOf(point1.getY()));
				dlgLine.getTxtFieldStartPointX().setEditable(false);
				dlgLine.getTxtFieldStartPointY().setEditable(false);
				dlgLine.getTxtFieldEndPointX().setEditable(false);
				dlgLine.getTxtFieldEndPointY().setEditable(false);
				dlgLine.setVisible(true);
				if (dlgLine.isOk()) {
					if (dlgLine.getBackColor() == null) {
						line.setBorderColor(Color.black);
					} else {

						line.setBorderColor(dlgLine.getBackColor());
					}

					listOfShapes.add(line);
				}
				point1 = null;

			}

		}
			break;
		case "rectangle": {

			dlgRectangle = new DlgRectangle();
			dlgRectangle.getTxtFieldPointX().setText(String.valueOf(e.getX()));
			dlgRectangle.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgRectangle.getLblChooseASurfaceColor().setForeground(Color.white);
			dlgRectangle.getTxtFieldPointX().setEditable(false);
			dlgRectangle.getTxtFieldPointY().setEditable(false);
			dlgRectangle.setVisible(true);
			Rectangle rect = new Rectangle();
			if (dlgRectangle.isOk()) {

				rect = new Rectangle(point, Integer.parseInt(dlgRectangle.getTxtFieldWidth().getText()),
						Integer.parseInt(dlgRectangle.getTxtFieldHeight().getText()));

				if (dlgRectangle.getBackColor() == null) {
					rect.setBorderColor(Color.black);
				} else {

					rect.setBorderColor(dlgRectangle.getBackColor());
				}

				if (dlgRectangle.getSurfaceColor() == null) {
					rect.setSurfaceColor(getBackground());
				} else {
					rect.setSurfaceColor(dlgRectangle.getSurfaceColor());
				}

				listOfShapes.add(rect);
			}

		}
			break;

		case "circle": {
			dlgCircle = new DlgCircle();
			dlgCircle.getTxtFieldPointX().setText(String.valueOf(e.getX()));
			dlgCircle.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgCircle.getLblChooseASurfaceColor().setForeground(Color.white);
			dlgCircle.getTxtFieldPointX().setEditable(false);
			dlgCircle.getTxtFieldPointY().setEditable(false);
			dlgCircle.setVisible(true);
			Circle circle = new Circle();
			if (dlgCircle.isOk()) {

				int r = Integer.parseInt(dlgCircle.getTxtFieldRadius().getText());
				circle = new Circle(point, r);
				if (dlgCircle.getBackColor() == null) {
					circle.setBorderColor(Color.black);
				} else {

					circle.setBorderColor(dlgCircle.getBackColor());
				}

				if (dlgCircle.getSurfaceColor() == null) {
					circle.setSurfaceColor(getBackground());
				} else {
					circle.setSurfaceColor(dlgCircle.getSurfaceColor());
				}

				listOfShapes.add(circle);
			}

		}
			break;
		case "donut": {
			Donut donut = new Donut();
			dlgDonut = new DlgDonut();
			dlgDonut.getTxtFieldPointX().setText(String.valueOf(e.getX()));
			dlgDonut.getTxtFieldPointY().setText(String.valueOf(e.getY()));
			dlgDonut.getLblChooseASurfaceColor().setForeground(Color.white);
			dlgDonut.getTxtFieldPointX().setEditable(false);
			dlgDonut.getTxtFieldPointY().setEditable(false);
			dlgDonut.setVisible(true);

			if (dlgDonut.isOk()) {

				int r1 = Integer.parseInt(dlgDonut.getTxtFieldBiggerRadius().getText());
				int r2 = Integer.parseInt(dlgDonut.getTxtFieldSmallerRadius().getText());
				donut = new Donut(point, r1, r2);
				if (dlgDonut.getBackColor() == null) {
					donut.setBorderColor(Color.black);
				} else {

					donut.setBorderColor(dlgDonut.getBackColor());
				}
				if (dlgDonut.getSurfaceColor() == null) {
					donut.setSurfaceColor(getBackground());
				} else {
					donut.setSurfaceColor(dlgDonut.getSurfaceColor());
				}

				listOfShapes.add(donut);
			}

		}
			break;
		case "selected": {

			selectedShape = null;
			Collections.reverse(listOfShapes);
			Iterator<Shape> itShape = listOfShapes.iterator();
			while (itShape.hasNext()) {
				Shape tempShape = itShape.next();
				if (tempShape.contains(e.getX(), e.getY()) && !tempShape.isSelected() && selectedShape == null) {
					tempShape.setSelected(true);
					tempShape.draw(getGraphics());
					selectedShape = tempShape;

				}

				else if (tempShape.isSelected()) {
					tempShape.setSelected(false);
					selectedShape = null;
				}

			}
			Collections.reverse(listOfShapes);

		}
			break;

		/*
		 * case "delete": { if (selectedShape == null) {
		 * JOptionPane.showMessageDialog(null, "Nothing 2 is selected", "Error Message",
		 * JOptionPane.INFORMATION_MESSAGE); } } break; case "modify": { { if
		 * (selectedShape == null) JOptionPane.showMessageDialog(null,
		 * "Nothing 3 is selected", "Error Message", JOptionPane.INFORMATION_MESSAGE); }
		 * 
		 * } break;
		 */

		default: {
			JOptionPane.showMessageDialog(null, "Choose one of  options", "Error Message",
					JOptionPane.INFORMATION_MESSAGE);
		}

		}

		repaint();
	}

	public void paint(Graphics g) {

		super.paint(g);

		Iterator<Shape> itShapeDraw = listOfShapes.iterator();
		while (itShapeDraw.hasNext()) {
			Shape temp = itShapeDraw.next();
			if (temp instanceof Point || temp instanceof Line) {
				if (temp.getBorderColor() != null) {
					g.setColor(temp.getBorderColor());
				} else {
					g.setColor(Color.black);
				}
				temp.draw(g);
			}
			if (temp instanceof Rectangle) {
				Rectangle temp1 = (Rectangle) temp;
				if (temp.getSurfaceColor() != null) {
					g.setColor(temp.getSurfaceColor());

				} else {
					g.setColor(Color.white);

				}
				g.fillRect(temp1.getUpperLeftPoint().getX(), temp1.getUpperLeftPoint().getY(), temp1.getWidth(),
						temp1.getHeight());

				if (temp.getBorderColor() != null) {

					g.setColor(temp.getBorderColor());
				} else {
					g.setColor(Color.black);
				}
				temp.draw(g);

			}
			if (temp instanceof Circle && !(temp instanceof Donut)) {
				Circle temp1 = (Circle) temp;
				if (temp.getSurfaceColor() != null) {
					g.setColor(temp.getSurfaceColor());

				} else {
					g.setColor(Color.white);
				}
				g.fillOval(temp1.getCenter().getX() - temp1.getRadius(),
						temp1.getCenter().getY() - temp1.getRadius(), 2 * temp1.getRadius(),
						2 * temp1.getRadius());

				if (temp.getBorderColor() != null) {

					g.setColor(temp.getBorderColor());
				} else {
					g.setColor(Color.black);
				}
				temp.draw(g);
			}

			if (temp instanceof Donut) {
				Donut temp1 = (Donut) temp;
				Color color = temp.getSurfaceColor();
				if (color != null) {

					g.setColor(color);
					g.fillOval(temp1.getCenter().getX() - temp1.getRadius(),
							temp1.getCenter().getY() - temp1.getRadius(), 2 * temp1.getRadius(),
							2 * temp1.getRadius());

				}

				g.setColor(Color.white);
				g.fillOval(temp1.getCenter().getX() - temp1.getInnerRadius(),
						temp1.getCenter().getY() - temp1.getInnerRadius(), 2 * temp1.getInnerRadius(),
						2 * temp1.getInnerRadius());

				if (temp.getBorderColor() != null) {

					g.setColor(temp.getBorderColor());
				} else {
					g.setColor(Color.black);
				}
				temp.draw(g);

			}

		}

	}

	public void delete() {

		DlgDelete dlgDelete = new DlgDelete();
		dlgDelete.setVisible(true);
		if (dlgDelete.isOk()) {
			Iterator<Shape> itShape = listOfShapes.iterator();
			while (itShape.hasNext()) {
				Shape tempShape = itShape.next();
				if (tempShape.equals(selectedShape)) {
					itShape.remove();

				}

			}
			selectedShape = null;
		} else {

			selectedShape = null;
		}

		repaint();
	}

	public void modify() 
	{

		if (selectedShape instanceof Point) {
			Point temp = (Point) selectedShape;
			dlgPoint = new DlgPoint();
			dlgPoint.getTxtFieldPointX().setText(String.valueOf(temp.getX()));
			dlgPoint.getTxtFieldPointY().setText(String.valueOf(temp.getY()));
			dlgPoint.getLblChooseABorderColor().setForeground(temp.getBorderColor());
			dlgPoint.getTxtFieldPointX().setEditable(true);
			dlgPoint.getTxtFieldPointY().setEditable(true);
			dlgPoint.setVisible(true);
			if (dlgPoint.isOk()) {
				((Point) selectedShape).setX(Integer.parseInt(dlgPoint.getTxtFieldPointX().getText()));
				((Point) selectedShape).setY(Integer.parseInt(dlgPoint.getTxtFieldPointY().getText()));
				if (dlgPoint.getBackColor() != null) {
					((Point) selectedShape).setBorderColor(dlgPoint.getBackColor());
				} else {
					((Point) selectedShape).setBorderColor(temp.getBorderColor());
				}

				((Point) selectedShape).setSelected(false);
			}

		}
		if (selectedShape instanceof Line) {

			Line temp = (Line) selectedShape;
			dlgLine.getTxtFieldStartPointX().setText(String.valueOf(temp.getStartPoint().getX()));
			dlgLine.getTxtFieldStartPointY().setText(String.valueOf(temp.getStartPoint().getY()));
			dlgLine.getTxtFieldEndPointX().setText(String.valueOf(temp.getEndPoint().getX()));
			dlgLine.getTxtFieldEndPointY().setText(String.valueOf(temp.getEndPoint().getY()));
			dlgLine.getLblChooseABorderColor().setForeground(temp.getBorderColor());
			dlgLine.getTxtFieldStartPointX().setEditable(true);
			dlgLine.getTxtFieldStartPointY().setEditable(true);
			dlgLine.getTxtFieldEndPointX().setEditable(true);
			dlgLine.getTxtFieldEndPointY().setEditable(true);
			dlgLine.setVisible(true);
			if (dlgLine.isOk()) {
				((Line) selectedShape).getStartPoint()
						.setX(Integer.parseInt(dlgLine.getTxtFieldStartPointX().getText()));
				((Line) selectedShape).getStartPoint()
						.setY(Integer.parseInt(dlgLine.getTxtFieldStartPointY().getText()));
				((Line) selectedShape).getEndPoint().setX(Integer.parseInt(dlgLine.getTxtFieldEndPointX().getText()));
				((Line) selectedShape).getEndPoint().setY(Integer.parseInt(dlgLine.getTxtFieldEndPointY().getText()));
				if (dlgLine.getBackColor() != null) {
					((Line) selectedShape).setBorderColor(dlgLine.getBackColor());
				} else {
					((Line) selectedShape).setBorderColor(temp.getBorderColor());
				}
				((Line) selectedShape).setSelected(false);
			}

		}
		if (selectedShape instanceof Rectangle) {
			Rectangle temp = (Rectangle) selectedShape;
			dlgRectangle = new DlgRectangle();
			dlgRectangle.getTxtFieldPointX().setText(String.valueOf(temp.getUpperLeftPoint().getX()));
			dlgRectangle.getTxtFieldPointY().setText(String.valueOf(temp.getUpperLeftPoint().getY()));
			dlgRectangle.getTxtFieldWidth().setText(String.valueOf(temp.getWidth()));
			dlgRectangle.getTxtFieldHeight().setText(String.valueOf(temp.getHeight()));
			dlgRectangle.getLblChooseABorderColor().setForeground(temp.getBorderColor());
			dlgRectangle.getLblChooseASurfaceColor().setForeground(temp.getSurfaceColor());
			dlgRectangle.getTxtFieldPointX().setEditable(true);
			dlgRectangle.getTxtFieldPointY().setEditable(true);
			dlgRectangle.setVisible(true);
			if (dlgRectangle.isOk()) {
				((Rectangle) selectedShape).getUpperLeftPoint()
						.setX(Integer.parseInt(dlgRectangle.getTxtFieldPointX().getText()));
				((Rectangle) selectedShape).getUpperLeftPoint()
						.setY(Integer.parseInt(dlgRectangle.getTxtFieldPointY().getText()));
				((Rectangle) selectedShape).setHeight(Integer.parseInt(dlgRectangle.getTxtFieldHeight().getText()));
				((Rectangle) selectedShape).setWidth(Integer.parseInt(dlgRectangle.getTxtFieldWidth().getText()));
				if (dlgRectangle.getBackColor() != null) {
					((Rectangle) selectedShape).setBorderColor(dlgRectangle.getBackColor());
				} else {
					((Rectangle) selectedShape).setBorderColor(temp.getBorderColor());
				}

				if (dlgRectangle.getSurfaceColor() != null) {
					((Rectangle) selectedShape).setSurfaceColor(dlgRectangle.getSurfaceColor());
				} else {
					((Rectangle) selectedShape).setSurfaceColor(temp.getSurfaceColor());
				}

				((Rectangle) selectedShape).setSelected(false);
			}
		}

		if (selectedShape instanceof Circle && !(selectedShape instanceof Donut)) {
			Circle temp = (Circle) selectedShape;
			dlgCircle = new DlgCircle();
			dlgCircle.getTxtFieldPointX().setText(String.valueOf(temp.getCenter().getX()));
			dlgCircle.getTxtFieldPointY().setText(String.valueOf(temp.getCenter().getY()));
			dlgCircle.getTxtFieldRadius().setText(String.valueOf(temp.getRadius()));
			dlgCircle.getLblChooseABorderColor().setForeground(temp.getBorderColor());
			dlgCircle.getLblChooseASurfaceColor().setForeground(temp.getSurfaceColor());
			dlgCircle.getTxtFieldPointX().setEditable(true);
			dlgCircle.getTxtFieldPointY().setEditable(true);
			dlgCircle.setVisible(true);
			if (dlgCircle.isOk()) {
				((Circle) selectedShape).getCenter()
						.setX(Integer.parseInt(dlgCircle.getTxtFieldPointX().getText()));
				((Circle) selectedShape).getCenter()
						.setY(Integer.parseInt(dlgCircle.getTxtFieldPointY().getText()));
				((Circle) selectedShape).setRadius(Integer.parseInt(dlgCircle.getTxtFieldRadius().getText()));

				if (dlgCircle.getBackColor() != null) {
					((Circle) selectedShape).setBorderColor(dlgCircle.getBackColor());
				} else {
					((Circle) selectedShape).setBorderColor(temp.getBorderColor());
				}

				if (dlgCircle.getSurfaceColor() != null) {
					((Circle) selectedShape).setSurfaceColor(dlgCircle.getSurfaceColor());
				} else {
					((Circle) selectedShape).setSurfaceColor(temp.getSurfaceColor());
				}

				((Circle) selectedShape).setSelected(false);
			}

		}
		if (selectedShape instanceof Donut) {
			Donut temp = (Donut) selectedShape;
			dlgDonut = new DlgDonut();
			dlgDonut.getTxtFieldPointX().setText(String.valueOf(temp.getCenter().getX()));
			dlgDonut.getTxtFieldPointY().setText(String.valueOf(temp.getCenter().getY()));
			dlgDonut.getTxtFieldBiggerRadius().setText(String.valueOf(temp.getRadius()));
			dlgDonut.getTxtFieldSmallerRadius().setText(String.valueOf(temp.getInnerRadius()));
			dlgDonut.getLblChooseABorderColor().setForeground(temp.getBorderColor());
			dlgDonut.getLblChooseASurfaceColor().setForeground(temp.getSurfaceColor());
			dlgDonut.getTxtFieldPointX().setEditable(true);
			dlgDonut.getTxtFieldPointY().setEditable(true);
			dlgDonut.setVisible(true);
			if (dlgDonut.isOk()) {
				((Donut) selectedShape).getCenter().setX(Integer.parseInt(dlgDonut.getTxtFieldPointX().getText()));
				((Donut) selectedShape).getCenter().setY(Integer.parseInt(dlgDonut.getTxtFieldPointY().getText()));
				((Donut) selectedShape).setRadius(Integer.parseInt(dlgDonut.getTxtFieldBiggerRadius().getText()));
				((Donut) selectedShape).setInnerRadius(Integer.parseInt(dlgDonut.getTxtFieldSmallerRadius().getText()));
				if (dlgDonut.getBackColor() != null) {
					((Donut) selectedShape).setBorderColor(dlgDonut.getBackColor());
				} else {
					((Donut) selectedShape).setBorderColor(temp.getBorderColor());
				}

				if (dlgDonut.getSurfaceColor() != null) {
					((Donut) selectedShape).setSurfaceColor(dlgDonut.getSurfaceColor());
				} else {
					((Donut) selectedShape).setSurfaceColor(temp.getSurfaceColor());
				}
				((Donut) selectedShape).setSelected(false);
			}
		}
		selectedShape = null;

		repaint();
	}

	public Shape getSelectedShape() {
		return selectedShape;
	}

	public void setSelectedShape(Shape selectedShape) {
		this.selectedShape = selectedShape;
	}

	public ArrayList<Shape> getListOfShapes() {
		return listOfShapes;
	}

	public void setListOfShapes(ArrayList<Shape> listOfShapes) {
		this.listOfShapes = listOfShapes;
	}
}
