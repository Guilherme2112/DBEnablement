<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de time</title>
</head>
<body>
	<h1>Cadastre o seu time</h1>
	<form method="post" action="cadastro">
	<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome"><br>
	<label for="anoDeCriaCao">Ano de Criação</label>
		<input type="text" name="anoDeCriaCao" id="criac"><br>
	<input type="submit" value="Cadastar essa porra">
	</form>
</body>
</html>