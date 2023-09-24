package com.example.employeepayrollapp.controller;

import com.example.employeepayrollapp.Dto.EmployeeDto;
import com.example.employeepayrollapp.Dto.ResponseDto;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.service.PayrollAppService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PayrollController {
    @Autowired
    PayrollAppService payrollappService;



    @PostMapping("/addEmployeeDto")
    public ResponseEntity<ResponseDto>  addEmployeeDto(@Valid  @RequestBody EmployeeDto empDto){
        Employee employee=payrollappService.addEmployeeDto(empDto);
        ResponseDto responseDto=new ResponseDto("new employee added successfully",employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }
    @GetMapping("/greetById/{id}")
    public ResponseEntity<ResponseDto> greetById(@PathVariable int id) {
        Employee employee=payrollappService.greetById(id);
        ResponseDto responseDto=new ResponseDto("new employee added successfully",employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseDto> deleteById(@Valid @PathVariable int id){
        Employee employee = payrollappService.deleteById(id);
        ResponseDto responseDto = new ResponseDto("Employee deleted successfully",employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<ResponseDto> updateById(@Valid @PathVariable int id, @RequestBody EmployeeDto empDto)
    {
        Employee employee = payrollappService.updateById(empDto,id);
        ResponseDto responseDto = new ResponseDto("Employee deleted successfully",employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }
    @GetMapping("/allPeople")
    public List<Employee> getAll(){
        return payrollappService.getAllUserPeople();
    }


//    @GetMapping("/name/{name}")
//    public List<EmployeeDto> getByName(@PathVariable String name){
//        return payrollappService.getUserByName(name);
//    }

}

