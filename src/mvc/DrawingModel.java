package mvc;

import java.util.ArrayList;

import geometry.Shape;

public class DrawingModel {
	private ArrayList<Shape> listOfShapes = new ArrayList<>();
	private Shape selectedShape;

	public ArrayList<Shape> getListOfShapes() {
		return listOfShapes;
	}

	public void add(Shape s) {
		listOfShapes.add(s);
	}

	public void remove(Shape s) {
		listOfShapes.remove(s);
	}
	

}