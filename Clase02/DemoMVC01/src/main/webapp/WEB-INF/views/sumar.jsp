<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUMAR</title>
</head>
<body>
  <h1>SUMAR</h1>
  <form method="post" action="sumar2.uni">
    <div>
      <label>N�mero 1:</label>
      <input type="text" name="num1" />
    </div>
    <div>
      <label>N�mero 2:</label>
      <input type="text" name="num2" />
    </div>
    <div>
      <input type="submit" value="Procesar" />
    </div>
  </form>
  
  <h1>RESPUESTA</h1>
  <div>
    <p>N�mero 1: ${n1}</p>  
    <p>N�mero 2: ${n2}</p>  
    <p>Suma: ${suma}</p>  
  </div>
</body>
</html>