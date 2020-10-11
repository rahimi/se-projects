package classes;

import java.util.List;

public class Student {
	public String majorSubject;
    public String minorSubject;
    public List<Course> courseList;

    public void joinCourse(Course c) {}

    public void dropCourse(Course c) {}

    public Student(String majorSubject, String minorSubject){
        this.majorSubject = majorSubject;
        this.minorSubject = minorSubject;
    }

}
