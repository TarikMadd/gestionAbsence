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
public class Departement implements Serializable{
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="userId")
	private String id;
	private String nom;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="DEPARTEMENTS_FILIERES",
	joinColumns={@JoinColumn(name="DEPARTEMENT_ID")},
	inverseJoinColumns={@JoinColumn(name="FILIERE_ID")})
	private List<Filiere> filieres_dept;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chef_dept_id")
	private Personne chefDept;

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(String nom,List<Filiere> filieres_dept, Personne chefDept) {
		super();
		this.nom = nom;
		this.filieres_dept = filieres_dept;
		this.chefDept = chefDept;
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

	public List<Filiere> getFilieres_dept() {
		return filieres_dept;
	}

	public void setFilieres_dept(List<Filiere> filieres_dept) {
		this.filieres_dept = filieres_dept;
	}

	public Personne getChefDept() {
		return chefDept;
	}

	public void setChefDept(Personne chefDept) {
		this.chefDept = chefDept;
	}
	
	
	
	

}
