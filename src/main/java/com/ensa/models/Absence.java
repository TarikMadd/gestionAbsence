package com.ensa.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Absence implements Serializable{
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="userId")
	private String id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sceance_id")
	private Sceance sceance;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "etudiant_id")
	private Personne etudiantAbsent;
	
	private boolean isJustified=false;

	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Absence(Sceance sceance, Personne etudiantAbsent, boolean isJustified) {
		super();
		this.sceance = sceance;
		this.etudiantAbsent = etudiantAbsent;
		this.isJustified = isJustified;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Sceance getSceance() {
		return sceance;
	}

	public void setSceance(Sceance sceance) {
		this.sceance = sceance;
	}

	public Personne getEtudiantAbsent() {
		return etudiantAbsent;
	}

	public void setEtudiantAbsent(Personne etudiantAbsent) {
		this.etudiantAbsent = etudiantAbsent;
	}

	public boolean isJustified() {
		return isJustified;
	}

	public void setJustified(boolean isJustified) {
		this.isJustified = isJustified;
	}
	

}
