package org.example;

public class NonflyingBird extends Bird{
    @Override
    public void fly() {
        System.out.println("Non-flying bird cannot fly!");
    }
}
