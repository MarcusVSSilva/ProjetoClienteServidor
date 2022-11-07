<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pesquisar por código</title>
</head>
<body>

	
	<form action="MostrarLivrosServlet" method="POST">
		<label>Código: </label><br/>
		<input type="text" name="codlivro"/><br/>
		<input type="submit" value="Listar"/>
	</form>
	
	<p>O filtro por código não funciona, ao clicar no botão o site exibe todos os livros do banco.</p>
	
</body>
</html>