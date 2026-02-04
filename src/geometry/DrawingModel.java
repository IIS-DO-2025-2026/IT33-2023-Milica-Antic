package geometry;

import java.util.ArrayList;

public class DrawingModel {
	private ArrayList<Shape> listOfShapes = new ArrayList<>();

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