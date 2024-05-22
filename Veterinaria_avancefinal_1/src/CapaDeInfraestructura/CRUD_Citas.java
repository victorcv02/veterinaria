package CapaDeInfraestructura;
//librerias
import CapaDeDominio.*;
import formato.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Citas extends ConectarBD{
    public CRUD_Citas(){}
    //metodo que inserta un registro a la base de datos
    public void InsertarCita(RegistroCitas cit){
        try{
         ps = conexion.prepareStatement("insert into"
  + " citas(detalleperro,idveterinario,idcliente,precioreserva,"
  + "fechareserva,fechaprogramada,indicador) values (?,?,?,?,?,?,'S');");
          ps.setString(1,cit.getDetalleperro());
          
          ps.setInt(2,cit.getIdvet());
          ps.setInt(3,cit.getIdcli());
          ps.setDouble(4,cit.getPreciocita());
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
          ps.setString(5,sdf.format(cit.getFechareg()));
          ps.setString(6,sdf.format(cit.getFechapro()));
          ps.executeUpdate();
          Mensajes.M1("Cita registrada correctamente");
          conexion.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede puede insertar la cita..."+ex);
        }
    }//fin del metodo   
    //metodo que lista los datos del producto en un JTable
    public void MostrarCitaEnTabla(JTable tabla,String consulta){
        String titulos[]={"Nro","ID Cita","Detalle del Perro","Veterinario","Cliente",
                          "Precio de la reserva","Fecha de Reserva","Fecha Programada"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        int cantreg=0;
        try{
            rs =  st.executeQuery(consulta);
            while(rs.next()){
                cantreg++;
                RegistroCitas cit =  new RegistroCitas();
                cit.setIdcita(rs.getInt(1));
                cit.setDetalleperro(rs.getString(2));
                cit.setIdvet(rs.getInt(3));
                cit.setIdcli(rs.getInt(4));
                cit.setPreciocita(rs.getDouble(5));
                cit.setFechareg(rs.getDate(6));
                cit.setFechapro(rs.getDate(7));
                modelo.addRow(cit.Registro(cantreg));
            }
            conexion.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede mostrar los productos..."+ex);
        }
    }

}