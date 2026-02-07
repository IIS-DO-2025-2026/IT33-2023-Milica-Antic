package geometry;

import java.awt.Color;
import java.awt.Graphics;
import hexagon.Hexagon; 

public class HexagonAdapter extends Shape {
	
	private Hexagon hexagon;
	
	public HexagonAdapter() {
		
	}
	  public HexagonAdapter(Hexagon hexagon) {
	        this.hexagon = hexagon;
	    }	
	public HexagonAdapter(int x,int y, int r) {
        hexagon = new Hexagon(x, y, r);

	}
	
	public HexagonAdapter(int x,int y, int r,boolean selected, Color borderColor,Color surfaceColor	) {
		  this(x, y, r);
	        hexagon.setSelected(selected);
	        hexagon.setBorderColor(borderColor);
	        hexagon.setAreaColor(surfaceColor);
	}
	public  boolean contains(int x, int y) {
		return hexagon.doesContain(x,y);
	}

	public  boolean equals(Object obj) {
		if( obj instanceof HexagonAdapter) {
			HexagonAdapter temp = (HexagonAdapter) obj;
            if(hexagon.getX() == temp.hexagon.getX() &&
            hexagon.getY() == temp.hexagon.getY() && hexagon.getR() == temp.hexagon.getR()
            && hexagon.isSelected()==temp.isSelected())
			return true;
		}
		return false;
	}


	public  void draw(Graphics g) {
		hexagon.paint(g);
	 }
	
	public void moveBy(int x, int y) {
		hexagon.setX(hexagon.getX() + x);
		hexagon.setY(hexagon.getY() + y);
    }
	public  void moveTo(int x, int y) {
		hexagon.setX(x);
        hexagon.setY(y);
	}
	
	public Color getBorderColor() {
        return hexagon.getBorderColor();

	}
	public void setBorderColor(Color borderColor) {
		hexagon.setBorderColor(borderColor);
	}

	public Color getSurfaceColor() {
        return hexagon.getAreaColor();

	}
	public void setSurfaceColor(Color surfaceColor) {
		hexagon.setAreaColor(surfaceColor);
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof HexagonAdapter) {
            HexagonAdapter shapeToCompare = (HexagonAdapter) obj;
            return this.hexagon.getR() - shapeToCompare.hexagon.getR();
        }
        return 0;
	}
	public  String toString() {
		return "Point x=" + hexagon.getX() + ", point y=" + hexagon.getY() + ", radius=" + hexagon.getR() ;
	}
	public Hexagon getHexagon() {
        return hexagon;
    }

    public int getX() {
        return hexagon.getX();
    }

    public int getY() {
        return hexagon.getY();
    }

    public void setX(int x) {
        hexagon.setX(x);
    }

    public void setY(int y) {
         hexagon.setY(y);
    }
    public int getR() {
        return hexagon.getR();
    }

    public void setR(int r) {
        hexagon.setR(r);
    }

    @Override
    public boolean isSelected() {
        return hexagon.isSelected();
    }

    @Override
    public void setSelected(boolean selected) {
        hexagon.setSelected(selected);
    }
    @Override
    public HexagonAdapter clone() {
        HexagonAdapter copy = new HexagonAdapter(hexagon.getX(),hexagon.getY(),hexagon.getR(),hexagon.isSelected(),hexagon.getBorderColor(),hexagon.getAreaColor());

        return copy;
    }

}

