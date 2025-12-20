package schoolWork;

public class Teacher extends SchoolMember {
	private int salary;
	private String subject;

	public Teacher() {
	}

	public Teacher(int age, String name, int salary) {
		super(age, name);
		this.salary = salary;
	}

	public Teacher(int age, String name, int salary, String subject) {
		this(age, name,salary);
		this.subject = subject;
	}

	public String assignSubject() {
		return "Subject " + this.subject + " was assigned to the teacher :" + this.getName();

	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String toString() {
		return super.toString() + ",salary:" + this.salary;
	}
}
