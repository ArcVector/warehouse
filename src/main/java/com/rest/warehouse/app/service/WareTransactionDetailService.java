/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service;

import com.rest.warehouse.app.dto.WareTransactionDetailDto;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface WareTransactionDetailService {
    
    WareTransactionDetailDto findById(Long id);
    List<WareTransactionDetailDto> findByWareTransactionId(Long wareTransactionId);
    
}
