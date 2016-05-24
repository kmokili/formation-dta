<%@page import="fr.pizzeria.model.Pizza" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Lister Pizzas</title>
	</head>
	<body>
		<h1>Page Lister Pizzas</h1>
		
		<table>
			<thead>
				<tr>
					<td>ID</td>
					<td>CODE</td>
					<td>NOM</td>
					<td>IMAGE</td>
					<td>PRIX</td>
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
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		
	</body>
</html>