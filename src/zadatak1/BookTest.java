package zadatak1;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book bookOne = new Book();
		Book bookTwo = new Book("Dan Brown", "Digital Fortress", 900.00, 445);
		bookOne.setName("Inferno");
		bookOne.setAuthor("Dan Brown");
		bookOne.setNumberOfPages(445);
		bookOne.setPrice(950.00);
		System.out.println(
				"cena knjige " + bookOne.getName() + " sa popustom od 15% je" + bookOne.calculateDiscountPrice(15));
		if (bookOne.calculateDiscountPrice(15) < bookTwo.calculateDiscountPrice(20)) {
			System.out.println(bookOne.getName());
		} else {
			System.out.println(bookTwo.getName());
		}
	}

}
