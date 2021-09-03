/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service.impl;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.dto.StockDto;
import com.rest.warehouse.app.model.Stock;
import com.rest.warehouse.app.projection.StockProjection;
import com.rest.warehouse.app.repository.StockRepository;
import com.rest.warehouse.app.search.StockSearchCriteria;
import com.rest.warehouse.app.service.StockService;
import java.time.LocalDateTime;
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
public class StockServiceImpl implements StockService{
    private final StockRepository stockRepository;
    
    @Autowired
    public StockServiceImpl(StockRepository stockRepository)
    {
        this.stockRepository = stockRepository;
        
    }
    @Override
    public List<StockProjection> findStockByProductAndDate(String productCode, LocalDateTime date)
    {
        return this.stockRepository.findStockByProductAndDate(productCode, date);
    }
    @Override
    public List<StockDto> findAll()
    {
        return this.stockRepository.findAll()
                .stream()
                .map(StockDto::new)
                .collect(Collectors.toList());
    }
    
    @Override
    public PageSearchResult<StockDto> search(StockSearchCriteria criteria)
    {
        PageSearchResult<Stock> page = this.stockRepository.search(criteria);
        List<StockDto> dtos = page.getPageData()
                .stream()
                .map(StockDto::new)
                .collect(Collectors.toList());
        return new PageSearchResult<>(page.getTotalRows(), dtos);
    }
    
    private Stock dtoToEntity(StockDto stockDto)
    {
        Stock stock = new Stock();
        BeanUtils.copyProperties(stockDto, stock);
        return stock;
        
    }
}
