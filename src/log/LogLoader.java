package log;

import java.io.*;
import java.awt.Color;
import java.util.*;
import geometry.*;
import hexagon.Hexagon;
import mvc.DrawingController;

public class LogLoader {

    private DrawingController controller;

    public LogLoader(DrawingController controller) {
        this.controller = controller;
    }
    public List<String> readLogFile(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) { //trim mi brise sav prazan prostor
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void executeCommandFromLog(String line) {
        String[] parts = line.split(";", 2); 
        String commandType = parts[0];
        String details = parts.length > 1 ? parts[1] : "";

        switch (commandType.toUpperCase()) {
            case "ADD":
                Shape s = parseShape(details);
                if (s != null) {
                	controller.addShape(s);
                }
                break;
            case "REMOVE":
                Shape r = parseShape(details);
                if (r != null) {
                	controller.removeShape(r);
                }
                break;
            case "UPDATE":
                String[] updateParts = details.split("->");
                if (updateParts.length == 2) {
                    Shape oldShape = parseShape(updateParts[0].trim());
                    Shape newShape = parseShape(updateParts[1].trim());
                    if (oldShape != null && newShape != null) {
                        controller.updateShape(oldShape, newShape);
                    }
                }
                break;
        }
    }
    

    private Shape parseShape(String details) {
        try {
            details = details.toUpperCase();
            if (details.startsWith("POINT")) {
                int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                Color border = getColor(details, "BORDER=");
                Point p = new Point(x, y);
                p.setBorderColor(border);
                return p;
            } else if (details.startsWith("LINE")) {
                int x1 = getInt(details, "X1=");
                int y1 = getInt(details, "Y1=");
                int x2 = getInt(details, "X2=");
                int y2 = getInt(details, "Y2=");
                Color border = getColor(details, "BORDER=");
                Line l = new Line(new Point(x1, y1), new Point(x2, y2));
                l.setBorderColor(border);
                return l;
            } else if (details.startsWith("RECTANGLE")) {
                int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                int w = getInt(details, "WIDTH=");
                int h = getInt(details, "HEIGHT=");
                Color border = getColor(details, "BORDER=");
                Color fill = getColor(details, "FILL=");
                Rectangle r = new Rectangle(new Point(x, y), w, h);
                r.setBorderColor(border);
                r.setSurfaceColor(fill);
                return r;
            } else if (details.startsWith("CIRCLE")) {
                int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                int r = getInt(details,  "RADIUS=");
                Color border = getColor(details, "BORDER=");
                Color fill = getColor(details, "FILL=");
                Circle c = new Circle(new Point(x, y), r);
                c.setBorderColor(border);
                c.setSurfaceColor(fill);
                return c;
            } else if (details.startsWith("DONUT")) {
                int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                int outer = getInt(details, "OUTER=");
                int inner = getInt(details, "INNER=");
                Color border = getColor(details, "BORDER=");
                Color fill = getColor(details,  "FILL=");
                Donut d = new Donut(new Point(x, y), outer, inner);
                d.setBorderColor(border);
                d.setSurfaceColor(fill);
                return d;
            } else if (details.startsWith("HEXAGON")) {
                int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                int r = getInt(details,  "RADIUS=");
                Color border = getColor(details, "BORDER=");
                Color fill = getColor(details, "FILL=");
                Hexagon h = new Hexagon(x, y, r);
                HexagonAdapter hex = new HexagonAdapter(h);
                hex.setBorderColor(border);
                hex.setSurfaceColor(fill);
                return hex;
            }
        } catch (Exception e) {
            System.out.println("Greška pri parsiranju oblika: " + details);
            e.printStackTrace();
        }
        return null;
    }

 

    private int getInt(String str, String key) {
        int start = str.indexOf(key);
        if (start == -1) {
        	return 0; 
        }
        int end = str.indexOf(";", start);
        if (end == -1) {
        	end = str.length(); 
        }
        return Integer.parseInt(str.substring(start + key.length(), end).trim());
    }

    private Color getColor(String str, String key) {
        int start = str.indexOf(key);
        if (start == -1) {
        	return Color.BLACK; 
        }
        int end = str.indexOf(";", start);
        if (end == -1) {
        	end = str.length();
        }
        String[] rgb = str.substring(start + key.length(), end).trim().split(",");
        if (rgb.length != 3) {
        	return Color.BLACK; 
        }
        int r = Integer.parseInt(rgb[0].trim());
        int g = Integer.parseInt(rgb[1].trim());
        int b = Integer.parseInt(rgb[2].trim());

        return new Color(r, g, b);
    }
}
