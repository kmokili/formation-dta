package fr.pizzeria.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer numero_commande;
	private Statut statut;
	private Date date_commande;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Integer livreur_id;
	@ManyToOne
	@JoinColumn(name="id")
	private Integer client_id;
	
	public Commande() {
		// implémentation par défaut
	}

	public Commande(Integer numCommande, Statut statut, 
			Date date_commande, Integer livreur_id, Integer client_id) {
		this();
		this.numero_commande = numCommande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero_commande() {
		return numero_commande;
	}

	public void setNumero_commande(Integer numero_commande) {
		this.numero_commande = numero_commande;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public Integer getLivreur_id() {
		return livreur_id;
	}

	public void setLivreur_id(Integer livreur_id) {
		this.livreur_id = livreur_id;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	
}
