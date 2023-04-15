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
		<div class="card-header" style="background-color: #F0F8FF">Sauvegarder un enregistrement</div>
		<div class="card-body">
			<form action="save.do" method="post">
				<div class="form-group">
					<label class="control-label">Désignation</label>
					<input type="text" name="designation" value="${produit.designation}" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">Prix</label>
					<input type="text" name="prix" value="${produit.prix}" class="form-control">
				</div>
				<div class="form-group">
					<label class="control-label">Quantité</label>
					<input type="text" name="quantite" value="${produit.quantite}" class="form-control">
				</div>
				<button type="submit" class="btn btn-primary">Save</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>