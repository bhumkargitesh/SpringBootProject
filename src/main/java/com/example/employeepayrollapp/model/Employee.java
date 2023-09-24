package com.example.employeepayrollapp.model;

import com.example.employeepayrollapp.Dto.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private  int employeeId;

    private String name;
    private String startDate;
    private String gender;
    private String note;
    private String department;
    private String profilePic;
    private long salary;

    public Employee( EmployeeDto empDto) {    //Save


        this.name = empDto.name;
        this.salary = empDto.salary;
        this.gender = empDto.gender;
        this.startDate = empDto.startDate;
        this.note = empDto.note;
        this.profilePic = empDto.profilePic;
        this.department = empDto.department;

    }
//    public Employee (int employeeId,EmployeeDto employeeDto) {    //updating
//        this.employeeId = employeeId;
//        this.name = employeeDto.name;
//        this.salary = employeeDto.salary;
//        this.gender = employeeDto.gender;
//        this.startDate = employeeDto.startDate;
//        this.note = employeeDto.note;
//        this.profilePic = employeeDto.profilePic;
//        this.department = employeeDto.department;
//    }

}
