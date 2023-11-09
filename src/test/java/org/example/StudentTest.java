package org.example;

import org.example.object.Grade;
import org.example.object.Student;
import org.example.object.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;


public class StudentTest {
    @Test
    void addSubject() {
        Subject subject_math = new Subject("Вишка математика", true);
        Subject subject_dev = new Subject("Програмування на C", false);
        Subject subject_philosophy = new Subject("Програмування Java", true);

        Student student = new Student("Fedora", "Ubuntu")
                .addSubject(subject_math)
                .addSubject(subject_dev)
                .addSubject(subject_philosophy);

        Assertions.assertEquals(
                student.getSubjects(),
                List.of(subject_math, subject_dev, subject_philosophy));
    }

    @Test
    void removeSubject() {
        Subject subject_math = new Subject("Вишка математика", true);
        Subject subject_dev = new Subject("Програмування на C", false);
        Subject subject_philosophy = new Subject("Програмування Java", true);

        Student student = (new Student("Fedora", "Ubuntu"))
                .addSubject(subject_math)
                .addSubject(subject_dev)
                .addSubject(subject_philosophy);

        student.removeSubject(subject_philosophy);

        Assertions.assertEquals(
                student.getSubjects(),
                List.of(subject_math, subject_dev));
    }

    @Test
    void addGrade() {
        Subject subject_math = new Subject("Вишка математика", true);
        Subject subject_dev = new Subject("Програмування на C", false);
        Subject subject_philosophy = new Subject("Програмування Java", true);

        Grade grade_math = new Grade(subject_math, LocalDate.now(), 54);
        Grade grade_dev = new Grade(subject_dev, LocalDate.now(), 62);
        Grade grade_philosophy = new Grade(subject_philosophy, LocalDate.now(), 100);

        Student student = new Student("Fedora", "Ubuntu")
                .addSubject(subject_math)
                .addSubject(subject_dev)
                .addSubject(subject_philosophy)
                //Add student grades
                .addGrade(grade_math)
                .addGrade(grade_dev)
                .addGrade(grade_philosophy);

        Assertions.assertEquals(
                student.getGrades(),
                List.of(grade_math, grade_dev, grade_philosophy));
    }

    @Test
    void removeGrade() {
        Subject subject_math = new Subject("Вишка математика", true);
        Subject subject_dev = new Subject("Програмування на C", false);

        Grade grade_math = new Grade(subject_math, LocalDate.now(), 93);
        Grade grade_dev = new Grade(subject_dev, LocalDate.now(), 76);

        Student student = new Student("Fedora", "Ubuntu")
                .addSubject(subject_math)
                .addSubject(subject_dev)
                .addGrade(grade_math)
                .addGrade(grade_dev);

        student.removeGrade(grade_dev);

        Assertions.assertEquals(student.getGrades(), List.of(grade_math));
    }

    @Test
    void getFilteredGradesForStudentSubject() {
        Subject subject_math = new Subject("Вишка математика", true);
        Subject subject_philosophy = new Subject("Програмування Java", false);

        Grade grade_math = new Grade(subject_math, LocalDate.now(), 54);

        Grade grade_philosophy1 = new Grade(subject_philosophy, 100);
        Grade grade_philosophy2 = new Grade(subject_philosophy, 90);
        Grade grade_philosophy3 = new Grade(subject_philosophy, 85);
        Grade grade_philosophy4 = new Grade(subject_philosophy, 95);

        Student student = new Student("Вася", "Пупкін")
                .addSubject(subject_math)
                .addSubject(subject_philosophy)
                //Add student grades
                .addGrade(grade_math)
                .addGrade(grade_philosophy1)
                .addGrade(grade_philosophy2)
                .addGrade(grade_philosophy3)
                .addGrade(grade_philosophy4);

        Assertions.assertEquals(
                student.getGrades(subject_philosophy),
                List.of(grade_philosophy1, grade_philosophy4, grade_philosophy2, grade_philosophy3));
    }
}