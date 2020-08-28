/**
 * 
 */
package com.stock.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author NCHHABR
 *
 */
@Entity
@Table(name = "artics_table")
public class StockInventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stock_number")
	private Long stockNumber;
	
	@Column(name="stock_name")
	private String stockName;
	
	@Column(name="purchase_price")
	private Long purchasePrice;
	
	@Column(name="purchase_date")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date purchaseDate;
	
	@Column(name="quantity")
	private Long quantity;
	
	private String sortBy;
	
	private String sortDirection;
	
	
	
	

	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * @return the sortDirection
	 */
	public String getSortDirection() {
		return sortDirection;
	}

	/**
	 * @param sortDirection the sortDirection to set
	 */
	public void setSortDirection(String sortDirection) {
		this.sortDirection = sortDirection;
	}

	/**
	 * @return the stockNumber
	 */
	public Long getStockNumber() {
		return stockNumber;
	}

	/**
	 * @param stockNumber the stockNumber to set
	 */
	public void setStockNumber(Long stockNumber) {
		this.stockNumber = stockNumber;
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * @param stockName the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * @return the purchasePrice
	 */
	public Long getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * @param purchasePrice the purchasePrice to set
	 */
	public void setPurchasePrice(Long purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
