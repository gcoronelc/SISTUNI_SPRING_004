<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <h1>EUREKA HOME</h1>
  
  <h2>${sessionScope.usuario.nombre }</h2>
  
  <a href="conSaldo.htm">Consultar Saldo</a><br/>
  <a href="conEmpleado.htm">Consultar Empleado</a><br/>
  <a href="conEmpleado2.htm">Consultar Empleado 2</a><br/>
  <a href="conEmpleados.htm">Consultar Empleados</a><br/>
  <a href="conEmpleados2.htm">Consultar Empleados 2</a><br/>
  <a href="proInsEmpleado.htm">Insertar Empleado</a><br/>
  <a href="conMovimientos1.htm">Consultar Movimientos - Caso 1</a><br/>
  
  
</body>
</html>
