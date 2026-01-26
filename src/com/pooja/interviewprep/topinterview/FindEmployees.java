package com.pooja.interviewprep.topinterview;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindEmployees {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 900000.0),
                new Employee(2, "Bob", 1200000.0),
                new Employee(3, "Charlie", 1500000.0)
        );

        // filter employees whose salary > 1_000_000 and return Map(id,salary) of those employees:
        Map<Integer, Double> employeeSalaryMap = employees.stream()
                .filter(e -> e.getSalary() > 1_000_000)
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getSalary
                ));

        System.out.println(employeeSalaryMap);
    }
}

