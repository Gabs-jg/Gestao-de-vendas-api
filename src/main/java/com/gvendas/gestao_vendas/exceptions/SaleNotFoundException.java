package com.gvendas.gestao_vendas.exceptions;

public class SaleNotFoundException extends RuntimeException {

    public SaleNotFoundException(String message) {
        super(message);
    }

}
