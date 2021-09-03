/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.repository;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.model.Stock;
import com.rest.warehouse.app.search.StockSearchCriteria;

/**
 *
 * @author Administrator
 */
public interface StockRepositoryCustom {
    
    PageSearchResult<Stock> search(StockSearchCriteria criteria);
    
}
