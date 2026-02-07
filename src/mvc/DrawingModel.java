	package mvc;
	
	import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
	import java.util.List;
	import observer.ModelObserver;
	import geometry.Shape;

public class DrawingModel implements Serializable{
	private ArrayList<Shape> listOfShapes = new ArrayList<>();
    private List<ModelObserver> observers = new ArrayList<>();
    private Color activeBorderColor = Color.BLACK;
    private Color activeSurfaceColor = Color.WHITE;


	public ArrayList<Shape> getListOfShapes() {
		return listOfShapes;
	}

	public void add(Shape s) {
		listOfShapes.add(s);
		notifyObservers();
	}

	public void remove(Shape s) {
		listOfShapes.remove(s);
		notifyObservers();
	}
	public int getSelectedCount() {
        int count = 0;
        for (Shape s : listOfShapes) {
            if (s.isSelected()) count++;
        }
        return count;
    }
	
	public int indexOf(Shape s) {
	    return listOfShapes.indexOf(s);
	}

	public void moveShape(Shape s, int newIndex) {
	    if (!listOfShapes.contains(s)) return;

	    if (newIndex < 0) newIndex = 0;
	    if (newIndex >= listOfShapes.size()) newIndex = listOfShapes.size() - 1;

	    listOfShapes.remove(s);
	    listOfShapes.add(newIndex, s);
	    notifyObservers();
	}

	public int getShapeCount() {
	    return listOfShapes.size();
	}

	public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ModelObserver o : observers) {
            o.update();
           }
        }	
    public Color getActiveBorderColor() {
		return activeBorderColor;
	}

	public void setActiveBorderColor(Color activeBorderColor) {
		this.activeBorderColor = activeBorderColor;
	}

	public Color getActiveSurfaceColor() {
		return activeSurfaceColor;
	}

	public void setActiveSurfaceColor(Color activeSurfaceColor) {
		this.activeSurfaceColor = activeSurfaceColor;
	}
	
    }