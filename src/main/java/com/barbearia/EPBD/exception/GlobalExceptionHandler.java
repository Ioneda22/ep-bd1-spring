package com.barbearia.EPBD.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {

        String errorMessage = e.getBindingResult().getFieldError() != null
                ? e.getBindingResult().getFieldError().getDefaultMessage()
                : "Erro de validação";

        return buildResponse(HttpStatus.BAD_REQUEST, "Dados inválidos", errorMessage, request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.NOT_FOUND, "Recurso não encontrado", e.getMessage(), request);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandardError> businessRule(BusinessRuleException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.CONFLICT, "Conflito de dados", e.getMessage(), request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> databaseIntegrity(DataIntegrityViolationException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.CONFLICT, "Conflito de dados", "Este CPF ou Email já está cadastrado no sistema.", request);
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<StandardError> transactionError(TransactionSystemException e, HttpServletRequest request) {

        Throwable cause = e.getRootCause();
        String message = "Erro na transação do banco de dados";

        if (cause instanceof ConstraintViolationException constraintViolations) {
            message = constraintViolations.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .findFirst()
                    .orElse("Erro de validação interna");
        }

        return buildResponse(HttpStatus.BAD_REQUEST, "Dados inconsistentes", message, request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> jsonFormatError(HttpMessageNotReadableException e, HttpServletRequest request) {

        String mensagem = "Erro no formato do JSON enviado.";

        if (e.getMessage() != null && e.getMessage().contains("LocalDate")) {
            mensagem = "Formato de data inválido. Use o padrão AAAA-MM-DD (Ex: 2000-12-31) e certifique-se que a data existe.";
        }

        return buildResponse(HttpStatus.BAD_REQUEST, "Formato Inválido", mensagem, request);
    }

    private ResponseEntity<StandardError> buildResponse(HttpStatus status, String error, String message, HttpServletRequest request) {
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError(error);
        err.setMessage(message);
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}