/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.repository;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.model.Product;
import com.rest.warehouse.app.search.ProductSearchCriteria;

/**
 *
 * @author Administrator
 */

public interface ProductRepositoryCustom {
    
    PageSearchResult<Product> search(ProductSearchCriteria criteria);
    
}
