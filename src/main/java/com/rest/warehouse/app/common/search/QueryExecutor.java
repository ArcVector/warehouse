/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.search;
import com.querydsl.jpa.impl.JPAQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.*;
/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class QueryExecutor {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public<T, U> PageSearchResult<T> executeQuery(BaseSearchCriteria criteria, JPAQuery<T> query)
    {
        long totalRows = query.fetchCount();
        
        int pageIndex = criteria.getPageIndex();
        int pageSize = criteria.getPageSize();
        
        long offset = (long) pageIndex*pageSize;
        
        List<T> pageData = query
                .offset(offset)
                .limit(pageSize)
                .fetch();
        
        return new PageSearchResult<>(totalRows, pageData);
        
    }
    
}
