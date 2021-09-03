/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.utils;


import static com.fasterxml.jackson.annotation.JsonFormat.Shape.BOOLEAN;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.rest.warehouse.app.common.search.BaseSearchCriteria;
import com.rest.warehouse.app.common.search.PageSearchResult;
import com.rest.warehouse.app.common.search.SearchRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Administrator
 */
public class SearchUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(SearchUtils.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
     public static <T extends BaseSearchCriteria> T createSearchCriteria(SearchRequest searchRequest, Class<T> searchCriteriaClass) {
        String searchCriteriaString = StringUtils.isNotBlank(searchRequest.getSearchCriteriaString())
                ? searchRequest.getSearchCriteriaString()
                : "{}";
        
        T searchCriteria = JsonUtils.parse(searchCriteriaString, searchCriteriaClass);
        
        searchCriteria.setPageIndex(searchRequest.getPageIndex()-1);
        searchCriteria.setPageSize(searchRequest.getPageSize());
        searchCriteria.setOrderBy(searchRequest.getOrderBy());
        searchCriteria.setOrderAsc(searchRequest.getOrderAsc());
        searchCriteria.setPaginated(searchRequest.getPaginated());
        return searchCriteria;
    }
     
     public static Pageable pageableOf(SearchRequest searchRequest)
     {
         int pageIndex = searchRequest.getPageIndex();
         int rowsSize = searchRequest.getPageSize();
         String orderBy = searchRequest.getOrderBy();
         Sort.Direction orderDirection = (searchRequest.getOrderAsc() != null) && (searchRequest.getOrderAsc().equals(Boolean.TRUE))
                ? Sort.Direction.ASC
                : Sort.Direction.DESC;
        return PageRequest.of(pageIndex, rowsSize, orderDirection, orderBy);
     }
     
     public static<T> Page<T> pageOf(SearchRequest searchRequest, PageSearchResult<T> searchResult)
     {
         List<T> data = searchResult.getPageData();
         Pageable pageable = pageableOf(searchRequest);
         long totalRows = searchResult.getTotalRows();
         
         return new PageImpl<>(data, pageable, totalRows);
     }
     public static OrderSpecifier<?> orderSpecifierOf(BaseSearchCriteria criteria, HashMap<String, Path> orderMap, String defaultOrderBy)
     {
         Order orderDirection = (criteria.getOrderAsc()==null) || (criteria.getOrderAsc().equals(Boolean.TRUE))
                 ? Order.ASC
                 : Order.DESC;
         if(StringUtils.isBlank(criteria.getOrderBy()) && criteria.getOrderBy()==null)
         {
             criteria.setOrderBy(defaultOrderBy);
             
         }
         Path orderPath = null;
         for(Map.Entry entry : orderMap.entrySet())
         {
             if(entry.getKey().equals(criteria.getOrderBy()))
             {
                 orderPath = (Path) entry.getValue();
             }
         }
         return new OrderSpecifier(orderDirection, orderPath);
     }
    
}
