<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<title>CONSULTA DE SUCURSAL</title>
</head>
<body>
  <h1>CONSULTA DE SUCURSAL</h1>
  <form id="form1">
    <label>Cuenta:</label>
    <input type="text" name="cuenta"/>
    <input type="button" id="btnConsultar" value="Consultar" />
  </form>
  <table border="1">
    <thead>
      <tr>
        <th>CUENTA</th>
        <th>CIUDAD</th>
        <th>SUCURSAL</th>
      </tr>
    </thead>
    <tbody id="data"></tbody>
  </table>
  <script type="text/javascript">
  
  $("#btnConsultar").click(function(){
	 
	  var orden2=["CHR_CUENCODIGO","VCH_SUCUCIUDAD","VCH_SUCUNOMBRE"]; 
	  
	  $.getJSON('/datosSucursal', $('#form1').serialize(), function (json)
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