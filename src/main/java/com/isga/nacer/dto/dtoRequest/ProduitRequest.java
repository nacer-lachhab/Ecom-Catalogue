package com.isga.nacer.dto.dtoRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class ProduitRequest {
	
	private String designation,description;
	private double price;
	private int quantity, idCategory;
}
