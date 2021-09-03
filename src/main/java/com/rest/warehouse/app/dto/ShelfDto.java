/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.Warehouse;
import lombok.*;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor

public class ShelfDto {
    
    private Long id;
    private String code;
    private Long warehouseId;
    
    public ShelfDto(Shelf shelf)
    {
        BeanUtils.copyProperties(shelf, this, "warehouseId");
        Warehouse warehouse = shelf.getWarehouse();
        if(warehouse!=null)
        {
            this.warehouseId = warehouse.getId();
            
        }
    }
}
