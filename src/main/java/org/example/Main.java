package org.example;


public class Main {
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee();
        salariedEmployee.setEmployeeId("E001");
        salariedEmployee.setSocialSecurityNumber("SSN123");
        salariedEmployee.setFixedMonthlyPayment(3000.0);

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setEmployeeId("E002");
        contractEmployee.setFederalTaxIdNumber("FTIN456");
        contractEmployee.setHourlyRate(15.0);
        contractEmployee.setNumberOfHoursWorked(160);

        System.out.println("Salaried Employee ID: " + salariedEmployee.getEmployeeId());
        System.out.println("Monthly Pay: " + salariedEmployee.calculatePay());
        System.out.println("-------------------------");
        System.out.println("Contract Employee ID: " + contractEmployee.getEmployeeId());
        System.out.println("Monthly Pay: " + contractEmployee.calculatePay());
    }
}