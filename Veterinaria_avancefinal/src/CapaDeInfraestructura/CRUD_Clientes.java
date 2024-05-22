package CapaDeInfraestructura;
//librerias
import formato.ManejadorTablas;
import formato.Mensajes;
import CapaDeDominio.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
public class CRUD_Clientes extends ConectarBD{
   public CRUD_Clientes(){}
   //metodo que muestra en una tabla los datos de Categoria
   public void MostrarCliente(JTable tabla,JLabel etiqueta){
       String[] titulos={"Num","ID","DNI","NOMBRE CLIENTE","NOMBRE MASCOTA","TELEFONO","CORREO ELECTRÓNICO"};
       DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
       tabla.setModel(modelo);
       Clientes cli = new Clientes();
       int cantreg=0;
       try{
          rs = st.executeQuery("select idcliente,dnicliente,nombrecliente,nombremascota,telefonocliente,correocliente,"
                    + "indicador from clientes where indicador='S'");
          while(rs.next()){
              cantreg++;
              cli.setIdcli(rs.getInt(1));
              cli.setDnicli(rs.getString(2));
              cli.setNombrecli(rs.getString(3));
              cli.setNombremasco(rs.getString(4));
              cli.setTelefonocli(rs.getString(5));
              cli.setCorreocli(rs.getString(6));
              cli.setIndicador(rs.getString(7));
              modelo.addRow(cli.Registrocliente(cantreg));
          }//fin while
          ManejadorTablas.FormatoTablaClientes(tabla);
          etiqueta.setText("Cantidad de registros : "+cantreg);
          conexion.close();
       }catch(Exception ex){
          Mensajes.M1("ERROR no se puede mostrar categorias..."+ex);
       }
   }//fin del método
   //metodo que inserta una categoria
   public void InsertarCliente(Clientes cli){
       try{
           ps = conexion.prepareStatement("insert into clientes(dnicliente,nombrecliente,nombremascota,telefonocliente,correocliente,"
                   + "indicador) values(?,?,?,?,?,'S');");
           ps.setString(1,cli.getDnicli());
           ps.setString(2,cli.getNombrecli());
           ps.setString(3,cli.getNombremasco());
           ps.setString(4,cli.getTelefonocli());
           ps.setString(5,cli.getCorreocli());
           ps.executeUpdate();
           Mensajes.M1("Datos insertados correctamente..");
           conexion.close();
       }catch(Exception ex){
             Mensajes.M1("ERROR no se puede insertar."+ex);           
       }
   }//fin método
   //metodo que recupera un categoria por medio del id
   public Clientes ConsultarCliente(int idcli){
       Clientes cli=null;
       try{
           rs =  st.executeQuery("select idcliente,dnicliente,nombrecliente,nombremascota,telefonocliente,correocliente,"
                 + "indicador from clientes where indicador='S' and idcliente="+idcli+";");
           if(rs.next()){
               cli = new Clientes();
               cli.setIdcli(rs.getInt(1));
               cli.setDnicli(rs.getString(2));
               cli.setNombrecli(rs.getString(3));
               cli.setNombremasco(rs.getString(4));
               cli.setTelefonocli(rs.getString(5));
               cli.setCorreocli(rs.getString(6));
               cli.setIndicador(rs.getString(7));
           }
       }catch(Exception ex){
           Mensajes.M1("ERROR no se puede consultar el registro.."+ex);
       }
       return cli;
   }//fin del metodo
   //método que actualiza un registro
   public void ActualizarCliente(Clientes cli){
       try{
           ps =  conexion.prepareStatement("update clientes set dnicliente=?,nombrecliente=?,nombremascota=?,telefonocliente=?,"
                   + "correocliente=? where idcliente=?");
           ps.setString(1,cli.getDnicli());
           ps.setString(2,cli.getNombrecli());
           ps.setString(3,cli.getNombremasco());
           ps.setString(4,cli.getTelefonocli());
           ps.setString(5,cli.getCorreocli());
           ps.setInt(6,cli.getIdcli());
           ps.executeUpdate();
           Mensajes.M1("Datos actualizados correctamente..");
           ps.close();
       }catch(Exception ex){
           Mensajes.M1("ERROR no se puede actualizar el registro.."+ex); 
       }
   }//fin del método   
   //método que elimina un registro
   public void EliminarCliente(int idcli){
       try{
           ps = conexion.prepareStatement("update clientes set indicador='N'"
                   + " where idcliente=?;");
           ps.setInt(1, idcli);
           ps.executeUpdate();
           Mensajes.M1("Registro eliminado");
           ps.close();
       }catch(Exception ex){
            Mensajes.M1("ERROR no se puede eliminar el registro.."+ex); 
       }
   }//fin del método   
}//fin class
