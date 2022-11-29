<%-- 
    Document   : Mostrar
    Created on : 28/11/2022, 12:39:16 AM
    Author     : andre
--%>

<%@page import="Coneccion.Consultas"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">

        <title>Administrar Productos</title>
    </head>
    <body>
        
        
         

             
        <%
            Connection con;
            
            String usu=(String) session.getAttribute("usuario");
            String url="jdbc:mysql://localhost:3306/registro";
            String Driver="com.mysql.jdbc.Driver";
            String user="root";
            String clave = "";
            Class.forName(Driver);
            con = DriverManager.getConnection(url,user,clave);
            
            PreparedStatement ps; 
            ResultSet rs;
            Consultas co = new Consultas();
            ps=con.prepareCall("SELECT * FROM productos");
            
            rs=ps.executeQuery();
            
        %>
        <br>
        <div class="container">
            <br>
            <br>
            <h2> Administrar Productos</h2>
            <br>
            
                   <div class="container">
            
            <table>
                <tr>
                    
                   <a target="_blank" class="fcc-btn" href="Agregar.jsp">Agregar Producto  </a>
                   <a target="_blank" class="fcc-btn" href="Actualizar.jsp">Actualizar Producto  </a>
                   <a target="_blank" class="fcc-btn" href="Eliminar.jsp">Eliminar Producto</a>
                   <a target="_blank" class="fcc-btn" href="menuPrincipal.jsp">Men&uacute; Principal</a>
                </tr> 
            </table>
            <br>
        
        <table class="table table-borderedle" cellspacing="0">
            
            
                <tr> 
                    <th>Codigo</th>
                    <th>Nombre del producto</th>
                    <th>Categoria</th>
                    <th>Stock</th>
                    <th>Precio</th>
                </tr>
                
                
                <%
                    while(rs.next()){
                %>
                <tr>
                    <td><%= rs.getInt("Codigo")  %></td>
                    <td><%= rs.getString("nombreProducto")  %></td>
                    <td><%= rs.getString("Categoria")  %></td>
                    <td><%= rs.getInt("Stock")  %></td>
                    <td><%= rs.getFloat("Precio")  %></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>

        </div>
        
 
            <br>
    </body>
</html>
