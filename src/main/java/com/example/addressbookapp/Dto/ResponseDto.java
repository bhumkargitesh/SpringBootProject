package com.example.addressbookapp.Dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String msg;
    private Object data;
    private Object token;


    public ResponseDto(String msg, Object data,Object token) {
        this.msg = msg;
        this.data = data;
        this.token=token;
    }
}

