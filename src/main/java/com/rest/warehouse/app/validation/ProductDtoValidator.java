/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.validation;

import com.rest.warehouse.app.common.validation.BaseValidator;
import com.rest.warehouse.app.common.validation.CommonValidatorUtils;
import com.rest.warehouse.app.dto.ProductDto;
import com.rest.warehouse.app.model.Product;
import com.rest.warehouse.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class ProductDtoValidator implements BaseValidator<ProductDto>{
    
    private static final String FIELD_CODE ="code";
    
    private final ProductRepository productRepository;
    private final CommonValidatorUtils<ProductDto, Product> commonValidatorUtils;
    
     @Autowired
    public ProductDtoValidator(
            ProductRepository productRepository,
            CommonValidatorUtils commonValidatorUtils) {
        this.productRepository = productRepository;
        this.commonValidatorUtils = commonValidatorUtils;
    }
    
    @Override
    public void validate(ProductDto obj)
    {
        validateUniqueCode(obj);
    }
    
    private void validateUniqueCode(ProductDto productDto)
    {
        Product product = this.productRepository.findByCode(productDto.getCode())
                                                 .orElse(null);
        if(product != null)
        {
            commonValidatorUtils.validateUniqueField(FIELD_CODE, productDto, product);
            
        }
    }
    

    
}
