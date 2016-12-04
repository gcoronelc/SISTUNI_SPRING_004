<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONSULTAR EMPLEADOS</title>
</head>
<body>
	<h1>CONSULTAR EMPLEADOS</h1>

	<p>ERROR: ${error}</p>

	<form method="post" action="conEmpleados.htm">
		<table>
			<tr>
				<td>
				  <label>Paterno:</label><br /> 
				  <input type="text" name="paterno" value="${bean.paterno}"/>
				</td>
				<td>
				  <label>Materno:</label><br /> 
				  <input type="text" name="materno" value="${bean.materno}"/>
				</td>
				<td>
				  <label>Nombre:</label><br /> 
				  <input type="text" name="nombre" value="${bean.nombre}"/>
				</td>
				<td>
				  <br /> 
				  <input type="submit" value="Consultar" />
				</td>
			</tr>
		</table>
	</form>

	<h1>RESULTADO</h1>
	<table>
		<thead>
			<tr>
				<td>CODIGO</td>
				<td>PATERNO</td>
				<td>MATERNO</td>
				<td>NOMBRE</td>
				<td>CIUDAD</td>
				<td>DIRECCION</td>
			</tr>
		</thead>
		<tbody>
		  <c:forEach items="${lista}" var="r">
			<tr>
				<td>${r.codigo}</td>
				<td>${r.paterno}</td>
				<td>${r.materno}</td>
				<td>${r.nombre}</td>
				<td>${r.ciudad}</td>
				<td>${r.direccion}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>