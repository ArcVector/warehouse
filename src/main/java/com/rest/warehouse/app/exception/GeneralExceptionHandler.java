/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.exception;


import com.rest.warehouse.app.common.exception.BaseRuntimeException;
import com.rest.warehouse.app.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Administrator
 */
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity<ErrorResponse> generalHandler(BaseRuntimeException exception)
    {
        HttpStatus status = exception.getStatus();
        ErrorResponse error = new ErrorResponse(
        status.value(), status.getReasonPhrase(), exception.getMessage());
        return new ResponseEntity<>(error, status);
        
    }
}
