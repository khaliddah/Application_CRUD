<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>
<p></p>
<div class="container col-md-6">
	<div class="card">
		<div class="card-header" style="background-color: #F0F8FF">Le produit saisi est bien sauvegardé</div>
		<div class="card-body">
			<div class="form-group">
				<label class="control-label">ID:</label>
				<label>${produit.id}</label>
			</div>
			<div class="form-group">
				<label class="control-label">Désignation:</label>
				<label>${produit.designation}</label>
			</div>
			<div class="form-group">
				<label class="control-label">Prix:</label>
				<label>${produit.prix}</label>
			</div>
			<div class="form-group">
				<label class="control-label">Quantité:</label>
				<label>${produit.quantite}</label>
			</div>
		</div>
	</div>
</div>
</body>
</html>