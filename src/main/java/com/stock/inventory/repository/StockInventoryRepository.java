/**
 * 
 */
package com.stock.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.inventory.model.StockInventory;

/**
 * @author NCHHABR
 *
 */
@Repository
public interface StockInventoryRepository extends JpaRepository<StockInventory, Long>{

}
