/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coneccion;

import beans.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class Consultas extends Conexion {
    int resp;
    String msj;
    
    
    public String registrar (String nombreProducto, String categoria, int stock, float precio){
        PreparedStatement pst = null;
        
        try{
            String consulta ="insert into productos (nombreProducto,Categoria,Stock,Precio) values (?,?,?,?)";
            pst= getConexion().prepareStatement(consulta);
            pst.setString(1, nombreProducto);
            pst.setString(2, categoria);
            pst.setInt(3, stock);
            pst.setFloat(4, precio);
            
            resp= pst.executeUpdate();
            if(resp==1){
                msj= "Producto Agregado";
                return msj;
            }else{
                msj = "Error";
                return msj;
            }
            
        }catch(Exception ex){
            
        }finally{
            try{
                if(getConexion()!=null) getConexion().close();
                if(pst!=null) pst.close();
                
            }catch(Exception e){
                System.out.println("Error: " +e);
            }
            
        }
        return msj;
    }
    
     public boolean actualizar(int codigo, String nombreProducto, String categoria, int stock, float precio){
            PreparedStatement pst = null;
            
           try{  
	    String sql = "UPDATE productos SET nombreProducto = ?, Categoria = ?, Stock = ?, Precio = ?" + "WHERE Codigo = '"+codigo+"'";
            
            pst= getConexion().prepareStatement(sql);
            pst.setString(1, nombreProducto);
            pst.setString(2, categoria);
            pst.setInt(3, stock);
            pst.setFloat(4, precio);
            
            if(pst.executeUpdate()==1){
                return true;
            }
            
        }catch(Exception ex){
            
        }finally{
            try{
                if(getConexion()!=null) getConexion().close();
                if(pst!=null) pst.close();
                
            }catch(Exception e){
                System.out.println("Error: " +e);
            }
            
        }
        return false;
            
    }
     
     public boolean Eliminar(int Codigo){
        PreparedStatement pst = null;
        String sql = "DELETE FROM productos WHERE Codigo = ?";
        try{
            pst= getConexion().prepareStatement(sql);
            pst.setInt(1, Codigo);
            if(pst.executeUpdate()==1){
                return true;
            }
            
        }catch(Exception ex){
            
        }finally{
            try{
                if(getConexion()!=null) getConexion().close();
                if(pst!=null) pst.close();
                
            }catch(Exception e){
                System.out.println("Error: " +e);
            }
            
        }
        return false;
    }
     
     public boolean autenticacion (String nombreUsuario, String contraseña){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        try{
           String consulta = "select * from usuario where usuario = ? and contraseña = ?"; 
           pst = getConexion().prepareStatement(consulta);
           pst.setString(1, nombreUsuario);
           pst.setString(2, contraseña);
           rs = pst.executeQuery();
           
           if(rs.absolute(1)){
               return true;
           }
           
        }catch(Exception e){
            System.out.println("Error: " +e);
        }finally{
            
            try{
                if(getConexion()!=null) getConexion().close();
                if(pst!=null) pst.close();
                if(rs!=null) rs.close();
                
            }catch(Exception e){
                System.out.println("Error: "+e);
            }
                
            
        }
        return false;
     }
     
     public boolean registrarUsuario (String nombreUsuario, String contraseña){
        PreparedStatement pst = null;
        
        try{
            String consulta ="insert into usuario (usuario,contraseña) values (?,?)";
            pst= getConexion().prepareStatement(consulta);
            pst.setString(1, nombreUsuario);
            pst.setString(2, contraseña);
        
            
            
            if(pst.executeUpdate()==1){
                return true;
            }
            
        }catch(Exception ex){
            
        }finally{
            try{
                if(getConexion()!=null) getConexion().close();
                if(pst!=null) pst.close();
                
            }catch(Exception e){
                System.out.println("Error: " +e);
            }
            
        }
        return false;
    }

     
     public boolean actualizarUsuario(String usuario, String contraseña, String nuevaContraseña){
            PreparedStatement pst = null;
            
           try{  
	    String sql = "UPDATE usuario SET contraseña = ?" + "WHERE usuario = '"+usuario+"' AND contraseña = '"+contraseña+"'" ;
            
            pst= getConexion().prepareStatement(sql);
            pst.setString(1, nuevaContraseña);
            
            if(pst.executeUpdate()==1){
                return true;
            }
            
        }catch(Exception ex){
            
        }finally{
            try{
                if(getConexion()!=null) getConexion().close();
                if(pst!=null) pst.close();
                
            }catch(Exception e){
                System.out.println("Error: " +e);
            }
            
        }
        return false;
            
    }
     
     public List listar(){
         PreparedStatement pst = null;
         ResultSet rs = null;
         List<Producto> datos = new ArrayList<>();
         
         try{
             String sql ="select * from productos";
             pst = getConexion().prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                 Producto p = new Producto();
                 p.setCodigo(rs.getInt("Codigo"));
                 p.setNombreProducto(rs.getString("nombreProducto"));
                 p.setCategoria(rs.getString("Categoria"));
                 p.setStock(rs.getInt("Stock"));
                 p.setPrecio(rs.getFloat("Precio"));
                 datos.add(p);
             }
         
         }catch(Exception e){
            System.out.println("Error: " +e);
         }finally{
             
             try{
                 if(getConexion()!=null) getConexion().close();
                 if(rs!=null) rs.close();
             }catch(Exception e){
                 System.out.println("Error: "+e);
             }
         }
         return datos;
     }
     
     public Producto listarClave(int Codigo){
         PreparedStatement pst = null;
         ResultSet rs = null;
         Producto p = new Producto();
         
         try{
             String sql = "select * from productos where Codigo="+Codigo;
             pst = getConexion().prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
                 p.setCodigo(rs.getInt("Codigo"));
                 p.setNombreProducto(rs.getString("nombreProducto"));
                 p.setCategoria(rs.getString("Categoria"));
                 p.setStock(rs.getInt("Stock"));
                 p.setPrecio(rs.getFloat("Precio"));
             }
         
         }catch(Exception e){
            System.out.println("Error: " +e);
         }finally{
             
             try{
                 if(getConexion()!=null) getConexion().close();
                 if(rs!=null) rs.close();
             }catch(Exception e){
                 System.out.println("Error: "+e);
             }
         }
         return p; 
     }
     
     public String edit(int Clave, String nombreProducto, String Categoria, int Stock, float Precio){
         PreparedStatement pst = null;
         ResultSet rs = null;
         String sql="UPDATE productos SET nombreProducto=?, Categoria=?, Stock=?, Precio=? WHERE Codigo="+Clave;
         try{
             pst = getConexion().prepareStatement(sql);
             pst.setString(1, nombreProducto);
             pst.setString(2, Categoria);
             pst.setInt(3, Stock);
             pst.setFloat(4, Precio);
             
             resp = pst.executeUpdate();
             if(resp==1){
                 msj="Usuario Actualizado";
             }else{
                 msj="Error";
             }
         }catch (Exception e){
             
         }
         
         return msj;
     }
         
     
}
