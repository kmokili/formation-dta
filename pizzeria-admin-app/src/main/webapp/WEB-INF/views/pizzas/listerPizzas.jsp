<%@page import="fr.pizzeria.model.Pizza" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
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
					<td>IMAGE</td>
					<td>PRIX</td>
					<td></td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<%
					List<Pizza> listPizzas = (List<Pizza>) request.getAttribute("listePizzas");
					for (Pizza p : listPizzas) {
				%>
				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getCode() %></td>
					<td><%=p.getNom() %></td>
					<td><img src="http://placehold.it/150x150"></td>
					<td><%=p.getPrix() %></td>
					<td><a class="btn btn-primary" href="<%=request.getContextPath() %>/pizzas/edit?code=<%= p.getCode() %>">Editer</a></td>
					<td></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		
	</body>
</html>