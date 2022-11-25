package com.isga.nacer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpCatalogueApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TpCatalogueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MicroService Catalogue running with success");
	}

}
