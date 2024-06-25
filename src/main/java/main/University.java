package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class University {
    private ArrayList<Student> students;
    private final String FILENAME = "students.data";

    public University() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void listStudents() {
        int i = 0;
        for (Student student : students) {
            System.out.println(i++ + ": " + student.getName() + " (" + student.getStudentId() + ")");
        }
    }

    public void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(students);
            System.out.println("Opiskelijat tallennettu tiedostoon.");
        } catch (IOException e) {
            System.out.println("Virhe tallennettaessa opiskelijoita tiedostoon.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            students = (ArrayList<Student>) ois.readObject();
            System.out.println("Opiskelijat ladattu tiedostosta.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Virhe ladattaessa opiskelijoita tiedostosta.");
            e.printStackTrace();
        }
    }
}
