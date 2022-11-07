<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de livros por categoria</title>
</head>
<body>
	
	<form action = "ListarLivrosServlet" method="POST">
		<select name="categoria"> 
			<option value="Arquitetura">Arquitetura</option>
			<option value="Desgin">Design</option>
			<option value="Informática">Informática</option>
			<option value="Literatura brasileira">Literatura brasileira</option>
			<option value="Literatura infantil">Literatura infantil</option>
			<option value="Literatura universal">Literatura universal</option>
			<option value="Música e arte">Música e arte</option>
		</select>
		<input type="submit" value="Listar"/>
		
		<p>O filtro por categorias não funciona, ao clicar no botão o site exibe todos os livros do banco.</p>
	</form>
	
</body>
</html>

