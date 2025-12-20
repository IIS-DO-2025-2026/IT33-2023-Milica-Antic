package schoolWork;

public class WorkingDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student(15, "Bojana", 4);
		Teacher teacher1 = new Teacher(30, "Milos", 20000);
		System.out.println(student1.toString());
		System.out.println(teacher1.toString());
		teacher1.setSubject("matematika");
		student1.setClassTeacher(teacher1);
		System.out.println(teacher1.assignSubject());
		teacher1.setSubject("history");
		System.out.println(student1.getClassTeacher().assignSubject());
		System.out.println(student1.evaluateTheStudent(5));
		System.out.println(student1.evaluateTheStudent(5, "grade need to improv"));
	}

}
