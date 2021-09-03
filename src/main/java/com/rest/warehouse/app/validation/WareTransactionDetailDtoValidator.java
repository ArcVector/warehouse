/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.validation;

import com.rest.warehouse.app.common.validation.BaseValidator;
import com.rest.warehouse.app.common.validation.CommonValidatorUtils;
import com.rest.warehouse.app.dto.WareTransactionDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class WareTransactionDetailDtoValidator implements BaseValidator<WareTransactionDetailDto> {
    
    private static final String FIELD_PRODUCT_ID="product";
    private static final String FIELD_SHELF_ID="shelf";
    private static final String FIELD_QUANTITY="quantity";
    
    private final CommonValidatorUtils commonValidatorUtils;
    
    @Autowired
    public WareTransactionDetailDtoValidator(CommonValidatorUtils commonValidatorUtils)
    {
        this.commonValidatorUtils = commonValidatorUtils;
    }
    @Override
    public void validate(WareTransactionDetailDto obj)
    {
        this.commonValidatorUtils.validateRequiredField(FIELD_PRODUCT_ID, obj.getProductId());
        this.commonValidatorUtils.validateRequiredField(FIELD_SHELF_ID, obj.getShelfId());
        this.commonValidatorUtils.validateRequiredField(FIELD_QUANTITY, obj.getQuantity());
        
    }
}
