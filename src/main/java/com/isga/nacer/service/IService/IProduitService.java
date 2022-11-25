package com.isga.nacer.service.IService;

import java.util.List;

import com.isga.nacer.dto.dtoRequest.CategoryRequest;
import com.isga.nacer.dto.dtoRequest.ProduitRequest;
import com.isga.nacer.entities.Produit;

public interface IProduitService {

	public Produit getById(int idProduit) throws Exception;
	
	public List<Produit> allProducts() throws Exception;
	
	public List<Produit> getByPriceMax(double price) throws Exception;
	
	public List<Produit> products(double minPrix, double maxPrix) throws Exception;
	
	public List<Produit> productsOfCategory(CategoryRequest categorie) throws Exception;
	
	public Produit addProduit(ProduitRequest Produit) throws Exception;
	
	public Produit updateProduit(int idProduit,ProduitRequest newValue) throws Exception;
	
	public void removeProduit(int idProduit) throws Exception;
}
