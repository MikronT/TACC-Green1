package org.example;
import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Person person1 = new Person("Biba", 2004);
        final Person person2 = new Person();
        final Person person3 = new Person();
        final Person person4 = new Person();
        final Person person5 = new Person("Miranda Libovski", 1988);

        person1.output();

        person1.setName("Bill");
        person1.output();

        person1.setBirthYear(1991);
        person1.output();

        person2.input();

        System.out.println(person2.getName());
        System.out.println(person2.getBirthYear());
        System.out.println(person2.age() + '\n');

        person3.changeName("Marcus Aurelius");
        person4.input();
        person5.input();


        System.out.println("Information about people:");
        person1.output();
        person2.output();
        person3.output();
        person4.output();
        person5.output();

    }
}