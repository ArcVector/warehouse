/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.validation;

import com.rest.warehouse.app.common.validation.BaseValidator;
import com.rest.warehouse.app.common.validation.CommonValidatorUtils;
import com.rest.warehouse.app.dto.StockClerkDto;
import com.rest.warehouse.app.model.StockClerk;
import com.rest.warehouse.app.repository.StockClerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class StockClerkDtoValidator implements BaseValidator<StockClerkDto>{
    
    private static final String FIELD_FIRST_NAME ="First name";
    private static final String FIELD_LAST_NAME ="Last name";
    private static final String FIELD_REGISTRY_NUMBER ="Registry number";
    
    private final StockClerkRepository stockClerkRepository;
    private final CommonValidatorUtils commonValidatorUtils;
    
    @Autowired
    public StockClerkDtoValidator
            (StockClerkRepository stockClerkRepository, CommonValidatorUtils commonValidatorUtils)
            {
                this.stockClerkRepository = stockClerkRepository;
                this.commonValidatorUtils=commonValidatorUtils;
            }
            
            @Override
            public void validate(StockClerkDto obj)
            {
                validateUniqueRegistryNumber(obj);
                this.commonValidatorUtils.validateRequiredField(FIELD_FIRST_NAME, obj.getFirstName());
                this.commonValidatorUtils.validateRequiredField(FIELD_LAST_NAME, obj.getLastName());
                
            }
            private void validateUniqueRegistryNumber(StockClerkDto stockClerkDto)
            {
StockClerk stockClerk = this.stockClerkRepository
                .findByRegistryNumber(stockClerkDto.getRegistryNumber()).orElse(null);
                

if(stockClerk!=null)
{
    this.commonValidatorUtils.validateUniqueField(FIELD_REGISTRY_NUMBER, stockClerkDto, stockClerk);
}
            }
            
            
}
