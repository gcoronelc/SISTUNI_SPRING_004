<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NUEVO EMPLEADO</title>
</head>
<body>
  <h1>NUEVO EMPLEADO</h1>
  <p>Mensaje: ${mensaje}</p>
  <p>Error: ${error}</p>
  <form method="post" action="proInsEmpleado.htm">
    <table>
      <tr>
        <td>Paterno</td>
        <td><input type="text" name="paterno"/></td>
      </tr>
      <tr>
        <td>Materno</td>
        <td><input type="text" name="materno"/></td>
      </tr>
      <tr>
        <td>Nombre</td>
        <td><input type="text" name="nombre"/></td>
      </tr>
      <tr>
        <td>Ciudad</td>
        <td><input type="text" name="ciudad"/></td>
      </tr>
      <tr>
        <td>Dirección</td>
        <td><input type="text" name="direccion"/></td>
      </tr>
      <tr>
        <td>Usuario</td>
        <td><input type="text" name="usuario"/></td>
      </tr>
      <tr>
        <td>Clave</td>
        <td><input type="password" name="clave"/></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Procesar"/>
        </td>
      </tr>
    </table>
  
  
  
  </form>
</body>
</html>