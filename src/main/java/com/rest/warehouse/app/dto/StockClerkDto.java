/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.rest.warehouse.app.model.StockClerk;
import lombok.*;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
public class StockClerkDto {
    
    private Long id;
    private String registryNumber;
    private String firstName;
    private String lastName;
    
    public StockClerkDto(StockClerk stockClerk)
    {
        BeanUtils.copyProperties(stockClerk, this);
        
    }
}
