package geometry;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle implements Serializable {
	private int innerRadius;
	private transient Color borderColor;
	private transient Color surfaceColor;

	public Donut() {

	}

	public Donut(int innerRadius) {

		this.innerRadius = innerRadius;
	}

	public Donut(Point centar, int radius, int innerRadius) {

		super(centar, radius);
		this.innerRadius = innerRadius;
	}

	public Donut(Point centar, int radius, int innerRadius, boolean selected) {
		this(centar, radius, innerRadius);

		this.selected = selected;

	}

	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	public double circumference() {
		return super.circumference() + 2 * innerRadius * Math.PI;
	}

	public boolean equals(Object obj) {

		if (obj instanceof Donut) {
			Donut temporary = (Donut) obj;
			if (getCenter().equals(temporary.getCenter()) && getRadius() == temporary.getRadius()
					&& innerRadius == temporary.getInnerRadius())
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {

		return super.contains(x, y) && getCenter().distance(new Point(x, y)) >= innerRadius;
	}

	public boolean contains(Point p) {

		return this.contains(p.getX(), p.getY());
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	    Ellipse2D outerCircle = new Ellipse2D.Double( getCenter().getX() - getRadius(),getCenter().getY() - getRadius(), getRadius() * 2, getRadius() * 2);
	    Ellipse2D innerCircle = new Ellipse2D.Double(
	        getCenter().getX() - innerRadius,
	        getCenter().getY() - innerRadius,
	        innerRadius * 2,
	        innerRadius * 2
	    );
	    Area donutArea = new Area(outerCircle);
	    donutArea.subtract(new Area(innerCircle));
	    g2d.fill(donutArea);

	    if (surfaceColor != null) {
	        g2d.setColor(surfaceColor);
	        g2d.fill(donutArea);
	    }
	    if (borderColor != null) {
	        g2d.setColor(borderColor);
	        g2d.draw(outerCircle);
	        g2d.draw(innerCircle);	        
	    }
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Donut) {
			Donut shapeToCompare = (Donut) obj;
			return (int) (this.area() - shapeToCompare.area());
		}
		return 0;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public String toString() {

		return super.toString() + ", innerRadius = " + innerRadius;
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
	@Override
	public Donut clone() {
	    Donut copy = new Donut(this.getCenter().clone(),this.getRadius(),this.getInnerRadius(),this.isSelected());
	    copy.setBorderColor(this.getBorderColor());
	    copy.setSurfaceColor(this.getSurfaceColor());
	    return copy;
	}

}
