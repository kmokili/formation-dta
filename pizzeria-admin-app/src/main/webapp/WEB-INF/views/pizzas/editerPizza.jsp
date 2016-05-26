<!DOCTYPE html>
<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Edition de pizza</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
	</head>
	

	<body>

		<form class="form-horizontal" action="<c:url value="/pizzas/edit" />" method="post">
			<fieldset>
				
				<!-- Form Name -->
				<legend>Modifier une pizza</legend>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="code">Code</label>  
				  <div class="col-md-4">
				  <input id="code" name="code" type="text" placeholder="Code pizza" class="form-control input-md" value="${pizza.code}">
					
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label" for="nom">Nom</label>  
				  <div class="col-md-4">
				  <input id="nom" name="nom" type="text" placeholder="Votre nom" class="form-control input-md"  value="${pizza.nom}">				
				  </div>
				</div>
				
				<!--
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Image</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="url_image" type="text" placeholder="Votre nom" class="form-control input-md" value=">
					
				  </div>
				</div>
				-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="prix">Prix</label>  
				  <div class="col-md-4">
				  <input id="prix" name="prix" type="text" placeholder="Prix" class="form-control input-md" value="${pizza.prix}">
					
				  </div>
				</div>
				
	
				<div class="form-group">
				  <label class="col-md-4 control-label" for="categorie">Catégorie</label>
				  <div class="col-md-4">
				    <select id="categorie" name="categorie" class="form-control">
				      <option <c:if test="${pizza.categorie.equals(CategoriePizza.VIANDE)}">selected</c:if> value="<c:out value="${CategoriePizza.VIANDE}"/>">Viande</option>
				      <option <c:if test="${pizza.categorie.equals(CategoriePizza.SANS_VIANDE)}">selected</c:if> value="${CategoriePizza.SANS_VIANDE}">Sans viande</option>
				      <option <c:if test="${pizza.categorie.equals(CategoriePizza.POISSON)}">selected</c:if> value="${CategoriePizza.POISSON}">Poisson</option>
				    </select>
				  </div>
				</div>
	
				<!-- Button -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="singlebutton"></label>
				  <div class="col-md-4">
					<button type="submit" id="singlebutton" name="singlebutton" class="btn btn-success">Envoyer</button>
				  </div>
				</div>
				
				

			</fieldset>
		</form>

	</body>
</html>