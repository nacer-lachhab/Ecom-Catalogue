package com.isga.nacer.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@ToString
@Builder
public class Categorie {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "libelle is Mondatory")
	@Column(unique = true)
	private String libelle;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "categorie")
	@JsonManagedReference(value = "cat-prod")
	private Set<Produit> produits;
	
	
}
