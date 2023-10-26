package org.example;

import java.time.Year;
import java.util.Scanner;

public class Person {
    private String name;
    private int birthYear;

    public Person () {};
    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    String getName() {
        return name;
    }

    int getBirthYear() {
        return birthYear;
    }

    void setName(String name) {
        this.name = name;
    }

    void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int age() {
        int date = Year.now().getValue();
        return  date - this.birthYear;
    }

    public void changeName (String newName) {
        this.name = newName;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter birth year: ");
        this.birthYear = scanner.nextInt();
    }

    public void output() {
        System.out.println("age: " + this.age() );
        System.out.println("name: " + this.name);
        System.out.println("birthYear: " + this.birthYear + '\n');
    }
}