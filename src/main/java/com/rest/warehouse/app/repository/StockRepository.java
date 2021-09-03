/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.repository;

import com.rest.warehouse.app.model.Stock;
import com.rest.warehouse.app.projection.StockProjection;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>, StockRepositoryCustom{
    
    @Query("SELECT NEW app.projection.StockProjection(" +
            "wh.description, " +
            "shelf.code, " +
            "product.code, " +
            "SUM(CASE WHEN tx.wareTransactionType='IMPORT' " +
            "THEN detail.quantity " +
            "ELSE -detail.quantity END)) " +
            "FROM WareTransactionDetail detail " +
            "INNER JOIN WareTransaction tx ON detail.wareTransaction.id=tx.id " +
            "INNER JOIN Product product ON detail.product.id=product.id " +
            "INNER JOIN Shelf shelf ON detail.shelf.id=shelf.id " +
            "INNER JOIN Warehouse wh ON shelf.warehouse.id=wh.id " +
            "WHERE product.code=:productCode AND tx.transactionDate<=:date " +
            "GROUP BY wh.description, shelf.code, product.code ")
    List<StockProjection> findStockByProductAndDate(@Param("productCode") String productCode, @Param("date") LocalDateTime date);
}
