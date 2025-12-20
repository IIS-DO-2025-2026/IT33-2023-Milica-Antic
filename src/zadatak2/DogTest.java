package zadatak2;

public class DogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog1 = new Dog("Bethoven", "St. Bernard", false);
		Dog dog2 = new Dog("Boby", "Badger dog", true);
		dog2.feed();
		System.out.println(dog1.toString());
		System.out.println(dog2.toString());
		int r = Dog.calculateHumanYears(3);
		System.out.println("broj godina je" + r);
		System.out.println();
		System.out.println();
	}

}
