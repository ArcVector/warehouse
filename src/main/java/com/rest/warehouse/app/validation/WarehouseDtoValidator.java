/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.validation;

import com.rest.warehouse.app.common.validation.BaseValidator;
import com.rest.warehouse.app.dto.ShelfDto;
import com.rest.warehouse.app.dto.WarehouseDto;
import com.rest.warehouse.app.exception.FieldNotUniqueException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class WarehouseDtoValidator implements BaseValidator<WarehouseDto>{
    
    private final ShelfDtoValidator shelfDtoValidator;
    
    @Autowired
    public WarehouseDtoValidator(ShelfDtoValidator shelfDtoValidator)
    {
        this.shelfDtoValidator = shelfDtoValidator;
        
    }
    @Override
    public void validate(WarehouseDto obj)
    {
        validateUniqueShelfCodes(obj.getShelves());
    }
    private void validateUniqueShelfCodes(List<ShelfDto> shelfDtos)
    {
        Set<String> uniqueCodes = new HashSet<String>();
        for(ShelfDto shelfDto : shelfDtos)
        {
            String code = shelfDto.getCode();
            if(uniqueCodes.contains(code))
                throw new FieldNotUniqueException(code);
            else
                shelfDtoValidator.validate(shelfDto);
                uniqueCodes.add(code);
            
        }
        
    }
}
