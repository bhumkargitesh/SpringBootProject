package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.Dto.EmployeeDto;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repo.PayrollAppRepo;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class PayrollAppService {
private List<Employee>employeeList= new ArrayList<>();
    @Autowired
    PayrollAppRepo payrollAppRepo;


   // public Employee addEmployee(EmployeeDto empDto) {
//        return payrollAppRepo.save(empDto);
//    }
    public Employee addEmployeeDto(EmployeeDto empDto) {
        Employee employee = new Employee(empDto);
        employeeList.add(employee);
        return payrollAppRepo.save(employee);
    }
    public Employee greetById(int id) {
        return payrollAppRepo.findById(id).orElse(null);

    }
    public Employee deleteById(int id) {
        payrollAppRepo.deleteById(id);
        return  null;
    }

        public Employee updateById(@NotNull  EmployeeDto empDto, int id) {
            Employee emp = new Employee(empDto);
            emp.setEmployeeId(id);
        return payrollAppRepo.save(emp);
   }

//public Employee updateEmpData(EmployeeDto employeeDto,int id)  {
   // Employee employee = employeeList.stream().filter(employee -> employee.getEmployeeId()==id).findFirst().orElseThrow(() -> new RuntimeException("Employee id not present"));

//    employee.setName(employeeDto.name);
//    employee.setSalary(employeeDto.salary);
//    return employee;
//}

//    public Employee saveData(EmployeeDto  empDto) {
//        Employee emp = new Employee(empDto);
//        return payrollAppRepo.save(emp);
//    }


//    public List<EmployeeDto> getUserByName(String name) {
//        return payrollAppRepo.findByName(name);
//    }

    public List<Employee> getAllUserPeople() {
        List<Employee> emplist = payrollAppRepo.findAll();

        return emplist;
    }
}