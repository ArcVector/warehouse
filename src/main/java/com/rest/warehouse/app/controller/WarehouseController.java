/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.dto.WarehouseDto;
import com.rest.warehouse.app.service.WarehouseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("warehouses")
public class WarehouseController {
    
    private final WarehouseService warehouseService;
    
    @Autowired
    public WarehouseController(WarehouseService warehouseService)
    {
        this.warehouseService = warehouseService;
    }
    
    @GetMapping("{id}")
    public WarehouseDto findById(@PathVariable Long id)
    {
        return this.warehouseService.findById(id);
    }
    @GetMapping
    public List<WarehouseDto> findAll()
    {
        return this.warehouseService.findAll();
        
    }
    
    @PostMapping
    public WarehouseDto save(@RequestBody WarehouseDto warehouseDto)
    {
        warehouseDto.setId(null);
        return this.warehouseService.save(warehouseDto);
    }
    
    @PutMapping
    public WarehouseDto update(@RequestBody WarehouseDto warehouseDto)
    {
        return this.warehouseService.save(warehouseDto);
    }
    
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id)
    {
        this.warehouseService.deleteById(id);
    }
    
    
}
