
package Procesos;
//libreria
import CapaDeDominio.*;
import Vistas.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import CapaDeInfraestructura.*;
public class ProcesosFrmProductos {   
     public static void Presentacion(FrmProductos f2){
        f2.setVisible(true);
        f2.setTitle("Registro de Producto");
        CompletarCombos ac = new CompletarCombos();
        ac.CargarDatos(f2.jcbxCategoria,ac.consultalistacat);
        Calendar cal = new GregorianCalendar();
        f2.jdchFechaVencimiento.setCalendar(cal);
     }     
     public static void LimpiarEntradas(FrmProductos f2){
         f2.jtxtNombreProducto.setText("");
         f2.jtxtCantidadProducto.setText("");
         f2.jtxtPrecio.setText("");
         f2.jcbxCategoria.setSelectedIndex(0);
         Calendar cal = new GregorianCalendar();
         f2.jdchFechaVencimiento.setCalendar(cal);
         f2.jspnStock.setValue(0);
         f2.jtxtNombreProducto.requestFocus();         
     }


     public static Productos LeerProducto(FrmProductos f2){
         Productos prod = new Productos();
         prod.setNomprod(f2.jtxtNombreProducto.getText());
         prod.setCantprod(f2.jtxtCantidadProducto.getText());
         prod.setPrecio(Double.parseDouble(f2.jtxtPrecio.getText()));
         prod.setStock(Integer.parseInt(f2.jspnStock.getValue().toString()));
         prod.setFechaven(f2.jdchFechaVencimiento.getDate());         
         AdministrarClaves ac =  new AdministrarClaves();
         prod.setIdcat(ac.RecuperarId(ac.consultaidcat,f2.jcbxCategoria.getSelectedItem().toString()));                  
         return prod;
     }    
}
