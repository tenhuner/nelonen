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

    public Student getStudentByIndex(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        }
        return null;
    }

    public void listStudentsById() {
        for (Student student : students) {
            System.out.println(student.getStudentId() + ": " + student.getName());
        }
    }

    public void listStudentsByIndex() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(i + ": " + student.getName());
        }
    }

    public void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Virhe tallennettaessa opiskelijoita tiedostoon.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStudents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Virhe ladattaessa opiskelijoita tiedostosta.");
            e.printStackTrace();
        }
    }
}
