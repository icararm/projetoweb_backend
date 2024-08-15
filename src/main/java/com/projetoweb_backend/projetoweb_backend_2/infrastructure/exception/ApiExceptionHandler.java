package com.projetoweb_backend.projetoweb_backend_2.infrastructure.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Value(value = "${server.error-exception}")
    private boolean printStackTrace;

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleBusinessException(
            final BusinessException businessException,
            final WebRequest request){
        final String mensagemErro = businessException.getMessage();

        logger.error(mensagemErro, businessException);

        return  construirMensagemErro(
                businessException,
                mensagemErro,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }

    private ResponseEntity<Object> construirMensagemErro(
            final Exception exception,
            final String mensagemErro,
            final HttpStatus status,
            final WebRequest request) {

        // Construindo o corpo da resposta de erro
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", mensagemErro);
        body.put("path", request.getDescription(false)); // Obtém o caminho da requisição

        if (printStackTrace) {
            body.put("exception", exception.getClass().getName());
            body.put("stackTrace", exception.getStackTrace());
        }

        return new ResponseEntity<>(body, status);
    }
}
