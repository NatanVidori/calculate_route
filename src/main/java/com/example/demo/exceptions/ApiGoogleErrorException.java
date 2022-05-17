package com.example.demo.exceptions;

import com.example.demo.enums.ErrorMessageEnum;

import org.springframework.http.HttpStatus;

public class ApiGoogleErrorException extends StandardException {

    public ApiGoogleErrorException() {
        super(ErrorMessageEnum.ROUTE_ROUTE_ERROR.getMessage(), HttpStatus.BAD_GATEWAY.value());
    }

}
