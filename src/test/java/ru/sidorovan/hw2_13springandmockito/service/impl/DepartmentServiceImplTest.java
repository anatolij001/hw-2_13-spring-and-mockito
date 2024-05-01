package ru.sidorovan.hw2_13springandmockito.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeNotFoundException;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeService;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static ru.sidorovan.hw2_13springandmockito.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnTotalSalaryByDepartment() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(DEPARTMENT_TOTAL_SALARY, departmentService.getDepartmentSalarySum(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID1));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMaxSalaryEmployee() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID1));

    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindMinSalaryEmployee() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class, () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID1));

    }

    @Test
    public void shouldFindEmployeeByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);

        assertEquals(singletonList(MAX_SALARY_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID1));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE), departmentService.findEmployeesByDepartment(DEPARTMENT_ID2));
    }

    @Test
    public void shouldReturnEmployeesByDepartmentMap() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENTS_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP, departmentService.findEmployeesByDepartment());
    }

}