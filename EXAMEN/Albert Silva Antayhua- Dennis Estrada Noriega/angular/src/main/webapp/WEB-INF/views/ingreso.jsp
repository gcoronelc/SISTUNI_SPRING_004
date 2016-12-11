<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
 <div class="container-fluid" id="content-login">
                <form id="box-login" name="box-login"  method="POST"  action="/General">
                    <div class="form-group ">                    
                        <input class="form-control" type="text" name="usuario" value="" id="username" autocomplete="off" required="" placeholder="Usuario" />
                    </div>
                    <div class="form-group">
                        <!--label class="req"><h4>Clave</h4></label-->
                        <br/>
                        <input class="form-control" type="password" name="clave" value="" id="password" autocomplete="off" required="" placeholder="Contraseña" />
                    </div>
                    <input  class="btn btn-primary btn-lg btn-block"  type="submit" value="Iniciar Sesión"  id="login" name="login"/>
                </form>
            </div>
</body>
</html>