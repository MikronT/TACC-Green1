package org.example.object;

import java.time.LocalDate;


public class Grade {
    private final Subject subject;
    private final LocalDate date;
    private int grade;
    private boolean isExam = false;
    private boolean isExamPassed = false;


    public Grade(Subject subject, LocalDate date, int grade) {
        this.subject = subject;
        this.date = date;
        this.grade = grade;
    }

    public Grade(Subject subject, LocalDate date, int grade, boolean isExamPassed) {
        this(subject, date, grade);
        isExam = true;
        this.isExamPassed = isExamPassed;
    }


    public Subject getSubject() {
        return subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getGrade() {
        return grade;
    }

    public boolean isExam() {
        return isExam;
    }

    public boolean isExamPassed() {
        return isExamPassed;
    }
}