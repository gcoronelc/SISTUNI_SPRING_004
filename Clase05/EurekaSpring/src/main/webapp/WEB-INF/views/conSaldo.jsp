<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONSULTAR SALDO</title>
</head>
<body>
	<h1>CONSULTAR SALDO</h1>
	<form method="post" action="conSaldo.htm">
		<label>Cuenta:</label> <input type="text" name="cuenta" /> <input
			type="submit" value="Consultar" />
	</form>

	<c:if test="${error != null}">
		<h1>ERROR</h1>
		<p style="color:red;">${error}</p>
	</c:if>

	<h1>RESULTADO</h1>
	<p>Cuenta ${cuenta}</p>
	<p>Saldo: ${saldo}</p>
</body>
</html>