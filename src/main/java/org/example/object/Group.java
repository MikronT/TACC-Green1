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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (getCreationYear() != group.getCreationYear()) return false;
        if (!getName().equals(group.getName())) return false;
        return getStudents().equals(group.getStudents());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCreationYear();
        result = 31 * result + getStudents().hashCode();
        return result;
    }
}