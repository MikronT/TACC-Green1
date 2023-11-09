package org.example.object;

import java.time.LocalDate;


public class Grade {
    private final Subject subject;
    private final LocalDate date;
    private int grade;
    private boolean isExam = false;
    private boolean isExamPassed = false;


    public Grade(Subject subject, int grade) {
        this(subject, LocalDate.now(), grade);
    }

    public Grade(Subject subject, LocalDate date, int grade) {
        this.subject = subject;
        this.date = date;
        this.grade = grade;
    }

    public Grade(Subject subject, LocalDate date, int grade, boolean isExamPassed) {
        this(subject, date, grade);
        this.isExam = true;
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

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isExam() {
        return isExam;
    }

    public boolean isExamPassed() {
        return isExamPassed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade1 = (Grade) o;

        if (getGrade() != grade1.getGrade()) return false;
        if (isExam() != grade1.isExam()) return false;
        if (isExamPassed() != grade1.isExamPassed()) return false;
        if (!getSubject().equals(grade1.getSubject())) return false;
        return getDate().equals(grade1.getDate());
    }

    @Override
    public int hashCode() {
        int result = getSubject().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getGrade();
        result = 31 * result + (isExam() ? 1 : 0);
        result = 31 * result + (isExamPassed() ? 1 : 0);
        return result;
    }
}