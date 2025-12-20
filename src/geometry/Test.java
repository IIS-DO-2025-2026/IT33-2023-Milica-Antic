package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// inicijalicuje property klase Ponit na podrazumevano
		// prvaTacka je 0 0 false
		Point prvaTackaTest = new Point();
		Point drugaTacka = new Point();
		System.out.println(prvaTackaTest.getX());
		prvaTackaTest.setX(50);
		System.out.println(prvaTackaTest.getX());
		System.out.println(drugaTacka.getX());
		drugaTacka.setX(60);
		System.out.println(drugaTacka.getX());

		// metoda instance
		// objekat klase point jer je distance ponasanje tacke

		System.out.println(prvaTackaTest.distance(drugaTacka));
		Point point1 = new Point();
		Point point2 = new Point();
		Line line1 = new Line();
		point1.setX(20);
		point1.setY(20);
		point2.setX(30);
		point2.setY(30);
		point1.setX(point2.getY());

		// System.out.println(line1.getStartPoint().getX());
		line1.setStartPoint(point1);
		line1.setEndPoint(point2);
		System.out.println(line1.getStartPoint().getX());
		System.out.println(line1.getStartPoint().getY());
		System.out.println(line1.getEndPoint().getX());
		System.out.println(line1.getEndPoint().getY());

		line1.getEndPoint().setY(23);
		System.out.println(line1.getEndPoint().getY());
		System.out.println(point2.getY());
		line1.getStartPoint().setX(line1.getEndPoint().getY());

		line1.getEndPoint().setX((int) line1.lenght() - line1.getStartPoint().getX() - line1.getStartPoint().getY());
		Rectangle rect = new Rectangle();

		rect.setUpperLeftPoint(point2);

		rect.getUpperLeftPoint().setX(10);
		rect.getUpperLeftPoint().setY(15);
		// konstrultori
		Point tacka = new Point(2, 3);
		Point tacka1 = new Point(4, 5);
		System.out.println(tacka.toString());
		Line linija = new Line(tacka, tacka1);
		// moze sa i bez toString()
		System.out.println(linija.toString());
		System.out.println(linija);

		int a = 4;
		int b = 4;
		Point novaTacka = new Point(2, 3);
		Point novaTacka1 = new Point(2, 3);
		System.out.println(a == b);
		// kod slozenih tipova == poredi referencu a ne vednosti x i y
		System.out.println(novaTacka == novaTacka1);
		// za poredjenje koordinata se koristi equals, ona je u klasi Object,ona je
		// metoda instance
		System.out.println(novaTacka.equals(novaTacka1));
		// System.out.println(novaTacka.equals(linija));

		Donut donut1 = new Donut(novaTacka, 50, 45);

		donut1.setRadius(60);
		System.out.println(donut1);

		Circle donut2 = new Donut(50);
		System.out.println(donut2);
		((Donut) donut2).setInnerRadius(60);

		// Shape shape1=new Shape(); ->nije moguce jer je apstraktna klasa
		Shape shape1 = new Point(50, 60); // isto je kao Point shape1=new Point(50,60);
		System.out.println(shape1.isSelected());
		System.out.println(((Point) shape1).getX());
		Point p3 = new Point(50, 50);
		Rectangle r10 = new Rectangle(p3, 10, 10);
		Rectangle r20 = new Rectangle(p3, 20, 20);
		Rectangle r30 = new Rectangle(p3, 30, 30);
		Rectangle[] rectangles = { r30, r10, r20 };
		System.out.println("\nNesortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
		// u pozadini sortira po compareTo
		Arrays.sort(rectangles);
		System.out.println("Sortiran niz: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
		Point point5=new Point(1,2);
		System.out.println(point5.contains(1, 2));
		Donut prvi=new Donut(point5,9,3);
		Donut drugi=new Donut(point5,4,3);
		System.out.println(prvi.compareTo(drugi));
		
	}

}
