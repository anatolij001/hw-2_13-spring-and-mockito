package ru.sidorovan.hw2_13springandmockito.service.impl;

import org.junit.jupiter.api.Test;
import ru.sidorovan.hw2_13springandmockito.exception.InvalidEmployeeDataException;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeValidationService;

import static org.junit.jupiter.api.Assertions.*;
import static ru.sidorovan.hw2_13springandmockito.EmployeeTestConstants.INCORRECT_FIRST_NAME;
import static ru.sidorovan.hw2_13springandmockito.EmployeeTestConstants.INCORRECT_LAST_NAME;

class EmployeeValidationServiceImplTest {
    public static final EmployeeValidationService validationService = new EmployeeValidationServiceImpl();

    @Test
    public void shouldThrowInvalidEmployeeDataException(){
        assertThrows(InvalidEmployeeDataException.class, () -> validationService.validate(INCORRECT_FIRST_NAME, INCORRECT_LAST_NAME));
    }

}