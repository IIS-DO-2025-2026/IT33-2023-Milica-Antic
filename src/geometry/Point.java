package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public class Point extends Shape implements Serializable {
//property klase point- PRIVATE
	// podrazumevano vrednosti inr-0,boolean-false;
	private int x;
	private int y;
	private transient Color borderColor;

	public Point() {
	}

	public Point(int x, int y) {
		super();// u pozadini poziva
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		/*
		 * this.x=x; this.y=y;
		 */
		// nasledjivanje konstruktora
		this(x, y);
		this.selected = selected;
	}

	public double distance(Point distantPoint) {// this.x je x koordinata tacke nad kojim je pozvana metoda distance u
													// klasiTest
		int a = this.x - distantPoint.x;
		int b = this.y - distantPoint.y;
		double distance = Math.sqrt(a * a + b * b);
		return distance;
	}

	public boolean equals(Object point) {// instanceof proverava tip podatka
		if (point instanceof Point) {
			if (this.x == ((Point) point).x && this.y == ((Point) point).y
					&& this.selected == ((Point) point).selected) {
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean contains(int x, int y) {
		Point clickPoint = new Point(x, y);
		return this.distance(clickPoint) <= 2;
	}

	// idu dve linije jer ne crtamo tacku nego plus
	@Override
	public void draw(Graphics g) {
		g.setColor(borderColor != null ? borderColor : Color.BLACK);
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		if (this.selected) {
			g.setColor(Color.blue);
			g.drawRect(x - 2, y - 2, 4, 4);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;

	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		this.x += x;
		this.y += y;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Point) {
			Point shapeToCompare = (Point) o;
			return (int) this.distance(new Point(0, 0)) - (int) shapeToCompare.distance(new Point(0, 0));
		}
		return 0;
	}

	public int getX() {
		return x;
		// return this.x
	}

	public void setX(int x) {// property x klase point je prosledjeno x metodi
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	@Override
	protected Color getSurfaceColor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Point clone() {
	    Point copy = new Point(this.x, this.y, this.isSelected());
	    copy.setBorderColor(this.borderColor);
	    return copy;
	}


}
