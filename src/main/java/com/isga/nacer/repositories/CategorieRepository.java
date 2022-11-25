package com.isga.nacer.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isga.nacer.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer>{

	Optional<Categorie> findByLibelle(String libelle);
}
