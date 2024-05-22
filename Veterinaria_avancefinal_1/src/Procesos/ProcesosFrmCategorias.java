
package Procesos;
//librerias
import CapaDeDominio.CategoriasProd;
import Vistas.Categorias;
public class ProcesosFrmCategorias {
    
public static void Presentacion(Categorias f1){
    f1.setTitle("Mantenimiento de Categorías");    
    f1.jtxtIdcategoria.setEnabled(false);
    f1.setVisible(true);
}    
public static void Estado1(Categorias f1){
    f1.jbtnRegistrar.setEnabled(true);
    f1.jbtnConsultar.setEnabled(true);
    f1.jbtnActualizar.setEnabled(false);
   // f1.jbtnEliminar.setEnabled(false);
}
public static void Estado2(Categorias f1){
    f1.jbtnRegistrar.setEnabled(false);
    f1.jbtnConsultar.setEnabled(true);
    f1.jbtnActualizar.setEnabled(true);
   // f1.jbtnEliminar.setEnabled(true);
}
public static void LimpiarEntradas(Categorias f1){
    f1.jtxtIdcategoria.setText("");
    f1.jtxtNombreCategoria.setText("");
    f1.jtxaDescripcion.setText("");
    f1.jtxtNombreCategoria.requestFocus();
}
//metodo que la categoria
public static CategoriasProd LeerDatos(Categorias f1){
         CategoriasProd cat =  new CategoriasProd();         
         cat.setNombrecat(f1.jtxtNombreCategoria.getText());
         cat.setDescripcion(f1.jtxaDescripcion.getText());                  
         return cat;
     }

}//fin del class
