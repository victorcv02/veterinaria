package CapaDeInfraestructura;
//librerias
import CapaDeDominio.*;
import formato.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Productos extends ConectarBD{
    public CRUD_Productos(){}
    //metodo que inserta un registro a la base de datos
    public void InsertarProducto(Productos prod){
        try{
         ps = conexion.prepareStatement("insert into"
  + " productos(nombreproducto,idcategoria,cantidadproducto,preciounidad,"
  + "fechavencimiento,stock,indicador) values (?,?,?,?,?,?,'S');");
          ps.setString(1,prod.getNomprod());
          
          ps.setInt(2,prod.getIdcat());
          ps.setString(3,prod.getCantprod());
          ps.setDouble(4,prod.getPrecio());
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
          ps.setString(5,sdf.format(prod.getFechaven()));
          ps.setInt(6,prod.getStock());
          ps.executeUpdate();
          Mensajes.M1("Producto registrado correctamente");
          conexion.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede puede insertar el producto..."+ex);
        }
    }//fin del metodo   
    //metodo que lista los datos del producto en un JTable
    public void MostrarProductosEnTabla(JTable tabla,String consulta){
        String titulos[]={"Nro","ID producto","Nombre Producto","Categoria","Cantidad",
                          "Precio","Vencimiento","Stock"};
        DefaultTableModel modelo =  new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
        int cantreg=0;
        try{
            rs =  st.executeQuery(consulta);
            while(rs.next()){
                cantreg++;
                Productos prod =  new Productos();
                prod.setIdprod(rs.getInt(1));
                prod.setNomprod(rs.getString(2));
                prod.setIdcat(rs.getInt(3));
                prod.setCantprod(rs.getString(4));
                prod.setPrecio(rs.getDouble(5));
                prod.setFechaven(rs.getDate(6));
                prod.setStock(rs.getInt(7));
                modelo.addRow(prod.Registro(cantreg));
            }
            conexion.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede mostrar los productos..."+ex);
        }
    }

}