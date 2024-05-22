package CapaDeAplicaciones;
//librerias
import Procesos.ProcesosFrmClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import formato.*;
import CapaDeDominio.*;
import Vistas.FrmClientes;
import CapaDeInfraestructura.*;
public class ControladorClientes implements ActionListener {
      FrmClientes vista;
      CRUD_Clientes crud; // c: create r:read  u:update   d=delete    
      Clientes cli;
     public ControladorClientes(FrmClientes f4){ 
         vista=f4;
         vista.jbtnRegistrar.addActionListener(this);
         vista.jbtnEliminar.addActionListener(this);
         vista.jbtnActualizar.addActionListener(this);
         vista.jbtnConsultar.addActionListener(this);
         ProcesosFrmClientes.Presentacion(f4);
         ActualizarForma();
     }//fin constructor
     
     void ActualizarForma(){
        crud = new CRUD_Clientes();
        crud.MostrarCliente(vista.jtblDatos,vista.jlblCantidadregistros);
        ProcesosFrmClientes.Estado1(vista);
        ProcesosFrmClientes.LimpiarEntradas(vista);
     }    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== vista.jbtnRegistrar){
           cli = ProcesosFrmClientes.LeerDatos(vista);
           crud = new CRUD_Clientes();
           crud.InsertarCliente(cli);
           ActualizarForma();
       }//fin registrar
       if(e.getSource()== vista.jbtnConsultar){
           int idcli = Mensajes.M2("Ingrese el ID del cliente a buscar..");
           crud  = new CRUD_Clientes();
           cli =  crud.ConsultarCliente(idcli);
           if(cli==null){
               Mensajes.M1("El id "+idcli+" no existe en la tabla");
           }else{
               vista.jtxtIdcliente.setText(Integer.toString(cli.getIdcli()));
               vista.jtxtIdnicli.setText(cli.getDnicli());
               vista.jtxtnombrecli.setText(cli.getNombrecli());
               vista.jtxtmascotanom.setText(cli.getNombremasco());
               vista.jtxttelefonocli.setText(cli.getTelefonocli());
               vista.jtxtcorreocli.setText(cli.getCorreocli());
               ProcesosFrmClientes.Estado2(vista);
           }
       }//fin consultar
       if(e.getSource()== vista.jbtnActualizar){ 
           cli =  ProcesosFrmClientes.LeerDatos(vista);
           cli.setIdcli(Integer.parseInt(vista.jtxtIdcliente.getText()));
           crud = new CRUD_Clientes();
           crud.ActualizarCliente(cli);
           ActualizarForma();
       }//fin actualizar
       if(e.getSource()== vista.jbtnEliminar){           
           int respuesta = Mensajes.M3("Confirmar!!","¿Desea eliminar el registro?");
           if(respuesta==0){
               int idcli = Integer.parseInt(vista.jtxtIdcliente.getText());
               crud = new CRUD_Clientes();
               crud.EliminarCliente(idcli);
               ActualizarForma();
           }
       }//fin eliminar
    }    
}//fin del class
