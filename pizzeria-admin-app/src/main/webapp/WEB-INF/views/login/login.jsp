<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Authentification</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<header>
			<h1>Gestion de la pizzeria</h1>
		</header>
		
		${msgerr}
		
		<form class="form-horizontal" method="post">
			<fieldset>
			
				<!-- Form Name -->
				<legend>Authentification</legend>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email</label>  
					<div class="col-md-4">
						<input id="email" name="email" type="email" placeholder="Votre email" class="form-control input-md">
					    
					</div>
				</div>
				
				<!-- Password input-->
					<div class="form-group">
					<label class="col-md-4 control-label" for="password">Mot de passe </label>
					<div class="col-md-4">
						<input id="password" name="password" type="password" placeholder="mot de passe" class="form-control input-md">
					    
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="valider" name="valider" class="btn btn-success">Valider</button>
					</div>
				</div>
		
			</fieldset>
		</form>
	</body>
</html>