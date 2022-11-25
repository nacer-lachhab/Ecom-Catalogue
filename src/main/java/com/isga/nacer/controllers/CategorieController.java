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

import com.isga.nacer.dto.dtoRequest.CategoryRequest;
import com.isga.nacer.entities.Categorie;
import com.isga.nacer.service.IService.ICategorieService;

@RestController
@RequestMapping("/api/v1/catalogue")
public class CategorieController {
	
	@Autowired(required = false)
	private ICategorieService service;
	
	@GetMapping("/categories")
	public List<Categorie> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/categorie/{id}")
	public Categorie getById(@PathVariable int id) throws Exception {
		return service.getById(id);
	}
	
	@PostMapping("/savecategorie")
	public Categorie save(@RequestBody CategoryRequest categorie) throws Exception {
		return service.addCategorie(categorie);
	}
	
	@PutMapping("/updatecategorie/{id}")
	public Categorie update(@PathVariable int id,@RequestBody CategoryRequest categorie) throws Exception {
		return service.editCategorie(id,categorie);
	}
	
	@DeleteMapping("/deletecategorie/{id}")
	public void delete(@PathVariable int id) throws Exception {
		service.removeCategorie(id);
	}
}
