package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vova", 1));
        students.add(new Student("Bogdan", 2));
        students.add(new Student("Maria", 1));
        students.add(new Student("Dasha", 3));
        students.add(new Student("Anna", 2));

        System.out.println("List of students ordered by name:");
        students.sort(Student.compareByName());
        Collections.sort(students, Student.compareByName());
        for (Student student : students) {
            System.out.println(student.getName() + " (Course " + student.getCourse() + ")");
        }

        System.out.println("\nList of students ordered by course:");
        students.sort(Student.compareByCourse());
        Collections.sort(students, Student.compareByCourse());
        for (Student student : students) {
            System.out.println(student.getName() + " (Course " + student.getCourse() + ")");
        }

        Student.printStudents(students, 2);
    }
}
