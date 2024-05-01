package ru.sidorovan.hw2_13springandmockito;

import ru.sidorovan.hw2_13springandmockito.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstants {
    public static final String FIRST_NAME1 = "Сергей";
    public static final String LAST_NAME1 = "Кулебякин";

    public static final String FIRST_NAME2 = "Нина";
    public static final String LAST_NAME2 = "Петрова";

    public static final String FIRST_NAME3 = "Виктор";
    public static final String LAST_NAME3 = "Васильев";

    public static final String FIRST_NAME4 = "Виктория";
    public static final String LAST_NAME4 = "Санник";

    public static final String FIRST_NAME5 = "Ирина";
    public static final String LAST_NAME5 = "Кац";

    public static final String FIRST_NAME6 = "Михаил";
    public static final String LAST_NAME6 = "Шац";

    public static final String FIRST_NAME7 = "Герман";
    public static final String LAST_NAME7 = "Кан";

    public static final String FIRST_NAME8 = "Алёна";
    public static final String LAST_NAME8 = "Конькина";

    public static final String FIRST_NAME9 = "Мария";
    public static final String LAST_NAME9 = "Гунькина";

    public static final String FIRST_NAME10 = "Иван";
    public static final String LAST_NAME10 = "Гейн";

    public static final String FIRST_NAME11 = "Самуил";
    public static final String LAST_NAME11 = "Маршак";

    public static final String INCORRECT_FIRST_NAME = "Самуил!";
    public static final String INCORRECT_LAST_NAME = "Маршак-89";




    public static final int MIN_SALARY = 10_000;
    public static final int MAX_SALARY = 150_000;


    public static final int DEPARTMENT_ID1 = 1;
    public static final int DEPARTMENT_ID2 = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME1, LAST_NAME1, MAX_SALARY, DEPARTMENT_ID1);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME1, LAST_NAME1, MIN_SALARY, DEPARTMENT_ID1);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME3, LAST_NAME3, MIN_SALARY, DEPARTMENT_ID2);


    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENTS_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, DIFFERENT_DEPARTMENT_EMPLOYEE);

    public static final Integer DEPARTMENT_TOTAL_SALARY = EMPLOYEES.stream().mapToInt(Employee::getSalary).sum();

    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENT_MAP = DIFFERENT_DEPARTMENTS_EMPLOYEES.stream()
            .collect(groupingBy(Employee::getDepartmentId));
}
