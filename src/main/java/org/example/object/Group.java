package org.example.object;

import java.util.ArrayList;
import java.util.List;


public class Group {
    private final String name;
    private final int creationYear;
    private final List<Student> students = new ArrayList<>();


    public Group(String name, int creationYear) {
        this.name = name;
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public Group addStudent(Student student) {
        students.add(student);
        return this;
    }

    public Group removeStudent(Student student) {
        students.remove(student);
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }
}