package ru.sidorovan.hw2_13springandmockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sidorovan.hw2_13springandmockito.model.Employee;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeService;
import ru.sidorovan.hw2_13springandmockito.service.impl.EmployeeServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }
    @GetMapping("add2")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam int salary,
                        @RequestParam int departmentId) {
        return employeeService.add(firstName, lastName, salary, departmentId);
    }

    @GetMapping("remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }


}
