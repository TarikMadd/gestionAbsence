package com.ensa.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Classe implements Serializable{
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="userId")
	private String id;
	private String libelle;
	private String niveau;
	private String type;
	
	@OneToMany
	@JoinColumn(name = "etudiant_id")
	private List<Personne> etudiants;

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classe(String libelle, String niveau, String type, List<Personne> etudiants) {
		super();
		this.libelle = libelle;
		this.niveau = niveau;
		this.type = type;
		this.etudiants = etudiants;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Personne> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Personne> etudiants) {
		this.etudiants = etudiants;
	}

	
}
