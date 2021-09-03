/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.warehouse.app.service.impl;

import com.rest.warehouse.app.dto.ShelfDto;
import com.rest.warehouse.app.exception.ResourceNotFoundException;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.Warehouse;
import com.rest.warehouse.app.repository.ShelfRepository;
import com.rest.warehouse.app.repository.WarehouseRepository;
import com.rest.warehouse.app.service.ShelfService;
import com.rest.warehouse.app.validation.ShelfDtoValidator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class ShelfServiceImpl implements ShelfService{
    private final ShelfRepository shelfRepository;
    private final WarehouseRepository warehouseRepository;
    private final ShelfDtoValidator shelfValidator;
    
    @Autowired
    public ShelfServiceImpl(ShelfRepository shelfRepository,
            WarehouseRepository warehouseRepository, ShelfDtoValidator shelfValidator)
    {
        this.shelfRepository=shelfRepository;
        this.warehouseRepository=warehouseRepository;
        this.shelfValidator = shelfValidator;
    }
    
   @Override
   public ShelfDto findById(Long id)
   {
       Shelf shelf = this.shelfRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException(id));
       return new ShelfDto(shelf);
       
   }
   @Override
   public List<ShelfDto> findAll()
   {
       return this.shelfRepository.findAll()
               .stream()
               .map(shelf-> new ShelfDto(shelf))
               .collect(Collectors.toList());
   }
   
   @Override
   public ShelfDto save(ShelfDto shelfDto)
   {
       this.shelfValidator.validate(shelfDto);
       Shelf shelf = this.dtoToEntity(shelfDto);
       Shelf savedShelf = this.shelfRepository.save(shelf);
       return new ShelfDto(savedShelf);
   }
   
   @Override
   public void deleteById(Long id)
   {
       this.shelfRepository.deleteById(id);
   }
   
   private Shelf dtoToEntity(ShelfDto shelfDto)
   {
       Shelf shelf = new Shelf();
       BeanUtils.copyProperties(shelfDto, shelf);
       Long warehouseId = shelfDto.getWarehouseId();
       if(warehouseId!=null)
       {
          Warehouse warehouse = this.warehouseRepository
                    .findById(warehouseId)
                    .orElse(null);
           if(warehouse!=null)
           {
               shelf.setWarehouse(warehouse);
           }
       }
       return shelf;
       
   }
    
}
