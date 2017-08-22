<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastar Atleta</title>
</head>
<body>

	<form action="cadastrar" method="post">
		<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome"><br>
		
		<label for="altura">Altura</label>
		<input type="text" name="altura" id="altura"><br>
		
		<label for="peso">Peso</label>
		<input type="text" name="peso" id="peso"><br>
		<input type="submit" value="Salvar">
	</form>
</body>
</html>