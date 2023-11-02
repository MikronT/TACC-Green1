package org.example;

interface Payable {
    double calculatePay();
}

abstract class Employee implements Payable {
    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}

class SalariedEmployee extends Employee {
    private String socialSecurityNumber;
    private double fixedMonthlyPayment;

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    @Override
    public double calculatePay() {
        return fixedMonthlyPayment;
    }
}

class ContractEmployee extends Employee {
    private String federalTaxIdNumber;
    private double hourlyRate;
    private int numberOfHoursWorked;

    public String getFederalTaxIdNumber() {
        return federalTaxIdNumber;
    }

    public void setFederalTaxIdNumber(String federalTaxIdNumber) {
        this.federalTaxIdNumber = federalTaxIdNumber;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getNumberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    public void setNumberOfHoursWorked(int numberOfHoursWorked) {
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * numberOfHoursWorked;
    }
}

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
