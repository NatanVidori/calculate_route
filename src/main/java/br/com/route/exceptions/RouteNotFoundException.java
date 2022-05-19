package br.com.route.exceptions;

import org.springframework.http.HttpStatus;

import br.com.route.enums.ErrorMessageEnum;

public class RouteNotFoundException extends StandardException {

    public RouteNotFoundException() {
        super(ErrorMessageEnum.ROUTE_NOT_FOUND.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

}
