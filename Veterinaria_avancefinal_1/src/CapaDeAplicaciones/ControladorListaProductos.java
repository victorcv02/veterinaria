package CapaDeAplicaciones;
import Vistas.ListaProd;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CapaDeInfraestructura.*;
import formato.ManejadorTablas;
import formato.Mensajes;
import javax.swing.JOptionPane;
public class ControladorListaProductos implements ActionListener{
    ListaProd vista;
    int posicion;
    String consulta = "select * from productos where indicador='S'";
    CRUD_Productos crud;  // agregar esta linea 
    public ControladorListaProductos(ListaProd f3){
        vista=f3;      
        vista.btnOrdenar.addActionListener(this);
        vista.setVisible(true);        
        ActualizarTabla(); //agregar esta linea
    }
    void ActualizarTabla(){
        crud = new CRUD_Productos();
        crud.MostrarProductosEnTabla(vista.jtblListaProductos,consulta+" order by 2;");
        ManejadorTablas.FormatoTablaProductos(vista.jtblListaProductos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnOrdenar){          
        }          
    }   
}
