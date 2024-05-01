package ru.sidorovan.hw2_13springandmockito.service.impl;

import org.junit.jupiter.api.Test;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeAlreadyAddedException;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeNotFoundException;
import ru.sidorovan.hw2_13springandmockito.exception.EmployeeStorgeIsFullException;
import ru.sidorovan.hw2_13springandmockito.model.Employee;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeValidationService;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sidorovan.hw2_13springandmockito.EmployeeTestConstants.*;


class EmployeeServiceImplTest {
    private final EmployeeValidationService validationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);

    @Test
    public void shouldAddEmployee() {
        assertEquals(0, employeeService.findAll().size());

        Employee addedEmployee = employeeService.add(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1);
        assertEquals(1, employeeService.findAll().size());

        //Проверяем, что внутри коллекции есть сотрудник "addedEmployee":
        assertTrue(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeStorageIsFullException() {
        employeeService.add(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME2, LAST_NAME2, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME3, LAST_NAME3, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME4, LAST_NAME4, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME5, LAST_NAME5, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME6, LAST_NAME6, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME7, LAST_NAME7, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME8, LAST_NAME8, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME9, LAST_NAME9, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.add(FIRST_NAME10, LAST_NAME10, MAX_SALARY, DEPARTMENT_ID1);

        assertThrows(EmployeeStorgeIsFullException.class,
                () -> employeeService.add(FIRST_NAME11, LAST_NAME11, MAX_SALARY, DEPARTMENT_ID1));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        employeeService.add(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.add(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1));
    }

    @Test
    public void shouldRemoveEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1);
        employeeService.remove(FIRST_NAME1, LAST_NAME1);
        assertFalse(employeeService.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.remove(FIRST_NAME10, LAST_NAME10));
    }

    @Test
    public void shouldFindEmployee() {
        Employee addedEmployee = employeeService.add(FIRST_NAME2, LAST_NAME2, MAX_SALARY, DEPARTMENT_ID2);
        assertEquals(addedEmployee, employeeService.find(FIRST_NAME2, LAST_NAME2));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFind() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find(FIRST_NAME2, LAST_NAME2));
    }

    @Test
    public void shouldReturnAllEmployees() {
        Employee addedEmployee1 = employeeService.add(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1);
        Employee addedEmployee2 = employeeService.add(FIRST_NAME3, LAST_NAME3, MAX_SALARY, DEPARTMENT_ID1);

        Collection<Employee> addedEmployees = employeeService.findAll();
        assertIterableEquals(List.of(addedEmployee2, addedEmployee1), addedEmployees);
    }
}