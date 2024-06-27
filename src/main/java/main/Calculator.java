package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator {  // Calculator class that contains methods for calculating mean and median

    public double getAverageGrade(Student s) {  // Method that calculates the average of the student's grades
        ArrayList<Grade> grades = s.getGrades(); // Gets the grades of the student from array list 
        if (grades.isEmpty()) { // If the grade list is empty, 0.0 is returned
            return 0.0;
        }

        double sum = 0.0; // Initialize the variable sum to calculate the sum of the grades
        for (Grade grade : grades) { // Go through each grade in the list
            sum += grade.getGrade(); // Adding a grade to the sum
        }

        return sum / grades.size(); // Returns the average of the grades
    }

    public double getMedianGrade(Student s) { // Method to calculate the median of the student's grades
        ArrayList<Grade> grades = s.getGrades(); // Get the student's grades
        if (grades.isEmpty()) { // If the grade list is empty, 0.0 is returned
            return 0.0;
        }

        ArrayList<Integer> gradeValues = new ArrayList<>(); // Create a new list containing only grade values
        for (Grade grade : grades) { // Go through each grade in the list
            gradeValues.add(grade.getGrade()); // Add the grade value to the gradeValues ​​list
        }

        Collections.sort(gradeValues); // Sort the grade values ​​in ascending order

        int size = gradeValues.size(); // Count the number of grades
        if (size % 2 == 1) { // If the number of grades is odd
            return gradeValues.get(size / 2); // Return the middle grade
        } else {
            return (gradeValues.get(size / 2 - 1) + gradeValues.get(size / 2)) / 2.0; // If the number of grades is even, the average of the two middle grades is returned
        }
    }
}
