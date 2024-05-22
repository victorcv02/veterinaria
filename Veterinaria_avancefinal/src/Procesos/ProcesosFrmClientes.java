
package Procesos;
//librerias
import CapaDeDominio.Clientes;
import Vistas.FrmClientes;
public class ProcesosFrmClientes {
    
public static void Presentacion(FrmClientes f3){
    f3.setTitle("Registro de Categorias");    
    f3.jtxtIdcliente.setEnabled(false);
    f3.setVisible(true);
}    
public static void Estado1(FrmClientes f3){
    f3.jbtnRegistrar.setEnabled(true);
    f3.jbtnConsultar.setEnabled(true);
    f3.jbtnActualizar.setEnabled(false);
    f3.jbtnEliminar.setEnabled(false);
}
public static void Estado2(FrmClientes f3){
    f3.jbtnRegistrar.setEnabled(false);
    f3.jbtnConsultar.setEnabled(true);
    f3.jbtnActualizar.setEnabled(true);
    f3.jbtnEliminar.setEnabled(true);
}
public static void LimpiarEntradas(FrmClientes f3){
    f3.jtxtIdcliente.setText("");
    f3.jtxtIdnicli.setText("");
    f3.jtxtnombrecli.setText("");
    f3.jtxtmascotanom.setText("");
    f3.jtxttelefonocli.setText("");
    f3.jtxtcorreocli.setText("");
    f3.jtxtIdnicli.requestFocus();
}
//metodo que la categoria
public static Clientes LeerDatos(FrmClientes f3){
         Clientes cli =  new Clientes();         
         cli.setDnicli(f3.jtxtIdnicli.getText());
         cli.setNombrecli(f3.jtxtnombrecli.getText());    
         cli.setNombremasco(f3.jtxtmascotanom.getText());
         cli.setTelefonocli(f3.jtxttelefonocli.getText());   
         cli.setCorreocli(f3.jtxtcorreocli.getText());
         return cli;
     }

}//fin del class
