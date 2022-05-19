package br.com.route.exceptions;

import org.springframework.http.HttpStatus;

import br.com.route.enums.ErrorMessageEnum;

public class ApiGoogleErrorException extends StandardException {

    public ApiGoogleErrorException() {
        super(ErrorMessageEnum.ROUTE_DISTANCE_ERROR.getMessage(), HttpStatus.BAD_GATEWAY.value());
    }

}
