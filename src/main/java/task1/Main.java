package org.example;

import task1.Union;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> set3 = new HashSet<>();
        set3.add(2);
        set3.add(3);
        set3.add(6);

        Set<Integer> unionResult = Union.union(set1, set2, set3);
        System.out.println("Union of set1, set2, and set3: " + unionResult);

        Set<Integer> intersectResult = Union.intersect(set1, set2, set3);
        System.out.println("Intersection of set1, set2, and set3: " + intersectResult);

    }
}