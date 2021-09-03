/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.common.search.SearchRequest;
import com.rest.warehouse.app.common.utils.SearchUtils;
import com.rest.warehouse.app.dto.StockDto;
import com.rest.warehouse.app.projection.StockProjection;
import com.rest.warehouse.app.search.StockSearchCriteria;
import com.rest.warehouse.app.service.StockService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("stock")
public class StockController {
    private final StockService stockService;
    
    @Autowired
    public StockController(StockService stockService)
    {
        this.stockService = stockService;
        
    }
    
    @GetMapping("snapshot")
    public List<StockProjection> findStockByProductAndDateTime(@RequestParam String productCode, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")LocalDateTime date)
    {
        return this.stockService.findStockByProductAndDate(productCode, date);
    }
    @GetMapping
    public List<StockDto> findAll()
    {
        return this.stockService.findAll();
        
    }
    
    @PostMapping("search")
    public Page<StockDto> search(@RequestBody SearchRequest searchRequest)
    {
        StockSearchCriteria criteria = SearchUtils.createSearchCriteria(searchRequest, StockSearchCriteria.class);
        PageSearchResult<StockDto> pageSearchResult = this.stockService.search(criteria);
        return SearchUtils.pageOf(searchRequest, pageSearchResult);
        
    }
    
}
