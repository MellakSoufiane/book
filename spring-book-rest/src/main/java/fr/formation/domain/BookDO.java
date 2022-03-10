package fr.formation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="book")
public class BookDO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String auteur;
	
	@Column(nullable = false)
	private String annee;
	
	
	public enum Domaine{Histoire, Culture_Generale, Technologie};

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private Domaine domaine;

	
	public BookDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BookDO(long id, String nom, String auteur, String annee, Domaine domaine) {
		super();
		this.id = id;
		this.nom = nom;
		this.auteur = auteur;
		this.annee = annee;
		this.domaine = domaine;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getAnnee() {
		return annee;
	}


	public void setAnnee(String annee) {
		this.annee = annee;
	}


	public Domaine getDomaine() {
		return domaine;
	}


	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}
	
	

}
