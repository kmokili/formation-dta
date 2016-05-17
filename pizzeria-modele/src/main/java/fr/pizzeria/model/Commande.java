package fr.pizzeria.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinColumn(name="livreur_id")
	private Livreur livreur;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
		joinColumns=
	@JoinColumn(name="commande_id", referencedColumnName="id"),
		inverseJoinColumns=
	@JoinColumn(name="pizza_id", referencedColumnName="id")
			)
	private Set<Pizza> pizzas;
	
	
	
	public Commande() {
		// implémentation par défaut
	}

	public Commande(Integer numCommande, Statut statut, 
			Date date_commande, Livreur livreur, Client client) {
		this();
		this.numero_commande = numCommande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur = livreur;
		this.client = client;
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

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
}
