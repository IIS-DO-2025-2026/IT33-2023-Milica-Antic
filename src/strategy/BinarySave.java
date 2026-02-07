package strategy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import geometry.Shape;
import mvc.DrawingController;

public class BinarySave implements SaveStrategy {
	private DrawingController controller;

    public BinarySave(DrawingController controller) {
        this.controller = controller;
    }

    public void save(String filePath) {
        List<Shape> shapes = controller.getModel().getListOfShapes(); // samo lista oblika

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(shapes);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
