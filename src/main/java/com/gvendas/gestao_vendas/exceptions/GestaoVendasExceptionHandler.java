package com.gvendas.gestao_vendas.exceptions;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GestaoVendasExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String NOT_BLANK = "NotBlank";
    private static final String LENGTH = "Length";

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Error> errors = generateErrorList(ex.getBindingResult());

        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    // TODO: Padronizar mensagens de exceção com o padrão RFC 9457


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        String msgUser = "Resource not found.";
        String msgDeveloper = ex.toString();
        List<Error> errors = Arrays.asList(new Error(msgUser, msgDeveloper));
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(CategoryDuplicateException.class)
    public ResponseEntity<Object> handleCategoryDuplicateException(CategoryDuplicateException ex, WebRequest request) {
        String msgUser = ex.getMessage();
        String msgDeveloper = ex.getMessage();
        List<Error> errors = Arrays.asList(new Error(msgUser, msgDeveloper));
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    private List<Error> generateErrorList(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            String msgUser = handleErrorMessageForUser(fieldError);
            String msgDeveloper = fieldError.toString();
            errors.add(new Error(msgUser, msgDeveloper));
        });

        return errors;
    }

    private String handleErrorMessageForUser(FieldError fieldError) {
        if(fieldError.getCode().equals(NOT_BLANK)) {
            return fieldError.getDefaultMessage().concat(" is required.");
        }
        if(fieldError.getCode().equals(LENGTH)) {
            assert fieldError.getArguments() != null;
            assert fieldError.getDefaultMessage() != null;
            return fieldError.getDefaultMessage().concat(String.format(" must be between %s and %s characters", fieldError.getArguments()[2], fieldError.getArguments()[1]));
        }
        return fieldError.toString();
    }

}
