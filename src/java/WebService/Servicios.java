/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Coneccion.Consultas;
import beans.Producto;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author andre
 */
@WebService(serviceName = "Servicios")
public class Servicios {

    /**
     * Web service operation
     */
    Consultas dao = new Consultas();
    @WebMethod(operationName = "listar")
    public List <Producto> listar() {
        List datos = dao.listar();
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregar")
    public String agregar(@WebParam(name = "nombreProducto") String nombreProducto, @WebParam(name = "Categoria") String Categoria, @WebParam(name = "Stock") int Stock, @WebParam(name = "Precio") float Precio) {
        
        String datos = dao.registrar(nombreProducto, Categoria, Stock, Precio);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarClave")
    public Producto listarClave(@WebParam(name = "Clave") int Clave) {
        Producto product = dao.listarClave(Clave);
        
        return product;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualizar")
    public String Actualizar(@WebParam(name = "Clave") int Clave, @WebParam(name = "nombreProducto") String nombreProducto, @WebParam(name = "Categoria") String Categoria, @WebParam(name = "Stock") int Stock, @WebParam(name = "Precio") float Precio) {
        String datos = dao.edit(Clave, nombreProducto, Categoria, Stock, Precio);
        
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminar")
    public Producto eliminar(@WebParam(name = "Clave") int Clave) {
        Producto product = dao.delete(Clave);
        return product;
    }




    
}
