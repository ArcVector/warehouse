/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.dto.ProductDto;
import com.rest.warehouse.app.search.ProductSearchCriteria;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ProductService {
    
    ProductDto findById(Long id);
    List<ProductDto> findAll();
    ProductDto save(ProductDto productDto);
    void deleteById(Long id);
    PageSearchResult<ProductDto> search(ProductSearchCriteria criteria);
    
}
