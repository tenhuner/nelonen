package main;

import java.io.Serializable; // Import the Serializable interface so that objects of the class can be saved and read from a file

public class Grade implements Serializable { // Grade class that describes the course performance and implements the Serializable interface
    private String course;
    private int grade;

    public Grade(String course, int grade) {
        this.course = course; //Initialize the variable
        this.grade = grade;//Initialize the variable
    }

    public String getCourse() { // Getter method for retrieving the course name
        return course;
    }

    public int getGrade() {
        return grade;
    }
}
