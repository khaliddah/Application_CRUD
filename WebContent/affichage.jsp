<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Gestion Des Produits</title>
</head>
<body>
<%@include file="header.jsp"%>
<p></p>
	<div class="container col-md-10">
		<div class="card">
			<div class="card-header" style="background-color: #F0F8FF">Recherche La Liste Des Produits</div>
			<div class="card-body">
			    <form action="rechercher.do" method="get">
			    	<label>Mot Cle</label>
					<input type="text" name="motCle" value="${model.motCle}">
					<button type="submit" class="btn btn-primary">Rechercher</button>
				</form>
				<br>
				<table class="table table-stripped">
					<tr>
						<th>ID</th><th>DESIGNATION</th><th>PRIX</th><th>QUANTITE</th>
					</tr>
					<c:forEach items="${model.produits}" var="p">
						<tr>
							<td>${p.id}</td><td>${p.designation}</td><td>${p.prix}</td><td>${p.quantite}</td>
							<td><a href="supprimer.do?id=${p.id}">Supprimer</a></td>
							<td><a href="editer.do?id=${p.id}">Editer</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>