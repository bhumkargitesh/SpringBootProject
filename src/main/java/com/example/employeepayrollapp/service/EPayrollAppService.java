package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.Dto.EmployeeDto;
import com.example.employeepayrollapp.model.Employee;

import java.util.List;

public interface EPayrollAppService {
    public List<Employee> getAllUserPeople();

    public Employee saveData(EmployeeDto empDto);

    public List<Employee> getUserByName(String Name);
}
