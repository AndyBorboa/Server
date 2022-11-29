<%-- 
    Document   : Agregar
    Created on : 28/11/2022, 12:38:26 AM
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
        <title>Agregar</title>
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
         <h2>Agregar Producto</h2>
         <br>
    <form name="frmRegistro" method="post" action="AgregarProducto"> 
        <div class="form-group">
        Nombre del Producto:            <input class="form-control" type = "text" name="nombreProducto" id="nombreProducto"/> 
        Categoria:  <input class="form-control" type = "text" name="Categoria" id="Categoria"/>
        Stock:  <input class="form-control" type = "text" name="Stock" id="Stock"/>
        Precio:             <input class="form-control" type = "text" name="Precio" id="Precio"/>
    </br>
        </div>
        <div align="center">
            <button type="submit" name="submit" class="tm-yellow-btn">Agregar</button>
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
