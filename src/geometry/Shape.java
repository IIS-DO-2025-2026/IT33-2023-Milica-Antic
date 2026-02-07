package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Shape implements Moveable, Comparable, Serializable {
	protected boolean selected;

	public Shape() {
	}

	public Shape(boolean selected) {
		this.selected = selected;
	}

	public abstract boolean contains(int x, int y);

	public abstract boolean equals(Object obj);

	public abstract String toString();

	public abstract void draw(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	protected abstract Color getBorderColor();

	protected abstract Color getSurfaceColor();


	public abstract Shape clone();



	

	

}
