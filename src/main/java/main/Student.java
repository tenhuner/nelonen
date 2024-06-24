package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private String name;
    private String studentNumber;
    private List<Grade> grades;

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void addGrade(String course, int grade) {
        grades.add(new Grade(course, grade));
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void listGrades() {
        for (Grade grade : grades) {
            System.out.println(grade.getCourse() + ": " + grade.getGrade());
        }
    }
}

