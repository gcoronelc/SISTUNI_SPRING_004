<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" 
src="<c:url value='/resources/jquery/jquery.js' />"></script>
<title>CONSULTAR EMPLEADO</title>
</head>
<body>
  <h1>CONSULTAR EMPLEADO</h1>
  
  <p style="color:red;">ERROR: <span id="error"></span></p>
  
  <form id="form1">
    <label>Código:</label>
    <input type="text" name="codigo" />
    <input type="button" id="btnConsultar" value="Consultar"/>
  </form>
  
  <h1>RESULTADO</h1>
  <table>
    <tr>
      <td>Código:</td>
      <td><span id="rCodigo"></span></td>
    </tr>
    <tr>
      <td>Paterno:</td>
      <td><span id="rPaterno"></span></td>
    </tr>
    <tr>
      <td>Materno:</td>
      <td><span id="rMaterno"></span></td>
    </tr>
    <tr>
      <td>Nombre:</td>
      <td><span id="rNombre"></span></td>
    </tr>  
  </table>
  
  <script type="text/javascript">
  
  $("#btnConsultar").click(function(){
	  
    var data = $("#form1").serialize();
    $.post("conEmpleado2.htm",data,function(obj){
      if(obj.code == 1){
        $("#error").text("");
        var r = $.parseJSON(obj.text);
        $("#rCodigo").text(r.codigo);
        $("#rPaterno").text(r.paterno);
        $("#rMaterno").text(r.materno);
        $("#rNombre").text(r.nombre);
      } else {
        $("#error").text(obj.text);
        $("#rCodigo").text("");
        $("#rPaterno").text("");
        $("#rMaterno").text("");
        $("#rNombre").text("");
      }
    });
	  
  });
  
  </script>
  
</body>
</html>