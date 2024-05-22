/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDeDominio;

import java.util.Date;
import CapaDeInfraestructura.*;
public class RegistroCitas {
    private int idcita;
    private String detalleperro;
    private int idcli;
    private int idvet;
    private double preciocita;
    private Date fechareg;
    private Date fechapro;
    private String ind;
    public RegistroCitas(){}
        public Object[] Registro(int num){
        AdministrarClaves ac1= new AdministrarClaves();
        String nombrevet=ac1.RecuperarNombre(ac1.consultanomvet, getIdvet());
        AdministrarClaves ac2= new AdministrarClaves();
        String nombrecli=ac2.RecuperarNombre(ac2.consultadnicli, getIdcli());
        Object[] fila={num, idcita, detalleperro, nombrevet,nombrecli , preciocita, fechareg, fechapro};
        return fila;
    }

    public int getIdcita() {
        return idcita;
    }

    public void setIdcita(int idcita) {
        this.idcita = idcita;
    }

    public String getDetalleperro() {
        return detalleperro;
    }

    public void setDetalleperro(String detalleperro) {
        this.detalleperro = detalleperro;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public int getIdvet() {
        return idvet;
    }

    public void setIdvet(int idvet) {
        this.idvet = idvet;
    }

    public double getPreciocita() {
        return preciocita;
    }

    public void setPreciocita(double preciocita) {
        this.preciocita = preciocita;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public Date getFechapro() {
        return fechapro;
    }

    public void setFechapro(Date fechapro) {
        this.fechapro = fechapro;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }
    
}
