package CapaDeAplicaciones;
//librerias
import Procesos.ProcesosFrmCategorias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import formato.*;
import CapaDeDominio.*;
import Vistas.Categorias;
import CapaDeInfraestructura.*;
public class ControladorCategorias implements ActionListener {
      Categorias vista;
      CRUD_Categorias crud; // c: create r:read  u:update   d=delete    
      CategoriasProd cat;
     public ControladorCategorias(Categorias f1){ 
         vista=f1;
         vista.jbtnRegistrar.addActionListener(this);
        // vista.jbtnEliminar.addActionListener(this);
         vista.jbtnActualizar.addActionListener(this);
         vista.jbtnConsultar.addActionListener(this);
         ProcesosFrmCategorias.Presentacion(f1);
         ActualizarForma();
     }//fin constructor
     
     void ActualizarForma(){
        crud = new CRUD_Categorias();
        crud.MostrarCategorias(vista.jtblDatos,vista.jlblCantidadregistros);
        ProcesosFrmCategorias.Estado1(vista);
        ProcesosFrmCategorias.LimpiarEntradas(vista);
     }    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== vista.jbtnRegistrar){
           cat = ProcesosFrmCategorias.LeerDatos(vista);
           crud = new CRUD_Categorias();
           crud.InsertarCategoria(cat);
           ActualizarForma();
       }//fin registrar
       if(e.getSource()== vista.jbtnConsultar){
           int idcat = Mensajes.M2("Ingrese el ID de la categoria a buscar..");
           crud  = new CRUD_Categorias();
           cat =  crud.ConsultarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El id "+idcat+" no existe en la tabla");
           }else{
               vista.jtxtIdcategoria.setText(Integer.toString(cat.getIdCategoria()));
               vista.jtxtNombreCategoria.setText(cat.getNombrecat());
               vista.jtxaDescripcion.setText(cat.getDescripcion());
               ProcesosFrmCategorias.Estado2(vista);
           }
       }//fin consultar
       if(e.getSource()== vista.jbtnActualizar){ 
           cat =  ProcesosFrmCategorias.LeerDatos(vista);
           cat.setIdCategoria(Integer.parseInt(vista.jtxtIdcategoria.getText()));
           crud = new CRUD_Categorias();
           crud.ActualizarCategoria(cat);
           ActualizarForma();
       }//fin actualizar
    //   if(e.getSource()== vista.jbtnEliminar){           
      //     int respuesta = Mensajes.M3("Confirmar!!","¿Desea eliminar el registro?");
        //   if(respuesta==0){
          //     int idcat = Integer.parseInt(vista.jtxtIdcategoria.getText());
            //   crud = new CRUD_Categorias();
              // crud.EliminarCategoria(idcat);
               //ActualizarForma();
           //}
       //}//fin eliminar
    }    
}//fin del class
