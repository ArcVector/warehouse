/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.exception;

import com.rest.warehouse.app.common.exception.BaseRuntimeException;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Administrator
 */
public class FieldNotUniqueException extends BaseRuntimeException{
    public FieldNotUniqueException(String message)
    {
        super("Field" +message +"is not unique", HttpStatus.BAD_REQUEST);
        
    }
    
}
