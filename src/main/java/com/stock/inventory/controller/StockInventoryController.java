package com.stock.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stock.inventory.model.StockInventory;
import com.stock.inventory.service.StockInventoryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class StockInventoryController {

	@Autowired
	private StockInventoryService inventoryService;

	private static final Logger logger = LoggerFactory.getLogger(StockInventoryController.class);

	@PostMapping("save/stock")
	public ResponseEntity<Object> saveStock(@RequestBody StockInventory stockInventory) {
		logger.info("started saving checklist");

		try {
			inventoryService.saveStockDetails(stockInventory);
		} catch (Exception e) {
			logger.debug("error while saving  stock ", e);
			return new ResponseEntity<>("error while saving  checklist " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("finished saving details");
		return new ResponseEntity<>("saved successfully", HttpStatus.OK);
	}
	
	@GetMapping("get/stock")
	public ResponseEntity<Object> getStock(@RequestParam String sortBy, @RequestParam String sortDirection) {
		logger.info("started saving checklist");
		List<StockInventory> stockInventory = null;
		try {
			if(sortBy.isEmpty() || sortDirection.isEmpty()) {
			stockInventory = inventoryService.getStockDetails();
			}
			else {
				stockInventory = inventoryService.getStockDetails(sortBy,sortDirection);
			}
		} catch (Exception e) {
			logger.debug("error while saving  stock ", e);
			return new ResponseEntity<>("error while saving  checklist " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("finished saving details");
		return new ResponseEntity<>(stockInventory, HttpStatus.OK);
	}
	
	@GetMapping("get/stock/{stockNumber}")
	public ResponseEntity<Object> getStockById(@PathVariable Long stockNumber) {
		logger.info("started saving checklist");
		Optional<StockInventory> stockInventory = null;
		try {
			stockInventory = inventoryService.getStockDetailById(stockNumber);
		} catch (Exception e) {
			logger.debug("error while saving  stock ", e);
			return new ResponseEntity<>("error while saving  checklist " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("finished saving details");
		return new ResponseEntity<>(stockInventory, HttpStatus.OK);
	}
	
	@PutMapping("update/stock")
	public ResponseEntity<Object> updateStock(@RequestBody StockInventory stockInventory) {
		logger.info("started saving checklist");
		StockInventory inventory =null;
		try {
			inventory=inventoryService.updateStockDetails(stockInventory);
		} catch (Exception e) {
			logger.debug("error while saving  stock ", e);
			return new ResponseEntity<>("error while saving  checklist " + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("finished saving details");
		return new ResponseEntity<>(inventory, HttpStatus.OK);
	}
	

}
