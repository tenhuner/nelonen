package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator {

    public double getAverageGrade(Student s) {
        ArrayList<Grade> grades = s.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }

        return sum / grades.size();
    }

    public double getMedianGrade(Student s) {
        ArrayList<Grade> grades = s.getGrades();
        if (grades.isEmpty()) {
            return 0.0;
        }

        ArrayList<Integer> gradeValues = new ArrayList<>();
        for (Grade grade : grades) {
            gradeValues.add(grade.getGrade());
        }

        Collections.sort(gradeValues);

        int size = gradeValues.size();
        if (size % 2 == 1) {
            return gradeValues.get(size / 2);
        } else {
            return (gradeValues.get(size / 2 - 1) + gradeValues.get(size / 2)) / 2.0;
        }
    }
}
