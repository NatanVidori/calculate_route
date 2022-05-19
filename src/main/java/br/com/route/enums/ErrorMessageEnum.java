package br.com.route.enums;

public enum ErrorMessageEnum {

    ROUTE_NOT_FOUND("NÃO FOI POSSÍVEL IDENTIFICAR AS ROTAS."),
    ROUTE_DISTANCE_ERROR("OCORREU UM ERRO, TENTE NOVAMENTE MAIS TARDE.");

    private String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
