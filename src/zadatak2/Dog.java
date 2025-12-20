package zadatak2;

public class Dog extends Animal{
	private boolean hungry;

	public boolean isHungry() {
		return hungry;
	}

	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	public Dog() {
	}

	public Dog(String name, String breed, boolean hungry) {
		super(name, breed);
		this.hungry = hungry;
	}

	public void respond() {
		System.out.println("woof woof");
	}

	public void namePet(String name) {
		setName(name);
	}

	public void feed() {
		if (hungry == true) {
			hungry = false;
			System.out.println(getName() + "is full and happy");
		} else {
			System.out.println(getName() + "buries food for rainy days”");
		}
	}

	public static int calculateHumanYears(int dogYears) {
		return dogYears * 15;
	}

	public String toString() {
		return "name:" + getName() + ", race:	" + getBreed() + ", hungry:" + isHungry();

	}
}
