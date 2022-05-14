package com.example.demo.exceptions;

import com.example.demo.enums.ErrorMessageEnum;

import org.springframework.http.HttpStatus;

public class RouteNotFoundException extends StandardException {

    public RouteNotFoundException() {
        super(ErrorMessageEnum.ROUTE_NOT_FOUND.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
