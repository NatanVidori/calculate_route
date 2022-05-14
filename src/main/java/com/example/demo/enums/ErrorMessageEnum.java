package com.example.demo.enums;

public enum ErrorMessageEnum {

    ROUTE_NOT_FOUND("NÃO FOI POSSÍVEL IDENTIFICAR AS ROTAS."),
    API_GOOGLE_ERROR("OCORREU ERRO NA API GOOGLE MAPS, TENTE NOVAMENTE MAIS TARDE.");

    private String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
