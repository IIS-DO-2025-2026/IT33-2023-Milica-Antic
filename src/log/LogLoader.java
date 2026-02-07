package log;

import java.io.*;
import java.awt.Color;
import java.util.*;
import command.AddShapeCommand;
import command.ChangeZOrderCommand;
import command.RemoveShapeCommand;
import command.UpdateShapeCommand;
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
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void executeCommandFromLog(String line) {
        line = line.trim();
        if (line.isEmpty()) {
        	return;
        }

        String[] parts = line.split(";", 2);
        String commandType = parts[0].toUpperCase();
        String details = parts.length > 1 ? parts[1] : "";

        switch (commandType) {
            case "ADD":
                Shape addShape = parseShape(details);
                if (addShape != null) {
                    controller.executeCommand(new AddShapeCommand(controller.getModel(), addShape));
                }
                break;

            case "REMOVE":
                Shape remParsed = parseShape(details);
                Shape remInModel = findInModel(remParsed);
                if (remInModel != null) {
                    controller.executeCommand(new RemoveShapeCommand(controller.getModel(), List.of(remInModel)));
                }
                break;

            case "UPDATE":
                String[] p = details.split("->");
                if (p.length == 2) {
                    Shape oldParsed = parseShape(p[0].trim());
                    Shape newParsed = parseShape(p[1].trim());
                    Shape oldInModel = findInModel(oldParsed);
                    if (oldInModel != null && newParsed != null) {
                        newParsed.setSelected(oldInModel.isSelected());
                        controller.executeCommand(new UpdateShapeCommand(controller.getModel(), oldInModel, newParsed));
                    }
                }
                break;

            case "UNDO":
                controller.undo();
                break;

            case "REDO":
                controller.redo();
                break;

            case "ZORDER":
                int lastSemi = details.lastIndexOf(";");
                if (lastSemi != -1) {
                    String shapePart = details.substring(0, lastSemi);
                    String indexPart = details.substring(lastSemi + 1);
                    Shape zShapeParsed = parseShape(shapePart);
                    Shape zShapeInModel = findInModel(zShapeParsed);
                    int newIndex = getInt(indexPart, "TOINDEX=");
                    if (zShapeInModel != null) {
                        controller.executeCommand(new ChangeZOrderCommand(controller.getModel(), zShapeInModel, newIndex));
                    }
                }
                break;

            case "SELECTED":
                Shape selInModel = findInModel(parseShape(details));
                if (selInModel != null) {
                    selInModel.setSelected(true);
                    controller.getModel().notifyObservers();
                }
                break;

            case "UNSELECTED":
                Shape unselInModel = findInModel(parseShape(details));
                if (unselInModel != null) {
                    unselInModel.setSelected(false);
                    controller.getModel().notifyObservers();
                }
                break;
        }
    }

    private Shape findInModel(Shape parsed) {
        if (parsed == null) return null;
        for (Shape s : controller.getModel().getListOfShapes()) {
            if (s.equals(parsed)) return s;
        }
        return null;
    }

    private Shape parseShape(String details) {
        try {
            String d = details.toUpperCase();

            if (d.startsWith("POINT")) {
            	  int x = getInt(details, "X=");
                  int y = getInt(details, "Y=");
                  Color border = getColor(details, "BORDER=");
                  Point p = new Point(x, y);
                  p.setBorderColor(border);
                return p;
            }

            if (d.startsWith("LINE")) {
            	 int x1 = getInt(details, "X1=");
                 int y1 = getInt(details, "Y1=");
                 int x2 = getInt(details, "X2=");
                 int y2 = getInt(details, "Y2=");
                 Color border = getColor(details, "BORDER=");
                 Line l = new Line(new Point(x1, y1), new Point(x2, y2));
                 l.setBorderColor(border);
                return l;
            }

            if (d.startsWith("RECTANGLE")) {
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
            }

            if (d.startsWith("CIRCLE")) {
            	int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                int r = getInt(details,  "RADIUS=");
                Color border = getColor(details, "BORDER=");
                Color fill = getColor(details, "FILL=");
                Circle c = new Circle(new Point(x, y), r);
                c.setBorderColor(border);
                c.setSurfaceColor(fill);
                return c;
            }

            if (d.startsWith("DONUT")) {
            	int x = getInt(details, "X=");
                int y = getInt(details, "Y=");
                int outer = getInt(details, "OUTER=");
                int inner = getInt(details, "INNER=");
                Color border = getColor(details, "BORDER=");
                Color fill = getColor(details,  "FILL=");
                Donut dn = new Donut(new Point(x, y), outer, inner);
                dn.setBorderColor(border);
                dn.setSurfaceColor(fill);
                return dn;
            }

            if (d.startsWith("HEXAGON")) {
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
        	 System.out.println("Error with parse: " + details);
             e.printStackTrace();        }
        return null;
    }

    private int getInt(String str, String key) {
        int start = str.toUpperCase().indexOf(key.toUpperCase());
        if (start == -1) return 0;

        int end = str.indexOf(";", start);
        if (end == -1) end = str.length();

        try {
            // trim samo vrednost između key i ; 
            return Integer.parseInt(str.substring(start + key.length(), end).trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private Color getColor(String str, String key) {
        int start = str.toUpperCase().indexOf(key.toUpperCase());
        if (start == -1) return Color.BLACK;

        int end = str.indexOf(";", start);
        if (end == -1) end = str.length();

        String[] rgb = str.substring(start + key.length(), end).trim().split(",");
        if (rgb.length != 3) return Color.BLACK;

        try {
            int r = Integer.parseInt(rgb[0].trim());
            int g = Integer.parseInt(rgb[1].trim());
            int b = Integer.parseInt(rgb[2].trim());
            return new Color(r, g, b);
        } catch (NumberFormatException e) {
            return Color.BLACK;
        }
    }

    public void loadBinaryFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                for (Object o : list) {
                    if (o instanceof Shape) controller.getModel().add((Shape) o);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}