/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.dto.WareTransactionDetailDto;
import com.rest.warehouse.app.service.WareTransactionDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("ware-transaction-details")
public class WareTransactionDetailController {
    
    private final WareTransactionDetailService wareTransactionDetailService;
    
    @Autowired
    public WareTransactionDetailController(WareTransactionDetailService wareTransactionDetailService)
    {
        this.wareTransactionDetailService = wareTransactionDetailService;
        
    }
    
    @GetMapping("{id}")
    public WareTransactionDetailDto findById(@PathVariable Long id)
    {
        return this.wareTransactionDetailService.findById(id);
    }
    
    @GetMapping
    public List<WareTransactionDetailDto> findByWareTransactionId(@RequestParam Long wareTransactionId)
    {
        return this.wareTransactionDetailService.findByWareTransactionId(wareTransactionId);
    }
    
    
    
    
}
