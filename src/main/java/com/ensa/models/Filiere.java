package com.ensa.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Filiere implements Serializable{
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="userId")
	private String id;
	
	private String nom;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="FILIERS_MATIERES",
	joinColumns={@JoinColumn(name="FILIERE_ID")},
	inverseJoinColumns={@JoinColumn(name="MATIERE_ID")})
	private List<Module> modules;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chef_filiere_id")
	private Personne chefFiliere;

	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filiere(String nom, List<Module> modules, Personne chefFiliere) {
		super();
		this.nom = nom;
		this.modules = modules;
		this.chefFiliere = chefFiliere;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setMatieres(List<Module> modules) {
		this.modules= modules;
	}

	public Personne getChefFiliere() {
		return chefFiliere;
	}

	public void setChefFiliere(Personne chefFiliere) {
		this.chefFiliere = chefFiliere;
	}

	
}
