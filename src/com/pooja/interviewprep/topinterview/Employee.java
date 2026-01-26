package com.pooja.interviewprep.topinterview;

import java.util.Objects;

//equals and hashcode
public class Employee {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Alice", 50000);
        Employee e2 = new Employee(1, "Alice", 50000);
        Employee e3 = new Employee(2, "Bob", 60000);

        System.out.println(e1.equals(e2)); // true
        System.out.println(e1.equals(e3)); // false

        System.out.println(e1.hashCode() == e2.hashCode()); // true
        System.out.println(e1.hashCode() == e3.hashCode()); // likely false
    }

    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setters (optional for mutability)
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    // =========================
    // equals() method
    // =========================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference
        if (o == null || getClass() != o.getClass()) return false; // null or different class

        Employee employee = (Employee) o; // Type cast

        // Field comparison
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    // =========================
    // hashCode() method
    // =========================
    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

}
