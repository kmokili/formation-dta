<!DOCTYPE html>
<%@page import="fr.pizzeria.model.Pizza"%>
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
		<% Pizza p = (Pizza) request.getAttribute("pizza");%>
		<form class="form-horizontal" action="<%=request.getContextPath() %>/pizzas/edit" method="post">
			<fieldset>
				
				<!-- Form Name -->
				<legend>Modifier une pizza</legend>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Code</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="code" type="text" placeholder="Code" class="form-control input-md" value="<%=p.getCode() %>">
					
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Nom</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="nom" type="text" placeholder="Votre nom" class="form-control input-md"  value="<%=p.getNom() %>">				
				  </div>
				</div>
				
				<!--
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Image</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="url_image" type="text" placeholder="Votre nom" class="form-control input-md" value="<%=p.getUrl_image() %>">
					
				  </div>
				</div>
				-->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Prix</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="prix" type="text" placeholder="Prix" class="form-control input-md" value="<%=p.getPrix() %>">
					
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Catégorie</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="categorie" type="text" placeholder="Prix" class="form-control input-md" value="<%=p.getCategorie().getLibelle() %>">
					
				  </div>
				</div>
	
				<div class="form-group">
				  <label class="col-md-4 control-label" for="textinput">Catégorie</label>  
				  <div class="col-md-4">
				  <input id="textinput" name="categorie" type="text" placeholder="Prix" class="form-control input-md" value="<%=p.getCategorie().getLibelle() %>">
					<select>
					  <option value="volvo">Volvo</option>
					  <option value="saab">Saab</option>
					  <option value="opel">Opel</option>
					  <option value="audi">Audi</option>
					</select>
				  </div>
				</div>
	
				<!-- Button -->
				<div class="form-group">
				  <label class="col-md-4 control-label" for="singlebutton"></label>
				  <div class="col-md-4">
					<button id="singlebutton" name="singlebutton" class="btn btn-success">Envoyer</button>
				  </div>
				</div>
				
				<div class="form-group">
				  <label class="col-md-4 control-label" for="singlebutton"></label>
				  <div class="col-md-4">
					<button id="singlebutton" name="singlebutton" class="btn btn-primary" href="/pizzas/list">Retour à la liste des pizzas</button>
				  </div>
				</div>
				

			</fieldset>
		</form>

	</body>
</html>