/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service;

import com.rest.warehouse.app.dto.WarehouseDto;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface WarehouseService {
    WarehouseDto findById(Long id);
    List<WarehouseDto> findAll();
    WarehouseDto save(WarehouseDto warehouseDto);
    void deleteById(Long id);
    
}
