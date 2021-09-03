/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.repository;

import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.StockClerk;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface StockClerkRepository extends JpaRepository<StockClerk, Long> {
      Optional<StockClerk> findByRegistryNumber(String registryNumber);;
    
}
