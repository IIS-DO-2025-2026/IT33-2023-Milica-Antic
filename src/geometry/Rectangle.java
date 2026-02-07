package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;


public class Rectangle extends Shape implements Serializable {
	private Point upperLeftPoint;
	private int width;
	private int height;
	//private boolean selected;
	private transient Color borderColor;
	private transient Color surfaceColor;

	public Rectangle() {
	}

	public Rectangle(Point point, int width, int height) {
		this.upperLeftPoint = point;
		this.height = height;
		this.width = width;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		/*
		 * this.x=x; this.y=y;
		 */
		// nasledjivanje konstruktora
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temporary = (Rectangle) obj;
			if (this.upperLeftPoint.equals(temporary.upperLeftPoint) && this.width == temporary.width
					&& this.height == temporary.height && this.selected == temporary.selected)
				return true;
		}
		return false;
	}

	public boolean contains(int x, int y) {
		return (x >= this.upperLeftPoint.getX() && x <= this.upperLeftPoint.getX() + width
				&& y >= this.upperLeftPoint.getY() && y <= this.upperLeftPoint.getY() + height);
	}

	// overloading moze i nad metodama koje nisu konstruktori
	public boolean contains(Point clickPoint) {
		return (clickPoint.getX() >= this.upperLeftPoint.getX()
				&& clickPoint.getX() <= this.upperLeftPoint.getX() + width
				&& clickPoint.getY() >= this.upperLeftPoint.getY()
				&& clickPoint.getY() <= this.upperLeftPoint.getY() + height);
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * width + 2 * height;
	}

	@Override
	public void draw(Graphics g) {
		if (surfaceColor != null) {
			g.setColor(surfaceColor);
			g.fillRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		}
		g.setColor(borderColor != null ? borderColor : Color.BLACK);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);

		if (isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub
		upperLeftPoint.moveBy(x, y);

	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle shapeToCompare = (Rectangle) obj;
			return this.area() - shapeToCompare.area();
		}
		return 0;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;

	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
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
		return "RECTANGLE;"+"x=" + upperLeftPoint.getX() + ";" + "y=" + upperLeftPoint.getY() + ";" +"width=" + width + ";"+"height=" + height+";"+"border="+colorToString(borderColor)+";"+"fill="+colorToString(surfaceColor);
	}
	@Override
	public Rectangle clone() {
	    Rectangle copy = new Rectangle(this.upperLeftPoint.clone(),this.width,this.height,this.isSelected());
	    copy.setBorderColor(this.borderColor);
	    copy.setSurfaceColor(this.surfaceColor);
	    return copy;
	}

	
}
