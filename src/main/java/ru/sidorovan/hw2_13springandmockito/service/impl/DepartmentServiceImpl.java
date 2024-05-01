package ru.sidorovan.hw2_13springandmockito.service.impl;

import org.springframework.stereotype.Service;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeNotFoundException;
import ru.sidorovan.hw2_13springandmockito.model.Employee;
import ru.sidorovan.hw2_13springandmockito.service.DepartmentService;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Integer getDepartmentSalarySum(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(int departmentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(comparing(Employee::getFullName))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .collect(groupingBy(Employee::getDepartmentId));
    }
}
