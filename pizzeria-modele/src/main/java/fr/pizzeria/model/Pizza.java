package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Pizza {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ToString 
	private String code;
	@ToString(uppercase = true) private String nom;
	@ToString 
	private BigDecimal prix;
	@ToString @Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	private String url_image;
	
	
	public static int nbPizzas;

	public Pizza() {
		// constructeur par défaut
	}

	public Pizza(String code, String nom, BigDecimal prix, 
			CategoriePizza cat, String url_image) {
		this();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = cat;
		this.url_image = url_image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Utiliser plutôt getNouveauPrix()
	 * @return
	 */
	public BigDecimal getPrix() {
		return prix;
	}
	
	public BigDecimal getNouveauPrix() {
		// super algo
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}
	

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
	
	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}
	
	
	
	private final static Map<String, String> FORMAT = new HashMap<String, String>();
	private final static String AUTRE_FORMAT = "(%s)";
	
	static {
		FORMAT.put("code", "%s ->");
		FORMAT.put("nom", "%s ***");
	}

	@Override
	public String toString() {
		return Arrays.asList(this.getClass().getDeclaredFields())
				.stream()
					.filter(field -> field.getAnnotation(ToString.class) !=null)
					.map(getValeurDuChamp())
					.collect(Collectors.joining(" "));
	}

	private Function<? super Field, ? extends String> getValeurDuChamp() {
		return field -> {
			
			String resultat = "";
			try {
				resultat= field.getAnnotation(ToString.class).uppercase() ? field.get(this).toString().toUpperCase() : field.get(this).toString();
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
					e1.printStackTrace();
			}
			
			String formatResultat = FORMAT.get(field.getName()) == null ? AUTRE_FORMAT : FORMAT.get(field.getName());
			
			return  String.format(formatResultat, resultat);
		};
	}


	
	@Override
	public int hashCode() {
		 return new HashCodeBuilder(17, 37).
			       append(code).
			       append(categorie).
			       append(prix).
			       append(nom).
			       toHashCode();
	}
	
	public String toJson() {
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"nom\" : \"").append(this.getNom()).append("\"")
		.append("\"code\" : \"").append(this.getCode());
		return sb.toString();
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
	   if (obj == null) 
	   	{ return false; }
	   if (obj == this) 
	   	{ return true; }
	   if (obj.getClass() != getClass()) {
	     return false;
	   }
	   Pizza rhs = (Pizza) obj;
	   return new EqualsBuilder()
	                 //.appendSuper(super.equals(obj))
	                 .append(categorie, rhs.categorie)
	                 .append(code, rhs.code)
	                 .append(nom, rhs.nom)
	                 .append(prix, rhs.prix)
	                 .isEquals();
	}

	

}