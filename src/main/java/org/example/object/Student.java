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
                .toList();
    }
}