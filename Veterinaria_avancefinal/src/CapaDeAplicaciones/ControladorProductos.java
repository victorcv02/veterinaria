
package CapaDeAplicaciones;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CapaDeDominio.*;
import Vistas.*;
import Procesos.*;
import CapaDeInfraestructura.*;
public class ControladorProductos implements ActionListener{       
    FrmProductos vista;    
    public ControladorProductos(FrmProductos f2){        
        vista=f2;
        vista.btnRegistrar.addActionListener(this);
        ProcesosFrmProductos.Presentacion(vista);
    }
    @Override
    public void actionPerformed(ActionEvent e) {        
       if(e.getSource()==vista.btnRegistrar){
              Productos prod =  ProcesosFrmProductos.LeerProducto(vista);
              CRUD_Productos crud = new CRUD_Productos();
              crud.InsertarProducto(prod);
              ProcesosFrmProductos.LimpiarEntradas(vista);
       }                
       
    }    
}