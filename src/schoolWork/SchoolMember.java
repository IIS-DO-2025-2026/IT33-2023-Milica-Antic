package schoolWork;

public class SchoolMember {
	protected int age;
	protected String name;

	public SchoolMember() {
	}

	public SchoolMember(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Person:" + this.name + ",age:" + this.age;
	}

}
