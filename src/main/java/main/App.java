package main;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static University university = new University();
    private static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    listStudents();
                    break;
                case 3:
                    addGrade();
                    break;
                case 4:
                    listGrades();
                    break;
                case 5:
                    calculateAverage();
                    break;
                case 6:
                    calculateMedian();
                    break;
                case 7:
                    saveToFile();
                    break;
                case 8:
                    loadFromFile();
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    return;
                default:
                    System.out.println("Syöte oli väärä.");
            }
        }
    }

    private static void addStudent() {
        System.out.println("Anna opiskelijan nimi?");
        String name = scanner.nextLine();
        System.out.println("Anna opiskelijan opiskelijanumero:");
        String studentId = scanner.nextLine();
        university.addStudent(new Student(name, studentId));
    }

    private static void listStudents() {
        System.out.println("Opiskelijat:");
        for (Student student : university.getStudents()) {
            System.out.println(student.getStudentId() + ": " + student.getName());
        }
    }

    private static void addGrade() {
        listStudents();
        System.out.println("Mille opiskelijalle suorite lisätään?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        Student student = university.getStudents().get(studentIndex);
        System.out.println("Mille kurssille suorite lisätään?");
        String course = scanner.nextLine();
        System.out.println("Mikä arvosana kurssille lisätään?");
        int grade = Integer.parseInt(scanner.nextLine());
        student.addGrade(course, grade);
    }

    private static void listGrades() {
        listStudents();
        System.out.println("Minkä opiskelijan suoritteet listataan?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        Student student = university.getStudents().get(studentIndex);
        for (Grade grade : student.getGrades()) {
            System.out.println(grade.getCourse() + ": " + grade.getGrade());
        }
    }

    private static void calculateAverage() {
        listStudents();
        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        Student student = university.getStudents().get(studentIndex);
        double average = calculator.getAverageGrade(student);
        System.out.println("Keskiarvo on " + average);
    }

    private static void calculateMedian() {
        listStudents();
        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
        int studentIndex = Integer.parseInt(scanner.nextLine());
        Student student = university.getStudents().get(studentIndex);
        double median = calculator.getMedianGrade(student);
        System.out.println("Mediaani on " + median);
    }

    private static void saveToFile() {
        university.saveToFile("students.dat");
    }

    private static void loadFromFile() {
        university.loadFromFile("students.dat");
    }
}
