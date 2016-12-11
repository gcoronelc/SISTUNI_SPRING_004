<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONSULTAR EMPLEADO</title>
</head>
<body>
  <h1>CONSULTAR EMPLEADO</h1>
  
  <p>ERROR: ${error}</p>
  
  <form method="post" action="conEmpleado.htm">
    <label>Código:</label>
    <input type="text" name="codigo" />
    <input type="submit" value="Consultar"/>
  </form>
  
  <h1>RESULTADO</h1>
  <table>
    <tr>
      <td>Código:</td>
      <td>${bean.codigo}</td>
    </tr>
    <tr>
      <td>Paterno:</td>
      <td>${bean.paterno}</td>
    </tr>
    <tr>
      <td>Materno:</td>
      <td>${bean.materno}</td>
    </tr>
    <tr>
      <td>Nombre:</td>
      <td>${bean.nombre}</td>
    </tr>  
  </table>
  
  
  
</body>
</html>