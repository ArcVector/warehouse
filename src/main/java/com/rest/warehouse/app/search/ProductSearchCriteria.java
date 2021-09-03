/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.search;

import com.rest.warehouse.app.common.search.BaseSearchCriteria;
import com.rest.warehouse.app.enums.MeasurementUnit;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class ProductSearchCriteria extends BaseSearchCriteria{
    public static final String ORDER_BY_ID ="id";
    public static final String ORDER_BY_CODE ="code";
    public static final String ORDER_BY_MEASUREMENT_UNIT  ="measurementUnit";
    
    public static final String DEFAULT_ORDER_BY =ORDER_BY_ID;
    
    private Long id;
    private String code;
    private String description;
    private MeasurementUnit measurementUnit;
    
    
}
