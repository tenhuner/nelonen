package main;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static double getAverageGrade(Student s) {
        List<Grade> grades = s.getGrades();
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }
        return sum / grades.size();
    }

    public static double getMedianGrade(Student s) {
        List<Grade> grades = s.getGrades();
        if (grades.isEmpty()) {
            return 0;
        }
        // Kopioidaan lista, jotta alkuperäinen lista ei muutu
        List<Grade> sortedGrades = new ArrayList<>(grades);
        sortedGrades.sort((g1, g2) -> Integer.compare(g1.getGrade(), g2.getGrade()));
        
        int size = sortedGrades.size();
        if (size % 2 == 1) {
            return sortedGrades.get(size / 2).getGrade();
        } else {
            return (sortedGrades.get(size / 2 - 1).getGrade() + sortedGrades.get(size / 2).getGrade()) / 2.0;
        }
    }
}


