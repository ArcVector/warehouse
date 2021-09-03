/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service.impl;

import com.rest.warehouse.app.dto.StockClerkDto;
import com.rest.warehouse.app.exception.ResourceNotFoundException;
import com.rest.warehouse.app.model.StockClerk;
import com.rest.warehouse.app.repository.StockClerkRepository;
import com.rest.warehouse.app.service.StockClerkService;
import com.rest.warehouse.app.validation.StockClerkDtoValidator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class StockClerkServiceImpl implements StockClerkService{
    private final StockClerkRepository stockClerkRepository;
    private final StockClerkDtoValidator stockClerkValidator;
    
    @Autowired
    public StockClerkServiceImpl(
    StockClerkRepository stockClerkRepository, StockClerkDtoValidator stockClerkValidator)
    {
        this.stockClerkRepository = stockClerkRepository;
        this.stockClerkValidator = stockClerkValidator;
    }
    @Override
    public StockClerkDto findById(Long id)
    {
        StockClerk stockClerk = this.stockClerkRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        
        return new StockClerkDto(stockClerk);
    }
    
    @Override
    public List<StockClerkDto> findAll()
    {
        return this.stockClerkRepository
                .findAll()
                .stream()
                .map(stockClerk -> new StockClerkDto(stockClerk))
                .collect(Collectors.toList());
    }
    
    @Override
    public StockClerkDto save(StockClerkDto stockClerkDto)
    {
        this.stockClerkValidator.validate(stockClerkDto);
        StockClerk stockClerk = this.dtoToEntity(stockClerkDto);
        return new StockClerkDto(this.stockClerkRepository.save(stockClerk));
    }
    @Override
    public void deleteById(Long id)
    {
        this.stockClerkRepository.deleteById(id);
    }
    
    private StockClerk dtoToEntity(StockClerkDto stockClerkDto)
    {
        StockClerk stockClerk = new StockClerk();
        BeanUtils.copyProperties(stockClerkDto, stockClerk);
        return stockClerk;
        
        
    }
}
