package ru.sidorovan.hw2_13springandmockito.model;

import java.util.Objects;
import java.util.Random;

import static org.apache.commons.lang3.StringUtils.capitalize;


public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;

    public Employee(String firstName, String lastName) {
        Random random = new Random();
        this.firstName = capitalize(firstName);
        this.lastName = capitalize(lastName);
        this.salary = random.nextInt(10000) + 1000;
        this.departmentId = random.nextInt(5) + 1;
    }

    public Employee(String firstName, String lastName, int salary, int departmentId) {
        this.firstName = capitalize(firstName);
        this.lastName = capitalize(lastName);
        this.salary = salary;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentID) {
        this.departmentId = departmentID;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
