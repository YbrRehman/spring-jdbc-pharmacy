package com.pharmacystore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pharmacystore.model.Drugs;
import com.pharmacystore.service.IDrugService;

@SpringBootApplication
public class SpringJdbcPharmacyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcPharmacyApplication.class, args);
	}
	
	@Autowired
	IDrugService iDrugService;

	@Override
	public void run(String... args) throws Exception {
		//iDrugService.addDrug(new Drugs("Moove","painkiller",2,"skin"));
		//iDrugService.getall().forEach(System.out::println);
		iDrugService.getByCategory("painkiller").forEach(System.out::println);
		
	}

}
