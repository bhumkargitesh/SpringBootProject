package com.example.employeepayrollapp.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeDto {

    @NotEmpty(message="employed cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @JsonFormat(pattern = "dd mm yyyy")
    @NotEmpty(message = "start date should be not empty")
    public String startDate;
    @Pattern(regexp = "male|female",message = "gender needs to be male or female")
    public String gender;
    @NotBlank(message = "note cannot be empty")
    public String note;
    @NotBlank(message = "department not be empty")
    public String department;
    @NotBlank(message = "profile pic not be empty")
    public String profilePic;
    @Min(value = 500,message = "minimum wages should be 500")
    public long salary;

    public EmployeeDto(String name, String startDate, String gender, String note, String department, String profilePic, long salary) {
        this.name = name;
        this.startDate = startDate;
        this.gender = gender;
        this.note = note;
        this.department = department;
        this.profilePic = profilePic;
        this.salary = salary;
    }
}
