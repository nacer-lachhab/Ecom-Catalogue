package com.isga.nacer.service.ServiceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isga.nacer.dto.dtoRequest.CategoryRequest;
import com.isga.nacer.entities.Categorie;
import com.isga.nacer.repositories.CategorieRepository;
import com.isga.nacer.service.IService.ICategorieService;

@Service
public class CategorieSevice implements ICategorieService {
	
	@Autowired
	private CategorieRepository repository;

	@Override
	public Categorie getById(int idCategorie) throws Exception {
		return repository
				.findById(idCategorie)
				.orElseThrow(()->new Exception("pas de categorie avec id = "+ idCategorie));
	}

	@Override
	public Categorie getByLibelle(String libelle) throws Exception {
		return repository
				.findByLibelle(libelle)
				.orElseThrow(()->new Exception("pas de categorie avec ce "+ libelle));
	}

	@Override
	public List<Categorie> getAll() {
		return repository.findAll();
	}

	@Override
	public Categorie addCategorie(CategoryRequest categoryReq) throws Exception {
		String libelleOfCategory = categoryReq.getLibelle();
		Optional<Categorie> testIfExists = repository.findByLibelle(libelleOfCategory);
		if(!testIfExists.isPresent()) {
			Categorie categorie = Categorie.builder()
										   .libelle(libelleOfCategory)
										   .build();
			return repository.save(categorie);
		}
		else 
			throw new Exception("category with libelle: "+ libelleOfCategory);
	}

	@Override
	public Categorie editCategorie(int idCat,CategoryRequest newCategorie) throws Exception {
		Categorie catByLibelle = getById(idCat);
//				getByLibelle(newCategorie.getLibelle());//validation
		Categorie categorieUpdated = Categorie.builder()
											 .id(catByLibelle.getId())
											 .libelle(newCategorie.getLibelle())
											 .produits(catByLibelle.getProduits())
											 .build();
		return repository.save(categorieUpdated);
	}

	@Override
	public void removeCategorie(int id) throws Exception {
		Categorie categorieToDelete=getById(id);
		repository.delete(categorieToDelete);
	}

}
