/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.validation;

import com.rest.warehouse.app.common.validation.BaseValidator;
import com.rest.warehouse.app.common.validation.CommonValidatorUtils;
import com.rest.warehouse.app.dto.ShelfDto;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class ShelfDtoValidator implements BaseValidator<ShelfDto>{
    
    private static final String FIELD_CODE ="code";
    private final ShelfRepository shelfRepository;
    private final CommonValidatorUtils<ShelfDto, Shelf> commonValidatorUtils;
    
    @Autowired
    public ShelfDtoValidator(ShelfRepository shelfRepository, CommonValidatorUtils<ShelfDto, Shelf> commonValidatorUtils)
    {
        this.shelfRepository=shelfRepository;
        this.commonValidatorUtils=commonValidatorUtils;
    }
    
    @Override
    public void validate(ShelfDto obj)
    {
        validateUniqueCode(obj);
    }
    
    private void validateUniqueCode(ShelfDto shelfDto)
    {
        Shelf shelf = this.shelfRepository.findByCode(shelfDto.getCode()).orElse(null);
         if(shelf!=null)
         {
             this.commonValidatorUtils.validateUniqueField(FIELD_CODE, shelfDto, shelf );
         }
    }
    
    
    
}
