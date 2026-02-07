package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Circle extends Shape implements Serializable {
	private Point center;
	private int radius;
	private transient Color borderColor;
	private transient Color surfaceColor;

	public Circle() {
	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		/*
		 * this.x=x; this.y=y;
		 */
		// nasledjivanje konstruktora
		this(center, radius);
		this.selected = selected;
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle temporary = (Circle) obj;
			if (this.center.equals(temporary.center) && this.selected == temporary.selected)
				return true;
		}
		return false;
	}

	public boolean contains(int x, int y) {
		Point clickPoint = new Point(x, y);
		return (this.center.distance(clickPoint) <= this.radius);
	}

	public boolean contains(Point clickPoint) {
		return (this.center.distance(clickPoint) <= this.radius);
	}

	@Override
	public void draw(Graphics g) {
		if (surfaceColor != null) {
			g.setColor(surfaceColor);
			g.fillOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
		}
		g.setColor(borderColor != null ? borderColor : Color.BLACK);
		g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		center.moveTo(x, y);

	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		center.moveBy(x, y);

	}

	public int compareTo(Object obj) {
		if (obj instanceof Circle) {
			Circle shapeToCompare = (Circle) obj;
			return (int) (this.area() - shapeToCompare.area());
		}
		return 0;
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getSurfaceColor() {
		return surfaceColor;
	}

	public void setSurfaceColor(Color surfaceColor) {
		this.surfaceColor = surfaceColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public String toString() {
		return "center: " + center + ", radius = " + radius;
	}
	@Override
	public Circle clone() {
	    Circle copy = new Circle(this.center.clone(),this.radius,this.isSelected());
	    copy.setBorderColor(this.borderColor);
	    copy.setSurfaceColor(this.surfaceColor);
	    return copy;
	}

}
