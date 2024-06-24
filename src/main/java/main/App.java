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
        university.listStudents();
        System.out.println("Mille opiskelijalle suorite lisätään?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        System.out.println("Mille kurssille suorite lisätään?");
        String course = scanner.nextLine();
        System.out.println("Mikä arvosana kurssille lisätään?");
        int grade = Integer.parseInt(scanner.nextLine());
        university.getStudent(studentIndex).addGrade(course, grade);
    }

    private static void listStudentGrades() {
        university.listStudents();
        System.out.println("Minkä opiskelijan suoritteet listataan?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        university.getStudent(studentIndex).listGrades();
    }

    private static void calculateAverage() {
        university.listStudents();
        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        double average = Calculator.getAverageGrade(university.getStudent(studentIndex));
        System.out.println("Keskiarvo on " + average);
    }

    private static void calculateMedian() {
        university.listStudents();
        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        double median = Calculator.getMedianGrade(university.getStudent(studentIndex));
        System.out.println("Mediaani on " + median);
    }

    private static void saveStudents() {
        university.saveToFile("students.dat");
    }

    private static void loadStudents() {
        university.loadFromFile("students.dat");
    }
}
