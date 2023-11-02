package org.example;
import java.util.List;

public class Group {
    private String groupNumber;
    private int creationYear;
    private List<Student> students;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}
