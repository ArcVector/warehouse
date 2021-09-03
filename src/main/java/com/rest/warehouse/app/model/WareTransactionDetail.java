/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.model;
import javax.persistence.*;
import lombok.Data;
/**
 *
 * @author Administrator
 */
@Data
@Entity
@Table(name="ware_transaction_detail")
public class WareTransactionDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="ware_transaction_id")
    private WareTransaction wareTransaction;
    
    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;
    
    @OneToOne
    @JoinColumn(name="shelf_id")
    private Shelf shelf;
    
    @Column(name="quantity")
    private Long quantity;
    
    
}
