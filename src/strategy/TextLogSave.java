package strategy;

import java.io.IOException;
import java.io.PrintWriter;

import mvc.DrawingController;

public class TextLogSave implements SaveStrategy{
	
	private DrawingController controller;

    public TextLogSave(DrawingController controller) {
        this.controller = controller;
    }
		@Override
		public void save( String filePath) {
		    try (PrintWriter writer = new PrintWriter(filePath)) {
		        for (String line : controller.getCommandLogger().getLog()) {
		            writer.println(line);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

}

