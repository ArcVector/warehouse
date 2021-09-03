/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Administrator
 */
@Getter
public class BaseRuntimeException extends RuntimeException{
 
    private HttpStatus status;
    
    public BaseRuntimeException(String message)
    {
        super(message);
    }
    
    public BaseRuntimeException(String message, HttpStatus status)
    {
        super(message);
        this.status = status;
    }
    
}
