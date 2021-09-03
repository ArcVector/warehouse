/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.dto.StockClerkDto;
import com.rest.warehouse.app.service.StockClerkService;
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
@RequestMapping("clerks")
public class StockClerkController {
    
    private final StockClerkService stockClerkService;
    
    @Autowired
    public StockClerkController(StockClerkService stockClerkService)
    {
        this.stockClerkService = stockClerkService;
        
    }
    
    @GetMapping("{id}")
    public StockClerkDto findById(@PathVariable Long id)
    {
        return this.stockClerkService.findById(id);
        
    }
    
    @GetMapping
    public List<StockClerkDto> findAll()
    {
        return this.stockClerkService.findAll();
    }
    @PostMapping
    public StockClerkDto save(@RequestBody StockClerkDto stockClerkDto)
    {
        stockClerkDto.setId(null);
        return this.stockClerkService.save(stockClerkDto);
    }
    
    @PutMapping
    public StockClerkDto update(@RequestBody StockClerkDto stockClerkDto)
    {
        return this.stockClerkService.save(stockClerkDto);
    }
    
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id)
    {
        this.stockClerkService.deleteById(id);
    }
    
    
}
