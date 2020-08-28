package com.stock.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.daimler.inventory"})
public class StockInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockInventoryApplication.class, args);
	}

}
