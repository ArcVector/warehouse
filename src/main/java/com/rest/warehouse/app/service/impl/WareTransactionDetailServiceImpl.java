/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service.impl;

import com.rest.warehouse.app.dto.WareTransactionDetailDto;
import com.rest.warehouse.app.exception.ResourceNotFoundException;
import com.rest.warehouse.app.model.WareTransactionDetail;
import com.rest.warehouse.app.repository.ProductRepository;
import com.rest.warehouse.app.repository.ShelfRepository;
import com.rest.warehouse.app.repository.WareTransactionDetailRepository;
import com.rest.warehouse.app.repository.WareTransactionRepository;
import com.rest.warehouse.app.service.WareTransactionDetailService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class WareTransactionDetailServiceImpl implements WareTransactionDetailService{
    
    private final WareTransactionDetailRepository wareTransactionDetailRepository;
    private final WareTransactionRepository wareTransactionRepository;
    private final ProductRepository productRepository;
    private final ShelfRepository shelfRepository;
    
    @Autowired
    public WareTransactionDetailServiceImpl(
    WareTransactionDetailRepository wareTransactionDetailRepository,
            WareTransactionRepository wareTransactionRepository,
            ProductRepository productRepository,
            ShelfRepository shelfRepository)
    {
        this.wareTransactionDetailRepository = wareTransactionDetailRepository;
        this.wareTransactionRepository = wareTransactionRepository;
        this.productRepository = productRepository;
        this.shelfRepository = shelfRepository;
    }
    @Override
    public WareTransactionDetailDto findById(Long id)
    {
        WareTransactionDetail wTxDetail = this.wareTransactionDetailRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        return new WareTransactionDetailDto(wTxDetail);
    }
    
    @Override
    public List<WareTransactionDetailDto> findByWareTransactionId(Long wareTransactionId)
    {
        return this.wareTransactionDetailRepository.findByWareTransactionId(wareTransactionId)
                .stream()
                .map(wTxDetail -> new WareTransactionDetailDto(wTxDetail))
                .collect(Collectors.toList());
    }
    
  
    
}
