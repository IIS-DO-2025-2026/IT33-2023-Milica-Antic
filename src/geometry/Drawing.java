package geometry;

import java.awt.Color; // dozvoljava boje da se koriste
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame; //za kreiranje prozora 
import javax.swing.JPanel; // ya kreiranje panela umutar proyora

public class Drawing extends JPanel {

private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800, 600); //velicina prozora 
		frame.setTitle("Test app"); //naslov prozora
		
		JPanel drawing = new Drawing(); // objekat koji predstavlja crtez i dodaje ga nasadrzaj prozora
		frame.getContentPane().add(drawing); //Dodaje crtež na sadržaj prozora.
		frame.setVisible(true);//Postavlja prozor na vidljiv
	}

	
	public Drawing() { //konstruktor

	}
	
	public void paint(Graphics g) { //metoda za crtanje na panelu u javi
		
		Point p81 = new Point(150,200);  //pravi novi objekat klase point
		Rectangle r81 = new Rectangle(p81, 100, 120);
		Circle c81 = new Circle(p81, 50);
		
		p81.draw(g);  //u klasi point ima metoda draw pa je crta
		g.setColor(Color.red);// menja bolju u crveni
		r81.draw(g);
		//c81.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>(); //lista shapes
		shapes.add(p81);
		shapes.add(r81);
		shapes.add(c81);//dodaje elemente u listu
		Iterator<Shape> itShape = shapes.iterator(); //pomocu njega pristupamo elementima liste
		//pomeriti elemente za 20pixela po x osi
		//i iscrtati elemente zutom bojom
		g.setColor(Color.yellow);
		while(itShape.hasNext()) {
			/*itShape.next().moveBy(20, 0);
			itShape.next().draw(g);*/
			Shape tempShape = itShape.next(); //temp-trenutni
			tempShape.moveBy(20, 0);
			tempShape.draw(g);			
		}
		
		//obrada izuzetaka
		try { //pocetak bloka koji testira na greske
			c81.setRadius(-50); //Pokušava postaviti negativni radijus krugu c81, što će izazvati izuzetak.
			System.out.println("The rest of the try block...");
		} catch (Exception e) { //Blok koda koji se izvršava u slučaju izuzetka.
			System.out.println(e.getMessage());
			//e.printStackTrace();
		} finally {
			System.out.println("I always perform");
		}
		System.out.println("Will I be executed?");
		
		
		//selektovanje
		Point p82 = new Point(400,400, true);
		p82.draw(g);
		/*Point p83 = new Point(400,600, true);
		p82.draw(g);
		Line l82=new Line(p82,p83,true);
		l82.draw(g);*/
	}

}
