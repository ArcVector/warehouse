/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service;

import com.rest.warehouse.app.dto.StockClerkDto;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface StockClerkService {
    
    StockClerkDto findById(Long id);
    List<StockClerkDto> findAll();
    StockClerkDto save(StockClerkDto stockClerkDto);
    void deleteById(Long id);
    
}
