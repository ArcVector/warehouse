/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.repository;

import com.rest.warehouse.app.enums.WareTransactionType;
import com.rest.warehouse.app.model.WareTransactionDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Administrator
 */
public interface WareTransactionDetailRepository extends JpaRepository<WareTransactionDetail, Long> {
    List<WareTransactionDetail> findByWareTransactionId(Long wareTransactionId);
    
      @Query("SELECT SUM(detail.quantity) " +
            "FROM WareTransactionDetail detail " +
            "INNER JOIN WareTransaction tx ON detail.wareTransaction.id=tx.id " +
            "WHERE tx.wareTransactionType=:wareTransactionType " +
            "AND detail.product.id=:productId " +
            "AND detail.shelf.id=:shelfId")
      
      Optional<Long> findTotalQuantityByProductAndShelfAndWareTransactionType(
              @Param("productId") Long productId,
              @Param("shelfId") Long shelfId,
              @Param("wareTransactionType") WareTransactionType wareTransactionType);
      
}
