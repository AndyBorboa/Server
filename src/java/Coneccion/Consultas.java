/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coneccion;

import beans.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author andre
 */
public class Consultas extends Conexion {
    
    
    public boolean registrar (String nombreProducto, String categoria, int stock, float precio){
        PreparedStatement pst = null;
        
        try{
            String consulta ="insert into productos (nombreProducto,Categoria,Stock,Precio) values (?,?,?,?)";
            pst= getConexion().prepareStatement(consulta);
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
     
     public boolean registrar (String nombreUsuario, String contraseña){
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
}
