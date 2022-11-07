<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de livros</title>
</head>
<body>
	
	<form action="AdicionarLivrosServlet" method="post">
	
		<label>Código: </label><br/>
		<input type="text" name="codlivro"/><br/>
		<label>Titulo:</label><br/>
		<input type="text" name="titulo"/><br/>
		<label>Autor:</label><br/>
		<input type="text" name="autor"><br/>
		<label>Categoria:</label><br/>
		
		<select name="categoria">
			<option value="Arquitetura">Arquitetura</option>
			<option value="Desgin">Design</option>
			<option value="Informática">Informática</option>
			<option value="Literatura brasileira">Literatura brasileira</option>
			<option value="Literatura infantil">Literatura infantil</option>
			<option value="Literatura universal">Literatura universal</option>
			<option value="Música e arte">Música e arte</option>
		</select><br>
		
		<label>Valor:</label><br>
        <input type="text" name="valor"><br>
        
        <button type="submit" name="cadastrar" formmethod="post">Cadastrar</button>
        <button type="submit" formmethod="PUT">Alterar</button>
		<button type="submit" formmethod="DELETE">Excluir</button>
		
		<p>Os três métodos funcionam individualmente, mas ao clicar em qualquer botão, os métodos irão se sobrepor.</p>
		
	</form>
</body>
</html>