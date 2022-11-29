/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author andre
 */
public class Producto {
    int codigo;
    String nombreProducto;
    String categoria;
    int stock;
    float precio;

    public Producto() {
    }

    public Producto(int codigo, String nombreProducto, String categoria, int stock, float precio) {
        this.codigo = codigo;
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

   public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
  
    
    
    
    
    
    
}

