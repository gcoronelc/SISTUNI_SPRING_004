<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>

<script src="http://code.jquery.com/jquery-2.1.4.min.js" type="text/javascript"></script>

<title>CONSULTA DE MOVIMIENTOS</title>

</head>
<body>
  <h1>CONSULTA DE MOVIMIENTOS</h1>
  <form id="form1">
    <label>Cuenta:</label>
    <input type="text" name="cuenta"/>
    <input type="button" id="btnConsultar" value="Consultar" />
  </form>
  <table border="1">
    <thead>
      <tr>
        <th>CUENTA</th>
        <th>NRO.MOV.</th>
        <th>FECHA</th>
        <th>TIPO</th>
        <th>IMPORTE</th>
      </tr>
    </thead>
    <tbody id="data"></tbody>
  </table>
  <script type="text/javascript">
  orden2=["CUENCODIGO","MOVINUMERO","MOVIFECHA","TIPONOMBRE","MOVIIMPORTE"];
  $("#btnConsultar").click(function(){

	  $.getJSON('/datosMovimientos1', $('#form1').serialize(), function (json)
			    {
			        
		  $('#data').html("");
			        html ='';
			        var length=json.length
			        for (var i = 0; i < length; i++)
			        {
			            html +='<tr class="actived">';
			            $.each(orden2, function (number, head)
			            {
			                var cont="";
			                $.each(json[i], function (index, el)
			                {

			                    if(head==index)
			                        cont = el;
			                });
			                html+='<td>' + cont + '</td>';
			            });
			            html +='</tr>';
			        }
			        $('#data').append(html);
			        
			    });
	  
  });
  
  
  </script>
</body>
</html>