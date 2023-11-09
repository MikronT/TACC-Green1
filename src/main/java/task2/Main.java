package org.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
* Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).
* Output the entities of the map on the screen.
* There are at less two persons with the same firstName among these 10 people?
* Remove from the map person whose firstName is "Orest" (or other). Print result.
* */


public class Main {
    public static void main(String[] args) {
        Map<String, String> personMap = new HashMap<>();

        personMap.put("Kalevski", "Orest");
        personMap.put("Miloshevich", "Gena");
        personMap.put("Lagarp", "Michele");
        personMap.put("Bernardot", "Zan");
        personMap.put("Nakonechyi", "Orest");
        personMap.put("Fifa", "Micha");
        personMap.put("Ubinav", "Vlad");
        personMap.put("Micron", "Vlad");
        personMap.put("Irlandian", "Gena");
        personMap.put("Dombrovski", "Zan");

        displayMap(personMap);

        System.out.println("\nThere are at less two persons with the same firstName among these 10 people?");

        if(hasDuplicateFirstName(personMap)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println('\n');

        deleteByFirstName(personMap);

        displayMap(personMap);
    }

    static void deleteByFirstName(Map<String, String> personMap) {
        Iterator<Map.Entry<String, String>> iterator = personMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getValue().equals("Orest")) {
                iterator.remove();
            }
        }
    }

    static <T, U> void displayMap(Map<T, U> map) {
        for (Map.Entry<T, U> entity : map.entrySet()) {
            System.out.println(entity.getKey() + " " + entity.getValue());
        }
    }

    static boolean hasDuplicateFirstName(Map<String, String> personMap) {
        Map<String, Integer> firstNameCountMap = new HashMap<>();

        for (String firstName : personMap.values()) {
            int count = firstNameCountMap.getOrDefault(firstName, 0);

            count++;
            firstNameCountMap.put(firstName, count);
            
            if (count >= 2) {
                return true;
            }
        }

        return false;
    }
}

