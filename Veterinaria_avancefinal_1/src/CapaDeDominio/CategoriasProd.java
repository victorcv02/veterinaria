/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDeDominio;

/**
 *
 * @author MOTITA2204
 */
public class CategoriasProd {
    private int idCategoria;
    private String nombrecat;
    private String descripcion;
    private String indicador;
    
    public CategoriasProd(){}

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombrecat() {
        return nombrecat;
    }

    public void setNombrecat(String nombrecat) {
        this.nombrecat = nombrecat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
    public Object[] RegistroCategoria(int numeracion){
        Object[] fila={numeracion, idCategoria, nombrecat, descripcion};
        return fila;
    }
    
    }
    
