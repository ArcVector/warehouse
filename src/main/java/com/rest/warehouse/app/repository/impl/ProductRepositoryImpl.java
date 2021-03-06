/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.repository.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.common.search.QueryExecutor;
import com.rest.warehouse.app.common.utils.SearchUtils;
import com.rest.warehouse.app.enums.MeasurementUnit;
import com.rest.warehouse.app.model.Product;
import com.rest.warehouse.app.repository.ProductRepositoryCustom;
import com.rest.warehouse.app.search.ProductSearchCriteria;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import target.model.QProduct;

/**
 *
 * @author Administrator
 */
public class ProductRepositoryImpl extends QueryExecutor implements ProductRepositoryCustom {
    
    private static final QProduct qProduct = QProduct.product;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public PageSearchResult<Product> search(ProductSearchCriteria criteria)
    {
        JPAQuery<Product> query  = new JPAQuery<Product> (entityManager)
                .from(qProduct)
                .where(predicateOf(criteria))
                .orderBy(SearchUtils.orderSpecifierOf(criteria, orderMap(), ProductSearchCriteria.DEFAULT_ORDER_BY));
        
        return super.executeQuery(criteria, query);
    }
    
    private Predicate predicateOf(ProductSearchCriteria criteria)
    {
        BooleanBuilder predicate = new BooleanBuilder();
        
        Long id = criteria.getId();
        if(id!=null)
            predicate.and(qProduct.id.eq(criteria.getId()));
        String code = criteria.getCode();
        if(StringUtils.isNotBlank(code))
            predicate.and(qProduct.code.containsIgnoreCase(code));
        
        MeasurementUnit measurementUnit = criteria.getMeasurementUnit();
        if(measurementUnit!=null)
            predicate.and(qProduct.measurementUnit.eq(measurementUnit));
        
        String description = criteria.getDescription();
        if(StringUtils.isNotBlank(description))
            predicate.and(qProduct.description.containsIgnoreCase(description));
        
        return predicate;
        
        
    }
    
    private HashMap<String, Path> orderMap()
    {
        HashMap<String, Path> map = new HashMap<>();
        map.put(ProductSearchCriteria.ORDER_BY_ID, qProduct.id);
        map.put(ProductSearchCriteria.ORDER_BY_CODE, qProduct.code);
        map.put(ProductSearchCriteria.ORDER_BY_MEASUREMENT_UNIT, qProduct.measurementUnit);
        
        return map;
       
    }
    
}
