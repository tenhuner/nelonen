package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable { // Student class that describes a student and implements the Serializable interface
    private String name;
    private String studentId;
    private ArrayList<Grade> grades;

    public Student(String name, String studentId) { // Constructor method that initializes the student's name, student number and grade list
        this.name = name;
        this.studentId = studentId;
        grades = new ArrayList<>(); // Create a new empty ArrayList for the grades variable
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Grade> getGrades() { // Getter method for retrieving the grade list
        return grades;
    }

    public void addGrade(String course, int grade) { // Method to add a grade to the grade list
        grades.add(new Grade(course, grade)); // Add a new Grade object to the grade list
    }

    public void listGrades() { // Method to list grades
        for (Grade grade : grades) { // Go through each grade in the grade list
            System.out.println(grade.getCourse() + ": " + grade.getGrade()); // Print the course name and grade
        }
    }
}
