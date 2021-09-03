/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rest.warehouse.app.enums.WareTransactionType;
import com.rest.warehouse.app.model.StockClerk;
import com.rest.warehouse.app.model.WareTransaction;
import com.rest.warehouse.app.model.WareTransactionDetail;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.springframework.beans.BeanUtils;
/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
public class WareTransactionDto {
    
    private Long id;
    private WareTransactionType wareTransactionType;
    private String description;
    
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactionDate;
    
    private Long stockClerkId;
    private List<WareTransactionDetailDto> wareTransactionDetails = new ArrayList<>();
    
    public WareTransactionDto(WareTransaction wareTransaction)
    {
        BeanUtils.copyProperties(wareTransaction, this, "wareTransactionDetails");
        StockClerk stockClerk = wareTransaction.getStockClerk();
        
        if(stockClerk!=null)
        {
            this.stockClerkId = stockClerk.getId();
        }
        List<WareTransactionDetail> wareTransactionDetails = wareTransaction.getWareTransactionDetails();
        if(wareTransactionDetails != null && wareTransactionDetails.size()>0)
        {
            wareTransactionDetails.forEach(wTxDetails->{
                this.wareTransactionDetails.add(new WareTransactionDetailDto(wTxDetails));
            });
        }
        
        
    }
    
    
}
