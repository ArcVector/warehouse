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

@Entity
@Table(name ="stock_clerk")
@Data
public class StockClerk {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="registry_number")
    private String registryNumber;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
}
