<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROMEDIO</title>
</head>
<body>
  <h1>PROMEDIO</h1>
  <a href='<c:url value="/" />'>Inicio</a>
  <form method="post" action="promedio.uni">
  
    <div>
      <label>Estudiante:</label>
      <input type="text" name="nombre" />
    </div>
    
    <div>
      <label>Nota 1:</label>
      <input type="text" name="nota1" />
    </div>
    
    <div>
      <label>Nota 2:</label>
      <input type="text" name="nota2" />
    </div>
    
    <div>
      <label>Nota 3:</label>
      <input type="text" name="nota3" />
    </div>
    
    <div>
      <label>Nota 4:</label>
      <input type="text" name="nota4" />
    </div>
    
    <div>
      <input type="submit" value="Procesar" />
    </div>
    
  </form>
  
  <c:if test="${dto != null}">
	  <h1>RESULTADO</h1>
	  <P>Estudiante: ${nombre}</P>
	  <P>Promedio: ${dto.prom}</P>
	  <P>Estado: ${dto.estado}</P>
  </c:if>
</body>
</html>