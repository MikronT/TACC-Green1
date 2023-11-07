package org.example;

import java.util.HashSet;
import java.util.Set;

/*
* Write parameterized methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
*  realizing the operations of union and intersection of two sets.
*  Test the operation of these techniques on two pre-filled sets.
* */
class Union {
    public static <T> Set<T> union(Set<T>... args) {
        Set<T> unionSet = new HashSet<T>();

        for (Set<T> set : args) {
            unionSet.addAll(set);
        }

        return unionSet;
    }

    public static<T> Set<T> intersect(Set <T> ... args) {
        Set<T> intersectSet = new HashSet<T>(args[0]);

        for (Set<T> sets: args){
            intersectSet.retainAll(sets);
        }

        return intersectSet;
    }
}

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