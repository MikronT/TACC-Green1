package task3;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private int course;

    public Student(String name, int course) {
        setName(name);
        setCourse(course);
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setName(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException("Empty name");
        }

        this.name = name;
    }

    public void setCourse(int course) {
        if(course <= 0 || course > 8) {
            throw new IllegalArgumentException("Incorrect course");
        }

        this.course = course;
    }

    public static void printStudents(List<Student> students, int targetCourse) {
        for (Student student : students) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, course);
    }
}
