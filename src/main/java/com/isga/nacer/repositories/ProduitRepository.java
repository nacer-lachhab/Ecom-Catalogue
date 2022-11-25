package com.isga.nacer.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.nacer.entities.Categorie;
import com.isga.nacer.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

	List<Produit> findByPriceLessThan(double price);
	List<Produit> findByPriceBetween(double minPrice,double maxPrice);
	List<Produit> findByCategorie(Categorie categorie);
	Optional<Produit> findByDesignation(String designation);
}
