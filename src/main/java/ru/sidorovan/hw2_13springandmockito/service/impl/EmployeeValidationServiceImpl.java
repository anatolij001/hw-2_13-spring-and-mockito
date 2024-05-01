package ru.sidorovan.hw2_13springandmockito.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.sidorovan.hw2_13springandmockito.exception.InvalidEmployeeDataException;
import ru.sidorovan.hw2_13springandmockito.service.EmployeeValidationService;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }
    private void validateName(String name){
        if (!StringUtils.isAlpha(name)){
            throw  new InvalidEmployeeDataException("Некорректное имя сотрудника");
        }
     }
}
