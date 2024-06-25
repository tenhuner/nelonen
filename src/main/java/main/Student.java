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
        grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void addGrade(String course, int grade) {
        grades.add(new Grade(course, grade));
    }

    public void listGrades() {
        for (Grade grade : grades) {
            System.out.println(grade.getCourse() + ": " + grade.getGrade());
        }
    }
}
