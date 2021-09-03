/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.search;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@ToString
public class BaseSearchCriteria {
    
    private int pageIndex;
    private int pageSize;
    private String orderBy;
    private Boolean orderAsc;
    private Boolean paginated;
    
}
