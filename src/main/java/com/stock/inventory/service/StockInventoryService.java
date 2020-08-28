/**
 * 
 */
package com.stock.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stock.inventory.model.StockInventory;

/**
 * @author NCHHABR
 *
 */
@Service
public interface StockInventoryService {

	void saveStockDetails(StockInventory stockInventory);

	List<StockInventory> getStockDetails();

	Optional<StockInventory> getStockDetailById(Long stockNumber);

	StockInventory updateStockDetails(StockInventory stockInventory);

	List<StockInventory> getStockDetails(String sortBy, String sortDirection);
	
}
