package patterns;

import java.util.ArrayList;
import java.util.Optional;

public class MediatorPattern {

	public static void main(String[] args) {
		HSBAMediator gradeOffice = new GradeOffice();
		HSBALecturer mo = new HSBALecturer("Mo", gradeOffice);
		HSBAStudent robert = new HSBAStudent("Robert","1234",gradeOffice);
		mo.gradeStudentForCourse("10","1234","SE");
	}
}

interface HSBAMediator{
	void setGrade(String grade, String student, String course);
	void registerStudent(HSBAStudent student);
	void registerLecturer(HSBALecturer lecturer);
}

class GradeOffice implements HSBAMediator{
	ArrayList<HSBAStudent> students = new ArrayList<HSBAStudent>();
	ArrayList<HSBALecturer> lecturers = new ArrayList<HSBALecturer>();

	@Override
	public void setGrade(String grade, String studentID, String course) {
		Optional<HSBAStudent> promise = students.stream().filter((s)->s.id==studentID).findFirst();
		if (promise.isPresent()){
			HSBAStudent student = promise.get();
			student.receiveGradeForCourse(grade, course);
		}else {
			System.out.println("Hmmm... No student with "+studentID);
		}

	}

	@Override
	public void registerStudent(HSBAStudent student) {
		students.add(student);
	}

	@Override
	public void registerLecturer(HSBALecturer lecturer) {
		lecturers.add(lecturer);
	}
	
}

abstract class HSBARegisteredPerson{
	HSBAMediator office;
	String name;
	public HSBARegisteredPerson(String name, HSBAMediator office) {
		this.office = office;
		this.name = name;
	}
}

class HSBALecturer extends HSBARegisteredPerson{
	public HSBALecturer(String name, HSBAMediator office){
		super(name, office);
		office.registerLecturer(this);
	}
	void gradeStudentForCourse(String grade, String studentID, String course) {
		this.office.setGrade(grade,studentID,course);
	}
}

class HSBAStudent extends HSBARegisteredPerson{
	String id;
	public HSBAStudent(String name, String studentID, HSBAMediator office){
		super(name, office);
		id = studentID;
		office.registerStudent(this);
	}
	void receiveGradeForCourse(String grade, String course) {
		System.out.println(name+" received "+grade+" for "+course);
	}
}