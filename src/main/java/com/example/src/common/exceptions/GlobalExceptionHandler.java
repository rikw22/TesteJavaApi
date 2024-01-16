package com.example.src.common.exceptions;

import com.example.src.pedido.validations.ValidacaoPedidoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoPedidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse handleValidacaoException(Exception e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorResponse handleException(HandlerMethodValidationException e) {
        StringBuilder messageBuilder = new StringBuilder();
        for(Object validationErrorMessage : e.getDetailMessageArguments()) {
            messageBuilder.append(validationErrorMessage);
        }
        return new ErrorResponse(messageBuilder.toString());
    }
}
