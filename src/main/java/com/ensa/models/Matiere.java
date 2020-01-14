package com.ensa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Matiere implements Serializable{
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="userId")
	private String id;
	private String libelle;
	private int chargeHoraire;
	
	@ManyToOne(targetEntity = Personne.class)
	@JoinColumn(name = "profEnseignant_id")
	private Personne profEnseignant;

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matiere(String libelle, int chargeHoraire, Personne profEnseignant) {
		super();
		this.libelle = libelle;
		this.chargeHoraire = chargeHoraire;
		this.profEnseignant = profEnseignant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public Personne getProfEnseignant() {
		return profEnseignant;
	}

	public void setProfEnseignant(Personne profEnseignant) {
		this.profEnseignant = profEnseignant;
	}

	

}
