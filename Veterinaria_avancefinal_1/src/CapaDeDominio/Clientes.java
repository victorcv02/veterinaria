/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDeDominio;

/**
 *
 * @author MOTITA2204
 */
public class Clientes {
    private int idcli;
    private String dnicli;
    private String nombrecli;
    private String nombremasco;
    private String telefonocli;
    private String correocli;
    private String indicador;
       public Clientes(){}

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getDnicli() {
        return dnicli;
    }

    public void setDnicli(String dnicli) {
        this.dnicli = dnicli;
    }

    public String getNombrecli() {
        return nombrecli;
    }

    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }

    public String getNombremasco() {
        return nombremasco;
    }

    public void setNombremasco(String nombremasco) {
        this.nombremasco = nombremasco;
    }

    public String getTelefonocli() {
        return telefonocli;
    }

    public void setTelefonocli(String telefonocli) {
        this.telefonocli = telefonocli;
    }

    public String getCorreocli() {
        return correocli;
    }

    public void setCorreocli(String correocli) {
        this.correocli = correocli;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
        public Object[] Registrocliente(int numeracion){
        Object[] fila={numeracion, idcli,dnicli, nombrecli, nombremasco,telefonocli,correocli};
        return fila;
    }
    
    
}
