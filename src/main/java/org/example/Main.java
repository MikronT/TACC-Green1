package org.example;

import org.example.flyingBirds.Eagle;
import org.example.flyingBirds.Swallow;
import org.example.nonflyingBirds.Chicken;
import org.example.nonflyingBirds.Penguin;


public class Main {
    public static void main(String[] args) {
        Bird[] birds = new Bird[4];
        birds[0] = new Eagle(true, false);
        birds[1] = new Swallow(true, true);
        birds[2] = new Penguin(false, false);
        birds[3] = new Chicken(true, false);

        for (int i = 0; i < birds.length; i++) {
            System.out.println(birds[i].getInfo());
        }
    }
}