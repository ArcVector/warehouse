/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.projection;
import lombok.*;
/**
 *
 * @author Administrator
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockProjection {
    
    private String warehouseDescription;
    private String shelfCode;
    private String productCode;
    private Long totalQuantity;
    
}
