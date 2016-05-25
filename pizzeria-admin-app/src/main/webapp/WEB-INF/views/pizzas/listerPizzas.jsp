<%@page import="fr.pizzeria.model.Pizza" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Lister Pizzas</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h1>Page Lister Pizzas</h1>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>CODE</td>
					<td>NOM</td>
					<!-- <td>IMAGE</td> -->
					<td>PRIX</td>
					<td>CATEGORIE</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pizza" items="${listePizzas}">
					<tr>
						<td> ${pizza.id} </td>
						<td> ${pizza.code} </td>
						<td> ${pizza.nom} </td>
						<td> ${pizza.prix} </td>
						<td> ${pizza.categorie} </td>
						<td><a class="btn btn-success" href="<c:url value='/pizzas/edit?code=${pizza.code}' />">Editer</a></td>
						<td><a class="btn btn-danger" href="<c:url value='/pizzas/delete?code=${pizza.code}' />">Supprimer</a></td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
		
	</body>
</html>