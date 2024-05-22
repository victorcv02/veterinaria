/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDeDominio;
import java.util.Date;
import CapaDeInfraestructura.*;
import java.io.Serializable;
public class Productos {
    private int idprod;
    private String nomprod;
    private int idcat;
    private String cantprod;
    private double precio;
    private Date fechaven;
    private int stock;
    private String ind;
    public Productos(){}
    public Object[] Registro(int num){
        AdministrarClaves ac= new AdministrarClaves();
        String nombrecat=ac.RecuperarNombre(ac.consultanomcat, getIdcat());
        Object[] fila={num, idprod, nomprod, nombrecat, cantprod, precio, fechaven, stock};
        return fila;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getCantprod() {
        return cantprod;
    }

    public void setCantprod(String cantprod) {
        this.cantprod = cantprod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaven() {
        return fechaven;
    }

    public void setFechaven(Date fechaven) {
        this.fechaven = fechaven;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    
}
