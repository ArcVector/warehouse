/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
/**
 *
 * @author Administrator
 */
@Table(name="warehouse")
@Entity
@Data
public class Warehouse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="description")
    private String description;
    
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Shelf> shelves = new ArrayList<>();
    
    }
