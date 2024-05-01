package ru.sidorovan.hw2_13springandmockito.controller;

import org.springframework.web.bind.annotation.*;
import ru.sidorovan.hw2_13springandmockito.model.Employee;
import ru.sidorovan.hw2_13springandmockito.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{departmentId}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable int departmentId){
        return departmentService.getDepartmentSalarySum(departmentId);
    }

    @GetMapping("{departmentId}/salary/max")
    public Employee findEmployeeWithMaxSalary(@PathVariable int departmentId){
        return departmentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping("{departmentId}/salary/min")
    public Employee findEmployeeWithMinSalary(@PathVariable int departmentId){
        return departmentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "{departmentId}/employees", params = {"departmentId"})
    public Collection<Employee> findEmployeeByDepartment(@PathVariable int departmentId){
        return departmentService.findEmployeesByDepartment(departmentId);
    }
    @GetMapping("employees")
    public Map<Integer, List<Employee>> findEmployeeByDepartment(){
        return departmentService.findEmployeesByDepartment();
    }
}
