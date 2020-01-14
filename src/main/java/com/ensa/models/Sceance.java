package com.ensa.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Sceance implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "SEANCE_ID")
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
	private Date dateDebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Zagreb")
	private Date dateFin;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "classe_id")
	private Classe classe;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matiere_id")
	private Matiere matiere;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "module_id")
	private Module module;

	public Sceance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sceance(Date dateDebut, Date dateFin, Classe classe, Matiere matiere,Module module) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.classe = classe;
		this.matiere = matiere;
		this.module=module;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere= matiere;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	

}
