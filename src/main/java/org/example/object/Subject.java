package org.example.object;

public class Subject {
    private final String name;
    private boolean hasFinalExam; //Exam - true; offset - false;


    public Subject(String name, boolean hasFinalExam) {
        this.name = name;
        this.hasFinalExam = hasFinalExam;
    }

    public String getName() {
        return name;
    }

    public boolean hasFinalExam() {
        return hasFinalExam;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return getName().equals(subject.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}