/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.model;
import com.rest.warehouse.app.enums.WareTransactionType;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
/**
 *
 * @author Administrator
 */
@Data
@Entity
@Table(name="ware_transaction")
public class WareTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name ="ware_transaction_type")
    private WareTransactionType wareTransactionType;
    
    @Column(name="description")
    private String description;
    
    @Column(name="transaction_date")
    private LocalDateTime transactionDate;
    
    @OneToOne
    @JoinColumn(name ="stock_clerk_id")
    private StockClerk stockClerk;
    
    @OneToMany(mappedBy="wareTransaction", cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
    List<WareTransactionDetail> wareTransactionDetails;
    
    }
