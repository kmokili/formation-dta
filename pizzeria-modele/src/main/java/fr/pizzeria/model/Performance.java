package fr.pizzeria.model;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String service;
	private LocalDateTime date;
	private Long tempsExecution;
	
	
	/**
	 *  Constructeur par défaut
	 */
	public Performance() {
		
	}
	
	
	/**
	 * Constructeur sans id (pour id généré automatiquement)
	 * @param service : le nom du service
	 * @param date : la date/heure de la mesure
	 * @param tempsExecution : le temps d’exécution en ms
	 */
	public Performance(String service, LocalDateTime date, Long tempsExecution) {
		super();
		
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}
	
	/**
	 * Constructeur avec tous les paramètres
	 * @param id : identifiant technique en base de données
	 * @param service : le nom du service
	 * @param date : la date/heure de la mesure
	 * @param tempsExecution : le temps d’exécution en ms
	 */
	public Performance(Integer id, String service, LocalDateTime date, Long tempsExecution) {
		super();
		this.id = id;
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public Long getTempsExecution() {
		return tempsExecution;
	}


	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	

}
