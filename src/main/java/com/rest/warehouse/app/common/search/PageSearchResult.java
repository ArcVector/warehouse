/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.common.search;
import java.util.List;
import lombok.*;
/**
 *
 * @author Administrator
 */
@Getter
@Setter
@AllArgsConstructor
public class PageSearchResult<T> {
    
    private long TotalRows;
    
    private List<T> pageData;
    
}
