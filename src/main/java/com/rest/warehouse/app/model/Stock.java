/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import javax.annotation.concurrent.Immutable;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name ="stock")
@Data
@Immutable
public class Stock {
    @Id
    @Column(name="id")
    private String id;
    
    @Column(name="warehouse_id")
    private Long warehouseId;
    
    @Column(name="warehouse_description")
    private String warehouseDescription;
    
    @Column(name="shelf_id")
    private Long shelfId;
    
    @Column(name="shelf_code")
    private String shelfCode;
    
    @Column(name="product_id")
    private Long productId;
    
    @Column(name="product_code")
    private String productCode;
    
    @Column(name="total_quantity")
    private Long totalQuantity;
    
}
