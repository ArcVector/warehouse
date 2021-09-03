/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.search;

import com.rest.warehouse.app.common.search.BaseSearchCriteria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@NoArgsConstructor
public class StockSearchCriteria extends BaseSearchCriteria{
    
    
    public static final String ORDER_BY_WAREHOUSE_ID  ="warehouseId";
    public static final String ORDER_BY_WAREHOUSE_DESCRIPTION = "warehouseDescription";
    public static final String ORDER_BY_SHELF_ID ="shelfId";
    public static final String ORDER_BY_SHELF_CODE ="shelfCode";
    public static final String ORDER_BY_PRODUCT_ID="productId";
    public static final String ORDER_BY_PRODUCT_CODE="productCode";
    
    public static final String DEFAULT_ORDER_BY = ORDER_BY_WAREHOUSE_ID;
    
    private Long warehouseId;
    private String warehouseDescription;
    
    private Long shelfId;
    private String shelfCode;
    
    private Long productId;
    private String productCode;
    
}
