package mvc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import observer.ModelObserver;
import geometry.Shape;

public class DrawingModel {
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
	public void selectionChanged() {
	    notifyObservers();
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