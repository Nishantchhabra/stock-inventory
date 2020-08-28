/**
 * 
 */
package com.stock.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.stock.inventory.handler.RecordNotFoundException;
import com.stock.inventory.model.StockInventory;
import com.stock.inventory.repository.StockInventoryRepository;
import com.stock.inventory.service.StockInventoryService;

/**
 * @author NCHHABR
 *
 */
public class StockInventoryServiceImpl implements StockInventoryService {

	@Autowired
	private StockInventoryRepository stockrepo;

	@Override
	public void saveStockDetails(StockInventory stockInventory) {
		stockrepo.save(stockInventory);
	}

	@Override
	public List<StockInventory> getStockDetails() {
		return stockrepo.findAll();
	}

	@Override
	public Optional<StockInventory> getStockDetailById(Long stockNumber) {
		return stockrepo.findById(stockNumber);
	}

	@Override
	public StockInventory updateStockDetails(StockInventory stockInventory) {
		StockInventory stockDetail = stockrepo.findById(stockInventory.getStockNumber())
				.orElseThrow(() -> new RecordNotFoundException("No details found"));
		stockDetail.setPurchaseDate(stockInventory.getPurchaseDate());
		stockDetail.setPurchasePrice(stockInventory.getPurchasePrice());
		stockDetail.setQuantity(stockInventory.getQuantity());
		stockDetail.setStockName(stockInventory.getStockName());
		return stockrepo.save(stockDetail);
	}

	@Override
	public List<StockInventory> getStockDetails(String sortBy, String sortDirection) {
		List<StockInventory> inventories = null;
		switch (sortDirection) {
		case "ASC":
			inventories = stockrepo.findAll(Sort.by(sortBy).ascending());
			break;

		case "DESC":
			inventories = stockrepo.findAll(Sort.by(sortBy).descending());
			break;
			
		default:
			inventories = stockrepo.findAll();
			break;
		}

		return inventories;
	}

}
