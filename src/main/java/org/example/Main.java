package org.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();
        for (int i = 0; i < 5; i++) {
            var e = new SalariedEmployee();
            e.setEmployeeId("salaried-" + i);
            e.setSocialSecurityNumber(Util.randomSocialSecurityNumber());
            e.setFixedMonthlyPayment(Util.randomMonthlyPayment());

            employees.add(e);
        }

        for (int i = 0; i < 7; i++) {
            var e = new ContractEmployee();
            e.setEmployeeId("contract-" + i);
            e.setFederalTaxIdNumber(Util.randomFederalTaxIdNumber());
            e.setHourlyRate(Util.randomHourlyRate());
            e.setNumberOfHoursWorked(Util.randomNumberOfHoursWorked());

            employees.add(e);
        }

        //Sort by descending the monthly wage
        employees.sort((o1, o2) -> Double.compare(o2.calculatePay(), o1.calculatePay()));

        System.out.println("| Employee Id | Monthly Payment |");
        System.out.println("| ----------- | --------------- |");
        for (var e : employees)
            System.out.printf("| %s  | %15.2f |" + System.lineSeparator(),
                    e.getEmployeeId(),
                    e.calculatePay());
    }
}