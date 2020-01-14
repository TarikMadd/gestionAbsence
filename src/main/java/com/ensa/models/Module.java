package com.ensa.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Module implements Serializable{
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="userId")
	private String id;
	private String libelle;
	private int chargeHoraire;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="MODULES_MATIERES",
	joinColumns={@JoinColumn(name="MODULE_ID")},
	inverseJoinColumns={@JoinColumn(name="MATIERE_ID")})
	private List<Matiere> matieres;

	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Module(String libelle, int chargeHoraire, List<Matiere> matieres) {
		super();
		this.libelle = libelle;
		this.chargeHoraire = chargeHoraire;
		this.matieres = matieres;
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

	public int getChargeHoraire() {
		return chargeHoraire;
	}

	public void setChargeHoraire(int chargeHoraire) {
		this.chargeHoraire = chargeHoraire;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	

}
