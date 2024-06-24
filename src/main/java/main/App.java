package main;

import java.util.Scanner;

public class App {
    private static University university = new University();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choice;
        do {
            printMenu();
            choice = scanner.nextLine();
            handleChoice(choice);
        } while (!choice.equals("0"));
    }

    private static void printMenu() {
        System.out.println("1) Lisää opiskelija");
        System.out.println("2) Listaa opiskelijat");
        System.out.println("3) Lisää opiskelijalle suorite");
        System.out.println("4) Listaa opiskelijan suoritteet");
        System.out.println("5) Laske opiskelijan suoritusten keskiarvo");
        System.out.println("6) Laske opiskelijan suoritusten mediaani");
        System.out.println("7) Tallenna opiskelijat tiedostoon");
        System.out.println("8) Lataa opiskelijat tiedostosta");
        System.out.println("0) Lopeta ohjelma");
    }

    private static void handleChoice(String choice) {
        switch (choice) {
            case "1":
                addStudent();
                break;
            case "2":
                listStudents();
                break;
            case "3":
                addGradeToStudent();
                break;
            case "4":
                listStudentGrades();
                break;
            case "5":
                calculateAverage();
                break;
            case "6":
                calculateMedian();
                break;
            case "7":
                saveStudents();
                break;
            case "8":
                loadStudents();
                break;
            case "0":
                System.out.println("Kiitos ohjelman käytöstä.");
                break;
            default:
                System.out.println("Virheellinen valinta.");
        }
    }

    private static void addStudent() {
        System.out.println("Anna opiskelijan nimi?");
        String name = scanner.nextLine();
        System.out.println("Anna opiskelijan opiskelijanumero:");
        String studentNumber = scanner.nextLine();
        university.addStudent(new Student(name, studentNumber));
    }

    private static void listStudents() {
        university.listStudents();
    }

    private static void addGradeToStudent() {
        listStudents();
        System.out.println("Anna opiskelijan opiskelijanumero, jolle suorite lisätään:");
        String studentNumber = scanner.nextLine();
        Student student = university.getStudent(studentNumber);
        if (student != null) {
            System.out.println("Mille kurssille suorite lisätään?");
            String course = scanner.nextLine();
            System.out.println("Mikä arvosana kurssille lisätään?");
            int grade = Integer.parseInt(scanner.nextLine());
            student.addGrade(course, grade);
        } else {
            System.out.println("Opiskelijaa ei löytynyt.");
        }
    }

    private static void listStudentGrades() {
        listStudents();
        System.out.println("Anna opiskelijan opiskelijanumero, jonka suoritteet listataan:");
        String studentNumber = scanner.nextLine();
        Student student = university.getStudent(studentNumber);
        if (student != null) {
            student.listGrades();
        } else {
            System.out.println("Opiskelijaa ei löytynyt.");
        }
    }

    private static void calculateAverage() {
        listStudents();
        System.out.println("Anna opiskelijan opiskelijanumero, jonka suoritusten keskiarvo lasketaan:");
        String studentNumber = scanner.nextLine();
        Student student = university.getStudent(studentNumber);
        if (student != null) {
            double average = Calculator.getAverageGrade(student);
            System.out.println("Keskiarvo on " + average);
        } else {
            System.out.println("Opiskelijaa ei löytynyt.");
        }
    }

    private static void calculateMedian() {
        listStudents();
        System.out.println("Anna opiskelijan opiskelijanumero, jonka suoritusten mediaani lasketaan:");
        String studentNumber = scanner.nextLine();
        Student student = university.getStudent(studentNumber);
        if (student != null) {
            double median = Calculator.getMedianGrade(student);
            System.out.println("Mediaani on " + median);
        } else {
            System.out.println("Opiskelijaa ei löytynyt.");
        }
    }

    private static void saveStudents() {
        university.saveToFile("students.dat");
    }

    private static void loadStudents() {
        university.loadFromFile("students.dat");
    }
}