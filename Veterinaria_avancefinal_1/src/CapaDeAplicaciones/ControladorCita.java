
package CapaDeAplicaciones;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CapaDeDominio.*;
import Vistas.*;
import Procesos.*;
import CapaDeInfraestructura.*;
public class ControladorCita implements ActionListener{       
        FrmCitas vista;    
    public ControladorCita(FrmCitas f5){        
        vista=f5;
        vista.btnRegistrar.addActionListener(this);
        ProcesosFrmCitas.Presentacion(vista);
    }
    @Override
    public void actionPerformed(ActionEvent e) {        
       if(e.getSource()==vista.btnRegistrar){
              RegistroCitas cit =  ProcesosFrmCitas.LeerCita(vista);
              CRUD_Citas crud = new CRUD_Citas();
              crud.InsertarCita(cit);
              ProcesosFrmCitas.LimpiarEntradas(vista);
       }                
       
    }    
}