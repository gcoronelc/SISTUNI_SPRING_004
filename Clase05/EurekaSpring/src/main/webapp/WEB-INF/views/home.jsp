<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INGRESO SISTEMA</title>
</head>
<body>
  <h1>INICIO DE SESION</h1>

  <p>Error: ${error}</p>

  <form method="post" action="logon.htm">
    <table>
      <tr>
        <td>Usuario</td>
        <td><input type="text" name="usuario" /></td>
      </tr>
      <tr>
        <td>Clave</td>
        <td><input type="password" name="clave" /></td>
      </tr>      
      <tr>
        <td colspan="2">
          <input type="submit" value="Ingresar" />
        </td>
      </tr>      
    </table>
  </form>

</body>
</html>