package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	private Color borderColor;

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		/*
		 * this.x=x; this.y=y;
		 */
		// nasledjivanje konstruktora
		this(startPoint, endPoint);
		this.selected = selected;
	}

	public double lenght() {
		return startPoint.distance(endPoint);
	}

	public boolean equals(Object obj) {// instanceof proverava tip podatka
		if (obj instanceof Line) {
			Line temporary = (Line) obj;
			if (this.startPoint.equals(temporary.startPoint) && this.endPoint.equals(temporary.endPoint)
					&& this.selected == temporary.selected)
				return true;
		}
		return false;
	}

	public boolean contains(int x, int y) {
		Point clickPoint = new Point(x, y);
		return this.startPoint.distance(clickPoint) + this.endPoint.distance(clickPoint) - lenght() <= 2;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX() - 2, startPoint.getY() - 2, 4, 4);
			g.drawRect(endPoint.getX() - 2, endPoint.getY() - 2, 4, 4);
			g.setColor(Color.black);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		// ostavlja ovako er bismo u suprotnom od linije dobili tacku

	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);

	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Line) {
			Line shapeToCompare = (Line) obj;
			return (int) (this.lenght() - shapeToCompare.lenght());
		}
		return 0;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public String toString() {
		return this.startPoint + "-->" + this.endPoint.toString();
	}

	@Override
	protected Color getSurfaceColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

}
