/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.model;

import com.rest.warehouse.app.enums.MeasurementUnit;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name ="product")
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name ="code")
    private String code;
    
    @Column(name ="description")
    private String description;
            
    @Enumerated(EnumType.STRING)
    @Column(name = "measurement_unit")
    private MeasurementUnit measurementUnit;
}
