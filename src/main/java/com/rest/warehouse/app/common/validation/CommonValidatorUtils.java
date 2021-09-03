/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.validation;

import com.rest.warehouse.app.exception.FieldNotUniqueException;
import com.rest.warehouse.app.exception.MissingRequiredFieldException;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class CommonValidatorUtils<T, S> {
    
    public void validateUniqueField(String fieldName, T checkingObj, S foundObj)
    {
        BeanWrapperImpl checkingObjWrapper = new BeanWrapperImpl(checkingObj);
        Object checkingObjId = checkingObjWrapper.getPropertyValue("id");
        String checkingObjFieldValue = checkingObjWrapper.getPropertyValue(fieldName).toString();
        
        BeanWrapperImpl foundObjWrapper = new BeanWrapperImpl(foundObj);
        Object foundObjId = foundObjWrapper.getPropertyValue("id");
        
        if(checkingObjId==null)
        {
            throw new FieldNotUniqueException(checkingObjFieldValue);
        }
        
        if(checkingObjId!=null)
        {
            if(checkingObjId != foundObjId)
            {
                throw new FieldNotUniqueException(checkingObjFieldValue);
            }
        }
    }
    
        
        public void validateRequiredField(String fieldLabel, T fieldValue)
        {
            if(fieldValue == null)
            {
                throw new MissingRequiredFieldException(fieldLabel);
            }
            
        }
        
    }

