package org.example;

import org.example.object.Group;
import org.example.object.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class GroupTest {
    @Test
    public void addStudent() {
        Student student1 = new Student("Zig", "Nelson");
        Student student2 = new Student("Tera", "Kolvas");
        Student student3 = new Student("Opal", "Urandoniv");
        Student student4 = new Student("Henry", "Pachovski");
        Student student5 = new Student("Mira", "Ryanden");

        Group group = new Group("ITY-21-3", 2020)
                .addStudent(student1)
                .addStudent(student2)
                .addStudent(student3)
                .addStudent(student4)
                .addStudent(student5);

        Assertions.assertEquals(
                group.getStudents(),
                List.of(student1, student2, student3, student4, student5));
    }

    @Test
    public void removeStudent() {

        Student student1 = new Student("Zig", "Nelson");
        Student student2 = new Student("Tera", "Kolvas");
        Student student3 = new Student("Opal", "Urandoniv");
        Student student4 = new Student("Henry", "Pachovski");
        Student student5 = new Student("Mira", "Ryanden");

        Group group = new Group("ITY-21-3", 2020)
                .addStudent(student1)
                .addStudent(student2)
                .addStudent(student3)
                .addStudent(student4)
                .addStudent(student5);

        group.removeStudent(student3);

        Assertions.assertEquals(
                group.getStudents(),
                List.of(student1, student2, student4, student5));
    }
}
