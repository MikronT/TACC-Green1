package org.example.object;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private final String firstName, lastName;
    private final List<Subject> subjects = new ArrayList<>();
    private final List<Grade> grades = new ArrayList<>();


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student addSubject(Subject subject) {
        subjects.add(subject);
        return this;
    }

    public Student removeSubject(Subject subject) {
        subjects.remove(subject);
        return this;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Student addGrade(Grade grade) {
        grades.add(grade);
        return this;
    }

    public Student removeGrade(Grade grade) {
        grades.remove(grade);
        return this;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public List<Grade> getGrades(Subject forSubject) {
        return grades.stream()
                .filter(grade -> grade.getSubject().equals(forSubject))
                .sorted((o1, o2) -> o2.getGrade() - o1.getGrade())
                .toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!getSubjects().equals(student.getSubjects())) return false;
        return getGrades().equals(student.getGrades());
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + getSubjects().hashCode();
        result = 31 * result + getGrades().hashCode();
        return result;
    }
}