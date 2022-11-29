<%-- 
    Document   : menuPrincipal
    Created on : 28/11/2022, 09:17:04 PM
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <title>Menu Principal</title>
    </head>
    <body>
        
         <div class="container tm-home-section-1">
             
             <div class="tab-content">
    <div role="tabpanel" class="tab-pane fade in active tm-white-bg" id="hotel">
        <div class="tm-search-box effect2">
    <div class="hotel-search-form">  
        <div class="tm-form-inner">
        <div class="container" align="center">
            <br>
            <br>
            <br>
            <h1 align="center">Bienvenido ${sessionScope.usuario}</h1><br>
            <a href="Mostrar.jsp">Administrar Productos</a><br>
            <form action="${pageContext.request.contextPath}/CierraSesion" method="post">
           <div align="center">
               <button type="submit" name="submit" value ="CierraSesion" class="tm-yellow-btn">Cerrar Sesi&oacute;n</button>
           </div> 
           </form>
        </div>
         </div>
               </div>
    </div>
        </div>
    </div>
</div>
        
    </body>
</html>
