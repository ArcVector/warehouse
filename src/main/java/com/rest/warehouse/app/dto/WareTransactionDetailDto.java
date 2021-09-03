/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.rest.warehouse.app.model.Product;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.WareTransaction;
import com.rest.warehouse.app.model.WareTransactionDetail;
import lombok.*;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
public class WareTransactionDetailDto {
    
    private Long id;
    private Long wareTransactionId;
    private Long productId;
    private Long shelfId;
    private Long quantity;
    
    public WareTransactionDetailDto(WareTransactionDetail wareTransactionDetails)
    {
        BeanUtils.copyProperties(wareTransactionDetails, this);
        WareTransaction wareTransaction = wareTransactionDetails.getWareTransaction();
        
        if(wareTransaction!=null)
        {
            this.wareTransactionId = wareTransaction.getId();
        }
        
        Product product = wareTransactionDetails.getProduct();
        if(product!=null)
        {
            this.productId = product.getId();
        }
        
        Shelf shelf = wareTransactionDetails.getShelf();
        if(shelf!=null)
        {
            this.shelfId = shelf.getId();
        }
        
    }
}
