/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.rest.warehouse.app.enums.MeasurementUnit;
import com.rest.warehouse.app.model.Product;
import lombok.*;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    
    private Long id;
    private String code;
    private String description;
    private MeasurementUnit measurementUnit;
    
    public ProductDto(Product product)
    {
        BeanUtils.copyProperties(product, this);
    }
}
