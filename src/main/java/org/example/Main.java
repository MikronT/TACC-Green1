package org.example;

import java.util.*;

class Student  {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(int course) {
        this.course = course;
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

    public static Comparator<Student> compareByName() {
        return Comparator.comparing(Student::getName);
    }

    public static Comparator<Student> compareByCourse() {
        return Comparator.comparing(Student::getCourse);
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

        System.out.println("List of students ordered by name:");
        Collections.sort(students, Student.compareByName());
        for (Student student : students) {
            System.out.println(student.getName() + " (Course " + student.getCourse() + ")");
        }

        System.out.println("\nList of students ordered by course:");
        Collections.sort(students, Student.compareByCourse());
        for (Student student : students) {
            System.out.println(student.getName() + " (Course " + student.getCourse() + ")");
        }

        Student.printStudents(students, 2);
    }
}
