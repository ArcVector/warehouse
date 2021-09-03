/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.controller;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.common.search.SearchRequest;
import com.rest.warehouse.app.common.utils.SearchUtils;
import com.rest.warehouse.app.dto.ProductDto;
import com.rest.warehouse.app.search.ProductSearchCriteria;
import com.rest.warehouse.app.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("products")
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
        
    }
    
    @GetMapping("{id}")
    public ProductDto findById(@PathVariable Long id)
    {
        return this.productService.findById(id);
    }
    
    @GetMapping
    public List<ProductDto> findAll()
    {
        return this.productService.findAll();
    }
    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto)
    {
        productDto.setId(null);
        return this.productService.save(productDto);
    }
    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto)
    {
        return this.productService.save(productDto);
    }
    
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id)
    {
        this.productService.deleteById(id);
        
    }
    @PostMapping("search")
    public Page<ProductDto> search(@RequestBody SearchRequest searchRequest)
    {
        ProductSearchCriteria criteria = SearchUtils.createSearchCriteria(searchRequest, ProductSearchCriteria.class);
        
        PageSearchResult<ProductDto> pageSearchResult = this.productService.search(criteria);
        return SearchUtils.pageOf(searchRequest, pageSearchResult);
    }
    
    
}
