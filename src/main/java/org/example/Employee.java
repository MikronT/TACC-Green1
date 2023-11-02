package org.example;

public abstract class Employee implements Payable {
    private String employeeId;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}