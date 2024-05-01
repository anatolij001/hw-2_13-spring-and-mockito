package ru.sidorovan.hw2_13springandmockito.service.impl;

import org.springframework.stereotype.Service;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeAlreadyAddedException;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeNotFoundException;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeStorgeIsFullException;
import ru.sidorovan.hw2_13springandmockito.model.Employee;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeService;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeValidationService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private final EmployeeValidationService employeeValidationService;
    public EmployeeServiceImpl(EmployeeValidationService employeeValidationService){
        this.employeeValidationService = employeeValidationService;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmentId){
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        return add(employee);
    }
    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {

        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE){
            throw new EmployeeStorgeIsFullException();
        }
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        employeeValidationService.validate(employee.getFirstName(), employee.getLastName());

        employees.put(employee.getFullName(), employee);
        return employee;
    }
}
