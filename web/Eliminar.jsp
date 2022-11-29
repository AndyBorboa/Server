<%-- 
    Document   : Eliminar
    Created on : 28/11/2022, 12:38:52 AM
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <title>Eliminar</title>
    </head>
    <body>
        
                <div class="container tm-home-section-1">
             <br>
             <br>
             <br>
             <br>
             
             <br>
    <div class="tab-content">
    <div role="tabpanel" class="tab-pane fade in active tm-white-bg" id="hotel">
        <div class="tm-search-box effect2">
    <div class="hotel-search-form">  
        <div class="tm-form-inner">
            <h2>Eliminar Producto</h2>
            <br>
        
    <form name="frmEliminar" method="post" action="EliminarProducto"> 
        <div class="form-group">
        Clave del Producto a Eliminar: <input class="form-control" type = "text" name="Codigo" id="Codigo"/> 
    </br>
        </div>
        <div align="center">
            <button type="submit" name="submit" class="tm-yellow-btn">Eliminar</button>
        </div>
    </form> 
        </div>
    </div>
        </div>
    </div>
</div>
    </div>
        
    </body>
</html>
