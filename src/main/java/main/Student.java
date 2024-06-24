package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private String name;
    private String studentId;
    private ArrayList<Grade> grades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void addGrade(String course, int grade) {
        grades.add(new Grade(course, grade));
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }
}
