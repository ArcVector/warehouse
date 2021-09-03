/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.rest.warehouse.app.model.Stock;
import lombok.Data;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
        @Data
public class StockDto {
    
            private String id;
            private Long warehouseId;
            private String warehouseDescription;
            private  Long shelfId;
            private  String shelfCode;
            private Long productId;
            private String productCode;
            private Long totalQuantity;
            
            public StockDto(Stock stock)
            {
                BeanUtils.copyProperties(stock, this);
            }
}
