package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student implements Comparable<Student> {
    private String name;
    private int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public static void printStudents(List<Student> students, int targetCourse) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getCourse() == targetCourse) {
                System.out.println(student.getName());
            }
        }
    }

    @Override
    public int compareTo(Student otherStudent) {
        return this.name.compareTo(otherStudent.name);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vova", 1));
        students.add(new Student("Bogdan", 2));
        students.add(new Student("Maria", 1));
        students.add(new Student("Dasha", 3));
        students.add(new Student("Anna", 2));

        System.out.println("Students ordered by name:");
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.getName() + " - Course: " + student.getCourse());
        }

        System.out.println("\nStudents ordered by course:");
        students.sort((s1, s2) -> Integer.compare(s1.getCourse(), s2.getCourse()));
        for (Student student : students) {
            System.out.println(student.getName() + " - Course: " + student.getCourse());
        }

        int targetCourse = 2;
        System.out.println("\nStudents in course " + targetCourse + ":");
        Student.printStudents(students, targetCourse);
    }
}
