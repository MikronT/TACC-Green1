package org.example;

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
