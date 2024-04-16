package com.msecxercise.inventoryservice;

import com.msecxercise.inventoryservice.model.Inventory;
import com.msecxercise.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("Arepa");
			inventory.setQuantity(1000);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Arepa_amarilla");
			inventory1.setQuantity(1000);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("Arepa_chocolo");
			inventory2.setQuantity(0);
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);

		};
	}
}
