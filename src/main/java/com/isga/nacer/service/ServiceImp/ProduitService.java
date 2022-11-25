package com.isga.nacer.service.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.nacer.dto.dtoRequest.CategoryRequest;
import com.isga.nacer.dto.dtoRequest.ProduitRequest;
import com.isga.nacer.entities.Categorie;
import com.isga.nacer.entities.Produit;
import com.isga.nacer.repositories.CategorieRepository;
import com.isga.nacer.repositories.ProduitRepository;
import com.isga.nacer.service.IService.IProduitService;

@Service
public class ProduitService implements IProduitService {

	@Autowired
	private ProduitRepository repository;

	@Autowired
	private CategorieRepository categorieRepository;

	@Override
	public Produit getById(int idProduit) throws Exception {
		return repository.findById(idProduit)
				.orElseThrow(() -> new Exception("pas de categorie avec id =" + idProduit));
	}

	public List<Produit> allProducts() throws Exception {
		List<Produit> listProducts = repository.findAll();
		if (listProducts.isEmpty())
			throw new Exception("no products in DB");
		else
			return listProducts;
	}

	@Override
	public List<Produit> getByPriceMax(double price) throws Exception {
		List<Produit> listResults = repository.findByPriceLessThan(price);
		if (!listResults.isEmpty())
			return listResults;
		else
			throw new Exception("no products cheaper than price: " + price);
	}

	@Override
	public List<Produit> products(double minPrix, double maxPrix) throws Exception {
		List<Produit> listResults = repository.findByPriceBetween(minPrix, maxPrix);
		if (!listResults.isEmpty())
			return listResults;
		else
			throw new Exception("no products with price between minPrice: " + minPrix + "and maxPrice: " + maxPrix);
	}

	@Override
	public List<Produit> productsOfCategory(CategoryRequest categoryReq) throws Exception {
		Categorie categorie = categorieRepository.findByLibelle(categoryReq.getLibelle())
				.orElseThrow(() -> new RuntimeException("no Category found with libelle: " + categoryReq.getLibelle()));
		List<Produit> productsInCategorie = repository.findByCategorie(categorie);
		if (!productsInCategorie.isEmpty())
			return productsInCategorie;
		else
			throw new Exception("categorie: " + categorie.getLibelle() + " vide");
	}

	@Override
	public Produit addProduit(ProduitRequest produitReq) throws Exception {
		String designationOfProduct = produitReq.getDesignation();
		Optional<Produit> ProduitInDb = repository.findByDesignation(designationOfProduct);
		if (ProduitInDb.isEmpty()) {
			Produit produit = Produit.builder()
					.designation(produitReq.getDesignation())
					.description(produitReq.getDescription())
					.price(produitReq.getPrice())
					.quantity(produitReq.getQuantity())
					.build();
			Optional<Categorie> categoryById = categorieRepository
												.findById(produitReq.getIdCategory());
			if (categoryById.isPresent())
				produit.setCategorie(categoryById.get());
			return repository.save(produit);
		} else
			throw new Exception("produit with designation: "+designationOfProduct+"already exist in DB");
	}

	@Override
	public Produit updateProduit(int idProduit,ProduitRequest newValueProduct) throws Exception {
		getById(idProduit);
		Produit updatedproduct = Produit.builder()
				.id(idProduit)
				.description(newValueProduct.getDescription())
				.designation(newValueProduct.getDesignation())
				.price(newValueProduct.getPrice())
				.quantity(newValueProduct.getQuantity())
				.build();
		Optional<Categorie> categoryById =
				categorieRepository.findById(newValueProduct.getIdCategory());
		if (categoryById.isPresent())
			updatedproduct.setCategorie(categoryById.get());
		return repository.save(updatedproduct);
	}

	@Override
	public void removeProduit(int id) throws Exception {
		Produit productToDelete = getById(id);
		repository.delete(productToDelete);
	}

}
