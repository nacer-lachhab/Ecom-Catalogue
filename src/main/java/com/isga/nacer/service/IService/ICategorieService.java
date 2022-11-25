package com.isga.nacer.service.IService;

import java.util.List;

import com.isga.nacer.dto.dtoRequest.CategoryRequest;
import com.isga.nacer.entities.Categorie;

public interface ICategorieService {

	public Categorie getById(int idCategorie) throws Exception;
	
	public Categorie getByLibelle(String designation) throws Exception;
	
	public List<Categorie> getAll();
	
	public Categorie addCategorie(CategoryRequest categorie) throws Exception;
	
	public Categorie editCategorie(int idCat,CategoryRequest newCategorie) throws Exception;
	
	public void removeCategorie(int idCategorie) throws Exception;
}
