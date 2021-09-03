/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service;

import com.rest.warehouse.app.dto.ShelfDto;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ShelfService {
    
    ShelfDto findById(Long id);
    List<ShelfDto> findAll();
    ShelfDto save(ShelfDto shelfDto);
    void deleteById(Long id);
    
}
