package schoolWork;

public class Student extends SchoolMember {
	private int avgGrade;
	private Teacher classTeacher;

	public Student() {
	}

	public Student(int age, String name, int avgGrade) {
		super(age, name);
		this.avgGrade = avgGrade;
	}

	public String evaluateTheStudent(int grade) {
		this.avgGrade = grade;
		return classTeacher.assignSubject() + "and student " + this.name + " get :" + this.avgGrade;

	}

	public String evaluateTheStudent(int grade, String note) {
		this.avgGrade = grade;

		return evaluateTheStudent(this.avgGrade) + note;
	}

	/*
	 * moguce je da imamo dve metode sa istim nazivom ako je broj ili redosled
	 * njihovih parametara razlicit) taj koncept naziva se overloading
	 */

	public int getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(int avgGrade) {
		this.avgGrade = avgGrade;
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public String toString() {
		return super.toString() + ",grade:" + this.avgGrade;
	}

}
