package com.example.employeepayrollapp.Dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String msg;
    private Object data;

    public ResponseDto(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }
}
