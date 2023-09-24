package com.example.employeepayrollapp.exception;

import com.example.employeepayrollapp.Dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objectError -> objectError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDTO = new ResponseDto("Exception while processing  REST  Request", errMsg);
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception) {

        ResponseDto responseDTO = new ResponseDto("Exception While processing REST Request", exception.getMessage());
        return new ResponseEntity<ResponseDto>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}