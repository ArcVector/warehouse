/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service.impl;

import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.dto.ProductDto;
import com.rest.warehouse.app.exception.ResourceNotFoundException;
import com.rest.warehouse.app.model.Product;
import com.rest.warehouse.app.repository.ProductRepository;
import com.rest.warehouse.app.search.ProductSearchCriteria;
import com.rest.warehouse.app.service.ProductService;
import com.rest.warehouse.app.validation.ProductDtoValidator;
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
public class ProductServiceImpl implements ProductService{
    
    private final ProductRepository productRepository;
    private final ProductDtoValidator productDtoValidator;
    
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductDtoValidator productDtoValidator)
    {
        this.productRepository = productRepository;
        this.productDtoValidator = productDtoValidator;
    }
    
    @Override
    public ProductDto findById(Long id)
    {
        Product product = this.productRepository
                              .findById(id)
                              .orElseThrow(()-> new ResourceNotFoundException(id));
        return new ProductDto(product);
        
    }
    @Override
    public List<ProductDto> findAll()
    {
        return this.productRepository
                .findAll()
                .stream()
                .map(product -> new ProductDto(product))
                .collect(Collectors.toList());
    }
    
    @Override
    public ProductDto save(ProductDto productDto)
    {
        productDtoValidator.validate(productDto);
        Product product = this.dtoToEntity(productDto);
        Product savedProduct = this.productRepository.save(product);
        return new ProductDto(savedProduct);
        
    }
    
      @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
    @Override
    public PageSearchResult <ProductDto> search(ProductSearchCriteria criteria)
    {
        PageSearchResult<Product> page = this.productRepository.search(criteria);
        List<ProductDto> dtos = page
                .getPageData()
                .stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
        return new PageSearchResult<>(page.getTotalRows(), dtos);
    }
    
    private Product dtoToEntity(ProductDto productDto)
    {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
    
      
    
    
}
