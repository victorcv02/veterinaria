package CapaDeAplicaciones;
import Vistas.FrmListaCitas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CapaDeInfraestructura.*;
import formato.ManejadorTablas;
import formato.Mensajes;
import javax.swing.JOptionPane;
public class ControladorListaCita implements ActionListener{
    FrmListaCitas vista;
    int posicion;
    String consulta = "select * from citas where indicador='S'";
    CRUD_Citas crud;  // agregar esta linea 
    public ControladorListaCita(FrmListaCitas f6){
        vista=f6;      
        vista.btnOrdenar.addActionListener(this);
        vista.setVisible(true);        
        ActualizarTabla(); //agregar esta linea
    }
    void ActualizarTabla(){
        crud = new CRUD_Citas();
        crud.MostrarCitaEnTabla(vista.jtblListaProductos,consulta+" order by 2;");
        ManejadorTablas.FormatoTablaCitas(vista.jtblListaProductos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnOrdenar){          
        }          
    }   
}
