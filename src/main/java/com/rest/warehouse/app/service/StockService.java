/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.dto.StockDto;
import com.rest.warehouse.app.projection.StockProjection;
import com.rest.warehouse.app.search.StockSearchCriteria;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface StockService {
    
    List<StockProjection> findStockByProductAndDate(String productCode, LocalDateTime date);
    List<StockDto> findAll();
    PageSearchResult<StockDto> search(StockSearchCriteria criteria);
    
    
}
