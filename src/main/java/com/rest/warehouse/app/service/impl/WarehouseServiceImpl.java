/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service.impl;

import com.rest.warehouse.app.dto.ShelfDto;
import com.rest.warehouse.app.dto.WarehouseDto;
import com.rest.warehouse.app.exception.ResourceNotFoundException;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.Warehouse;
import com.rest.warehouse.app.repository.WarehouseRepository;
import com.rest.warehouse.app.service.WarehouseService;
import com.rest.warehouse.app.validation.WarehouseDtoValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class WarehouseServiceImpl implements WarehouseService{
    private final WarehouseRepository warehouseRepository;
    private final WarehouseDtoValidator warehouseValidator;
    
    @Autowired
    public WarehouseServiceImpl(
    WarehouseRepository warehouseRepository, WarehouseDtoValidator warehouseValidator)
    {
        this.warehouseRepository=warehouseRepository;
        this.warehouseValidator = warehouseValidator;
    }
    
    @Override
    public WarehouseDto findById(Long id)
    {
        Warehouse warehouse = this.warehouseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        return new WarehouseDto(warehouse);
    }
    @Override
    public List<WarehouseDto> findAll()
    {
        return this.warehouseRepository
                .findAll()
                .stream()
                .map(warehouse -> new WarehouseDto(warehouse))
                .collect(Collectors.toList());
        
    }
    @Override
    public WarehouseDto save(WarehouseDto warehouseDto)
    {
        this.warehouseValidator.validate(warehouseDto);
        Warehouse warehouse  = this.dtoToEntity(warehouseDto);
        Warehouse savedWarehouse = this.warehouseRepository.save(warehouse);
        return new WarehouseDto(savedWarehouse);
    }
    
    @Override
    public void deleteById(Long id)
    {
        this.warehouseRepository.deleteById(id);
    }
    
    private Warehouse dtoToEntity(WarehouseDto warehouseDto)
    {
        Warehouse warehouse = new Warehouse();
        List<Shelf> shelves = new ArrayList<>();
        BeanUtils.copyProperties(warehouseDto, warehouse, "shelves");
        
        List<ShelfDto> shelfDtos = warehouseDto.getShelves();
        if(shelfDtos!=null && shelfDtos.size()>0)
        {
            shelfDtos.forEach(shelfDto ->
            {
                
            
            Shelf shelf = new Shelf();
            BeanUtils.copyProperties(shelfDto, shelf);
            shelf.setWarehouse(warehouse);
            shelves.add(shelf);
        });
    }
        warehouse.setShelves(shelves);
        return warehouse;
    
}
}

