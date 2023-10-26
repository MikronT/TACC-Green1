package org.example;

import java.time.Year;
import java.util.Scanner;

public class Person {
    private String name;
    private int birthYear;


    public Person() {
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    // Геттери і сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int calculateAge() {
        int currentYear = Year.now().getValue();
        return currentYear - this.birthYear;
    }

    public void changeName(String newName) {
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
        System.out.println("Name: " + this.name);
        System.out.println("Birth Year: " + this.birthYear);
        System.out.println("Age: " + this.calculateAge() + "\n");
    }
}
