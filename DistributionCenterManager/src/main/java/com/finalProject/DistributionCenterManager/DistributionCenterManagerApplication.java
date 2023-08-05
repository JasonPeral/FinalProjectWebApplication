package com.finalProject.DistributionCenterManager;

import com.finalProject.DistributionCenterManager.models.Store;
import com.finalProject.DistributionCenterManager.models.enums.Brand;
import com.finalProject.DistributionCenterManager.repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DistributionCenterManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributionCenterManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(StoreRepository storeRepository){
		return args -> {
			storeRepository.save(Store.builder()
					.name("Best Value Mart")
					.location("Toronto")
					.yearOfCreation(2023)
					.brand(Brand.BALENCIAGE)
					.build());
			storeRepository.save(Store.builder()
					.name("Sunny's Boutique")
					.location("Toronto")
					.yearOfCreation(2023)
					.brand(Brand.BALENCIAGE)
					.build());


			storeRepository.save(Store.builder()
					.name("Fresh Breeze Grocers")
					.location("Toronto")
					.yearOfCreation(2023)
					.brand(Brand.BALENCIAGE)
					.build());
			storeRepository.save(Store.builder()
					.name("Parkside Books")
					.location("Toronto")
					.yearOfCreation(2023)
					.brand(Brand.BALENCIAGE)
					.build());
			storeRepository.save(Store.builder()
					.name("Lavish Luxury Linens")
					.location("Toronto")
					.yearOfCreation(2023)
					.brand(Brand.BALENCIAGE)
					.build());
//			Gadget Galaxy
			storeRepository.save(Store.builder()
					.name("Gadget Galaxy")
					.location("Mississauga")
					.yearOfCreation(2023)
					.brand(Brand.DIOR)
					.build());
			storeRepository.save(Store.builder()
					.name("Timber and Twine Home Goods")
					.location("Mississauga")
					.yearOfCreation(2023)
					.brand(Brand.DIOR)
					.build());
			storeRepository.save(Store.builder()
					.name("Bountiful Bakery")
					.location("Mississauga")
					.yearOfCreation(2023)
					.brand(Brand.DIOR)
					.build());
			storeRepository.save(Store.builder()
					.name("Pet Paradise Supplies")
					.location("Mississauga")
					.yearOfCreation(2023)
					.brand(Brand.DIOR)
					.build());

		};


	}

}
