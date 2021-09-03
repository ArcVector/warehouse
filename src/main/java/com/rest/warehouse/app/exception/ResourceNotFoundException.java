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
public class ResourceNotFoundException extends BaseRuntimeException {
    
    public ResourceNotFoundException(Long id)
    {
        super("Resource with " +id + "not found", HttpStatus.BAD_REQUEST);
    }
    
}
