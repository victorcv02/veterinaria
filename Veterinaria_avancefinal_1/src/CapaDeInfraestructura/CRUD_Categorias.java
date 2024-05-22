package CapaDeInfraestructura;
//librerias
import formato.ManejadorTablas;
import formato.Mensajes;
import CapaDeDominio.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
public class CRUD_Categorias extends ConectarBD{
   public CRUD_Categorias(){}
   //metodo que muestra en una tabla los datos de Categoria
   public void MostrarCategorias(JTable tabla,JLabel etiqueta){
       String[] titulos={"Num","ID","NOMBRE CATEGORIA","DESCRIPCION"};
       DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
       tabla.setModel(modelo);
       CategoriasProd cat = new CategoriasProd();
       int cantreg=0;
       try{
          rs = st.executeQuery("select idcategoria,nombrecategoria,descripcion,"
                    + "indicador from categorias where indicador='S'");
          while(rs.next()){
              cantreg++;
              cat.setIdCategoria(rs.getInt(1));
              cat.setNombrecat(rs.getString(2));
              cat.setDescripcion(rs.getString(3));
              cat.setIndicador(rs.getString(4));
              modelo.addRow(cat.RegistroCategoria(cantreg));
          }//fin while
          ManejadorTablas.FormatoTablaCategorias(tabla);
          etiqueta.setText("Cantidad de registros : "+cantreg);
          conexion.close();
       }catch(Exception ex){
          Mensajes.M1("ERROR no se puede mostrar categorias..."+ex);
       }
   }//fin del método
   //metodo que inserta una categoria
   public void InsertarCategoria(CategoriasProd cat){
       try{
           ps = conexion.prepareStatement("insert into categorias(nombrecategoria,descripcion,"
                   + "indicador) values(?,?,'S');");
           ps.setString(1,cat.getNombrecat());
           ps.setString(2,cat.getDescripcion());
           ps.executeUpdate();
           Mensajes.M1("Datos insertados correctamente..");
           conexion.close();
       }catch(Exception ex){
             Mensajes.M1("ERROR no se puede insertar."+ex);           
       }
   }//fin método
   //metodo que recupera un categoria por medio del id
   public CategoriasProd ConsultarCategoria(int idcat){
       CategoriasProd cat=null;
       try{
           rs =  st.executeQuery("select idcategoria,nombrecategoria,descripcion,"
                 + "indicador from categorias where indicador='S' and idcategoria="+idcat+";");
           if(rs.next()){
               cat = new CategoriasProd();
               cat.setIdCategoria(rs.getInt(1));
               cat.setNombrecat(rs.getString(2));
               cat.setDescripcion(rs.getString(3));
               cat.setIndicador(rs.getString(4));
           }
       }catch(Exception ex){
           Mensajes.M1("ERROR no se puede consultar el registro.."+ex);
       }
       return cat;
   }//fin del metodo
   //método que actualiza un registro
   public void ActualizarCategoria(CategoriasProd cat){
       try{
           ps =  conexion.prepareStatement("update categorias set nombrecategoria=?,"
                   + "descripcion=? where idcategoria=?");
           ps.setString(1,cat.getNombrecat());
           ps.setString(2,cat.getDescripcion());
           ps.setInt(3,cat.getIdCategoria());
           ps.executeUpdate();
           Mensajes.M1("Datos actualizados correctamente..");
           ps.close();
       }catch(Exception ex){
           Mensajes.M1("ERROR no se puede actualizar el registro.."+ex); 
       }
   }//fin del método   
   //método que elimina un registro
   public void EliminarCategoria(int idcat){
       try{
           ps = conexion.prepareStatement("update categorias set indicador='N'"
                   + " where idcategoria=?;");
           ps.setInt(1, idcat);
           ps.executeUpdate();
           Mensajes.M1("Registro eliminado");
           ps.close();
       }catch(Exception ex){
            Mensajes.M1("ERROR no se puede eliminar el registro.."+ex); 
       }
   }//fin del método   
}//fin class
