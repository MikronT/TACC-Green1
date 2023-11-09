package org.example;

import org.example.object.Grade;
import org.example.object.Group;
import org.example.object.Student;
import org.example.object.Subject;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Create subjects
        var subject_math = new Subject("Вишка математика", true);
        var subject_dev = new Subject("Програмування на C", false);
        var subject_philosophy = new Subject("Програмування Java", false);

        //Create students, then add subjects and some grades
        var student_vasia = new Student("Вася", "Пупкін")
                //Add some subjects
                .addSubject(subject_math)
                .addSubject(subject_dev)
                .addSubject(subject_philosophy)
                //Add some grades
                .addGrade(new Grade(subject_math, 54))
                .addGrade(new Grade(subject_dev, 62))
                .addGrade(new Grade(subject_philosophy, 100));
        var student_vlad = new Student("Влад", "Пупкін")
                .addSubject(subject_philosophy)
                .addGrade(new Grade(subject_philosophy, 96));
        var student_volodia = new Student("Володя", "Пупкін")
                .addSubject(subject_dev)
                .addSubject(subject_philosophy)
                .addGrade(new Grade(subject_philosophy, 94));
        var student_vadym = new Student("Вадим", "Пупкін")
                .addSubject(subject_math)
                .addSubject(subject_philosophy)
                .addGrade(new Grade(subject_philosophy, 89));

        //Create groups and add students
        var group1 = new Group("ІП-20", 2020)
                .addStudent(student_vasia)
                .addStudent(student_vlad);
        var group2 = new Group("КІ-27к", 2022)
                .addStudent(student_volodia)
                .addStudent(student_vasia)
                .addStudent(student_vlad)
                .removeStudent(student_vasia);
        var group3 = new Group("СІ-22", 2020)
                .addStudent(student_vadym)
                .addStudent(student_volodia)
                .addStudent(student_vasia);

        //Add all groups to the list
        var groups = List.of(group1, group2, group3);

        //For example, get average for philosophy in the whole university
        int sum = 0;
        int count = 0;
        //Sum all the marks within all groups
        for (var group : groups) {
            //For all students
            for (var student : group.getStudents()) {
                //With subject philosophy
                for (var grade : student.getGrades(subject_philosophy)) {
                    sum += grade.getGrade();
                    //Anc count grades
                    count++;
                }
            }
        }
        float average = (float) sum / count;
        System.out.printf("Average for philosophy (%d grades): %.3f" + System.lineSeparator(),
                count,
                average);
    }
}