package zadatak1;

public class Book {
	private String name;
	private String author;
	private int numberOfPages;
	private double price;

	public Book() {
	}

	public Book(String name, String author, int numberOfPages) {
		this.name = name;
		this.author = author;
		this.numberOfPages = numberOfPages;
	}

	public Book(String name, String author, double price, int numberOfPages) {
		this(name, author, numberOfPages);
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		if (numberOfPages > 0) {
			this.numberOfPages = numberOfPages;
		} else
			System.out.println("Broj stranica ne moze biti negativan broj");
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price > 0) {
			this.price = price;
		} else
			System.out.println("Cena ne moze biti negativan broj");
	}

	private double calculateDiscount(int procenat) {
		return ((double) procenat / 100) * this.price;
	}

	public double calculateDiscountPrice(int procenat) {
		return this.price - calculateDiscount(procenat);
	}

}
