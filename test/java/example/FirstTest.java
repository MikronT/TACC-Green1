package example;

import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FirstTest {
    @Test
    public void comparableCourse() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vova", 1));
        students.add(new Student("Bogdan", 2));
        students.add(new Student("Maria", 1));
        students.add(new Student("Dasha", 3));
        students.add(new Student("Anna", 2));

        students.sort(Student.compareByCourse());

        Assertions.assertEquals(students, List.of(new Student("Vova", 1),
                new Student("Maria", 1),
                new Student("Bogdan", 2),
                new Student("Anna", 2),
                new Student("Dasha", 3)));
    }

    @Test
    public void comparableName() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vova", 1));
        students.add(new Student("Bogdan", 2));
        students.add(new Student("Maria", 1));
        students.add(new Student("Dasha", 3));
        students.add(new Student("Anna", 2));

        students.sort(Student.compareByName());

        Assertions.assertEquals(students, List.of(new Student("Anna", 2),
                new Student("Bogdan", 2),
                new Student("Dasha", 3),
                new Student("Maria", 1),
                new Student("Vova", 1)
                ));
    }

    @Test
    public void getName() {
        Student student = new Student("Vova", 1);

        Assertions.assertEquals(student.getName(), "Vova");
    }

    @Test
    public void getCourse() {
        Student student = new Student("Vova", 3);

        Assertions.assertEquals(student.getCourse(), 3);
    }

    @Test
    public void setName() {
        Student student = new Student("Vlad", 2);

        Assertions.assertThrows(IllegalArgumentException.class,() -> student.setName(""));
    }

    @Test
    public void setCourse() {
        Student student = new Student("Vlad", 3);

        Assertions.assertThrows(IllegalArgumentException.class,() -> student.setCourse(0));

    }
}
