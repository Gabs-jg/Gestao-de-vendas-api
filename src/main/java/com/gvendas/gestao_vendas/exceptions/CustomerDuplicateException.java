package com.gvendas.gestao_vendas.exceptions;

public class CustomerDuplicateException extends RuntimeException {

    public CustomerDuplicateException(String message) {
        super(message);
    }

}
