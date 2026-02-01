package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// inicijalicuje property klase Ponit na podrazumevano
		// prvaTacka je 0 0 false
		Point firstPoint = new Point();
		Point secondPoint = new Point();
		System.out.println(firstPoint.getX());
		firstPoint.setX(50);
		System.out.println(firstPoint.getX());
		System.out.println(secondPoint.getX());
		secondPoint.setX(60);
		System.out.println(secondPoint.getX());

		// metoda instance
		// objekat klase point jer je distance ponasanje tacke

		System.out.println(firstPoint.distance(secondPoint));
		Point thirdPoint = new Point();
		Point fourthPoint = new Point();
		Line firstLine = new Line();
		thirdPoint.setX(20);
		thirdPoint.setY(20);
		fourthPoint.setX(30);
		fourthPoint.setY(30);
		thirdPoint.setX(fourthPoint.getY());

		// System.out.println(line1.getStartPoint().getX());
		firstLine.setStartPoint(thirdPoint);
		firstLine.setEndPoint(fourthPoint);
		System.out.println(firstLine.getStartPoint().getX());
		System.out.println(firstLine.getStartPoint().getY());
		System.out.println(firstLine.getEndPoint().getX());
		System.out.println(firstLine.getEndPoint().getY());

		firstLine.getEndPoint().setY(23);
		System.out.println(firstLine.getEndPoint().getY());
		System.out.println(fourthPoint.getY());
		firstLine.getStartPoint().setX(firstLine.getEndPoint().getY());

		firstLine.getEndPoint().setX((int) firstLine.lenght() - firstLine.getStartPoint().getX() - firstLine.getStartPoint().getY());
		Rectangle firstRectangle = new Rectangle();

		firstRectangle.setUpperLeftPoint(fourthPoint);

		firstRectangle.getUpperLeftPoint().setX(10);
		firstRectangle.getUpperLeftPoint().setY(15);
		// konstrultori
		Point fifthPoint = new Point(2, 3);
		Point sixthPoint = new Point(4, 5);
		System.out.println(fifthPoint.toString());
		Line secondLine = new Line(fifthPoint, sixthPoint);
		// moze sa i bez toString()
		System.out.println(secondLine.toString());
		System.out.println(secondLine);

		int a = 4;
		int b = 4;
		Point seventhPoint = new Point(2, 3);
		Point eighthPoint = new Point(2, 3);
		System.out.println(a == b);
		// kod slozenih tipova == poredi referencu a ne vednosti x i y
		System.out.println(seventhPoint == eighthPoint);
		// za poredjenje koordinata se koristi equals, ona je u klasi Object,ona je
		// metoda instance
		System.out.println(seventhPoint.equals(eighthPoint));
		// System.out.println(novaTacka.equals(secondLine));

		Donut firstDonut = new Donut(seventhPoint, 50, 45);

		firstDonut.setRadius(60);
		System.out.println(firstDonut);

		Circle secondDonut = new Donut(50);
		System.out.println(secondDonut);
		((Donut) secondDonut).setInnerRadius(60);

		// Shape shape1=new Shape(); ->nije moguce jer je apstraktna klasa
		Shape firstShape = new Point(50, 60); // isto je kao Point shape1=new Point(50,60);
		System.out.println(firstShape.isSelected());
		System.out.println(((Point) firstShape).getX());
		Point p3 = new Point(50, 50);
		Rectangle secondRectangle = new Rectangle(p3, 10, 10);
		Rectangle thirdRectangle = new Rectangle(p3, 20, 20);
		Rectangle fourthRectangle = new Rectangle(p3, 30, 30);
		Rectangle[] rectangles = { fourthRectangle, secondRectangle, thirdRectangle };
		System.out.println("\nUnsorted array: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
		// u pozadini sortira po compareTo
		Arrays.sort(rectangles);
		System.out.println("Sorted array: ");
		for (int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
		Point ninthPoint=new Point(1,2);
		System.out.println(ninthPoint.contains(1, 2));
		Donut thirdDonut=new Donut(ninthPoint,9,3);
		Donut fourthDonut=new Donut(ninthPoint,4,3);
		System.out.println(thirdDonut.compareTo(fourthDonut));
		
	}

}
