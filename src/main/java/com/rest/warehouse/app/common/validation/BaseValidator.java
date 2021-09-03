/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.validation;

/**
 *
 * @author Administrator
 */
public interface BaseValidator<T> {
    void validate(T obj);
    
}
