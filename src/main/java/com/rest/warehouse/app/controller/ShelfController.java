/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.dto.ShelfDto;
import com.rest.warehouse.app.service.ShelfService;
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
@RequestMapping("shelves")
public class ShelfController {
    private final ShelfService shelfService;
    
    @Autowired
    public ShelfController(ShelfService shelfService)
    {
        this.shelfService = shelfService;
        
    }
    
    @GetMapping("{id}")
    public ShelfDto findById(@PathVariable Long id)
    {
        return this.shelfService.findById(id);
    }
    @GetMapping
    public List<ShelfDto> findAll()
    {
        return this.shelfService.findAll();
    }
    @PostMapping
    public ShelfDto save(@RequestBody ShelfDto shelfDto)
    {
        shelfDto.setId(null);
        return this.shelfService.save(shelfDto);
    }
    
    @PutMapping
    public ShelfDto update(@RequestBody ShelfDto shelfDto)
    {
        return this.shelfService.save(shelfDto);
    }
    
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id)
    {
        this.shelfService.deleteById(id);
    }
}
