/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.Warehouse;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
public class WarehouseDto {
    
    private Long id;
    private String description;
    private List<ShelfDto> shelves = new ArrayList<>();
    
    public WarehouseDto(Warehouse warehouse)
    {
        BeanUtils.copyProperties(warehouse, this, "shelves");
        List<Shelf> shelves = warehouse.getShelves();
        if(shelves!=null && shelves.size()>0)
        {
            shelves.forEach(shelf ->
            {
                ShelfDto shelfDto = new ShelfDto(shelf);
                this.shelves.add(shelfDto);
            });
        }
    }
}
