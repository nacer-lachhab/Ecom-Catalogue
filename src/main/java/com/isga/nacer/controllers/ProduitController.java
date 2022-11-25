package com.isga.nacer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isga.nacer.dto.dtoRequest.ProduitRequest;
import com.isga.nacer.entities.Produit;
import com.isga.nacer.service.IService.IProduitService;

@RestController
@RequestMapping("/api/v1/catalogue")
public class ProduitController {
	
	@Autowired
	private IProduitService service;

	@GetMapping("/products")
	public List<Produit> getAll() throws Exception {
		return service.allProducts();
	}
	
	@GetMapping("/product/{id}")
	public Produit getById(@PathVariable int id) throws Exception {
		return service.getById(id);
	}
	
//	@GetMapping("/catProduct/{id}")
//	public Categorie getByIdCat(@PathVariable int id) throws Exception {
//		 return service.getById(id).getCategorie();
//	}
	
	@PostMapping("/saveProduct")
	public Produit save(@RequestBody ProduitRequest produit) throws Exception {
		return service.addProduit(produit);
	}
	
	@PutMapping("/updateProduct")
	public Produit update(
			@RequestBody int idProductToUpdate,
			@RequestBody ProduitRequest produit) throws Exception {
		return service.updateProduit(idProductToUpdate,produit);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void delete(@PathVariable int id) throws Exception {
		service.removeProduit(id);
	}
}
