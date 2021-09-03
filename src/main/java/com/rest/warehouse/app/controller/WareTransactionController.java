/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.dto.WareTransactionDto;
import com.rest.warehouse.app.service.WareTransactionService;
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
@RequestMapping("ware-transactions")
public class WareTransactionController {
    
    private final WareTransactionService wareTransactionService;
    
    @Autowired
    public WareTransactionController(WareTransactionService wareTransactionService)
    {
        this.wareTransactionService = wareTransactionService;
    }
    
    @GetMapping("{id}")
    public WareTransactionDto findById(@PathVariable Long id)
    {
        return this.wareTransactionService.findById(id);
    }
    
    @GetMapping
    public List<WareTransactionDto> findAll()
    {
        return this.wareTransactionService.findAll();
    }
    
    @PostMapping
    public WareTransactionDto save(@RequestBody WareTransactionDto wareTransactionDto)
    {
        wareTransactionDto.setId(null);
        return this.wareTransactionService.save(wareTransactionDto);
        
    }
    
    @PutMapping
    public WareTransactionDto update(@RequestBody WareTransactionDto wareTransactionDto)
    {
        return this.wareTransactionService.save(wareTransactionDto);
    }
    
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long Id)
    {
        this.wareTransactionService.deleteById(Id);
        
    }
    
}
