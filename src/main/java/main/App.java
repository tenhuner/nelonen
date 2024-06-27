package main; //Name of package

import java.util.Scanner; // Import the Scanner class for user input

public class App { // The main class of the application
    public static void main(String[] args) { //Main method
        EventLogger eventLogger = new EventLogger(); // Creates method to log 
        eventLogger.writeLog("Ohjelma käynnistyi"); //Logs start of the program 

        Scanner sc = new Scanner(System.in); // Create a Scanner object for reading user input from the console

        University university = new University(); // Create a University object to manage students
        Calculator calculator = new Calculator();  // Create a Calculator object for calculating deliveries

        boolean exit = false; // Boolean variable that tells whether the program should be terminated
        while (!exit) { // A loop that continues until the user decides to stop
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if (sc.hasNext()) { // Check if user input exists
                int i = 0; // Initialize a variable to store the selection
                String stringInput = sc.nextLine(); // Read user input as a string
                try { 
                    i = Integer.parseInt(stringInput); // Try to convert a string input to an integer

                    switch (i) {
                        case 1:
                            System.out.println("Anna opiskelijan nimi?");
                            String name = sc.nextLine();
                            System.out.println("Anna opiskelijan opiskelijanumero:");
                            String studentId = sc.nextLine();

                            Student student = new Student(name, studentId);
                            university.addStudent(student);
                            eventLogger.writeLog(student.getName() + " lisätty");
                            break;
                        case 2:
                            System.out.println("Opiskelijat:");
                            university.listStudentsById();
                            break;
                        case 3:
                            university.listStudentsByIndex();
                            System.out.println("Mille opiskelijalle suorite lisätään?");
                            int studentIndex = Integer.parseInt(sc.nextLine());
                            Student selectedStudent = university.getStudentByIndex(studentIndex);
                            if (selectedStudent == null) {
                                System.out.println("Opiskelijaa ei löytynyt.");
                                break;
                            }

                            System.out.println("Mille kurssille suorite lisätään?");
                            String course = sc.nextLine();
                            System.out.println("Mikä arvosana kurssille lisätään?");
                            int gradeValue = Integer.parseInt(sc.nextLine());

                            selectedStudent.addGrade(course, gradeValue);
                            eventLogger.writeLog("Suorite lisätty: " + selectedStudent.getName() + " - " + course + ": " + gradeValue);
                            break;
                        case 4:
                            university.listStudentsByIndex();
                            System.out.println("Minkä opiskelijan suoritteet listataan?");
                            studentIndex = Integer.parseInt(sc.nextLine());
                            selectedStudent = university.getStudentByIndex(studentIndex);
                            if (selectedStudent == null) {
                                System.out.println("Opiskelijaa ei löytynyt.");
                                break;
                            }
                            selectedStudent.listGrades();
                            break;
                        case 5:
                            university.listStudentsByIndex();
                            System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                            studentIndex = Integer.parseInt(sc.nextLine());
                            selectedStudent = university.getStudentByIndex(studentIndex);
                            if (selectedStudent == null) {
                                System.out.println("Opiskelijaa ei löytynyt.");
                                break;
                            }
                            double average = calculator.getAverageGrade(selectedStudent);
                            System.out.println("Keskiarvo on " + average);
                            break;
                        case 6:
                            university.listStudentsByIndex();
                            System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                            studentIndex = Integer.parseInt(sc.nextLine());
                            selectedStudent = university.getStudentByIndex(studentIndex);
                            if (selectedStudent == null) {
                                System.out.println("Opiskelijaa ei löytynyt.");
                                break;
                            }
                            double median = calculator.getMedianGrade(selectedStudent);
                            System.out.println("Mediaani on " + median);
                            break;
                        case 7:
                            university.saveStudents();
                            eventLogger.writeLog("Opiskelijat tallennettu tiedostoon");
                            break;
                        case 8:
                            university.loadStudents();
                            eventLogger.writeLog("Opiskelijat ladattu tiedostosta");
                            break;
                        case 0:
                            System.out.println("Kiitos ohjelman käytöstä.");
                            exit = true;
                            break;
                        default:
                            System.out.println("Syöte oli väärä");
                            break;
                    }
                } catch (NumberFormatException e) {  // Handle the case where the input is not a valid integer
                    System.out.println("Syöte oli väärä");
                }
            }
        }
        sc.close(); // Close the scanner
        eventLogger.writeLog("Ohjelma lopetettu"); // Log the end of the program
    }
}
