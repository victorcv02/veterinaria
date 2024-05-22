package CapaDeInfraestructura;
import formato.*;
public class AdministrarClaves extends ConectarBD{
    public AdministrarClaves(){}
    //definiendo las consultas para el manejos de claves
    public String consultanomvet="select nombreveterinario from veterinarios where idveterinario=?;";
    public String consultaidvet="select idveterinario from veterinarios where nombreveterinario=?;";
    public String consultadnicli ="select dnicliente from clientes where idcliente=?;";
    public String consultaidcli = "select idcliente from clientes where dnicliente=?;";
    public String consultanomcat ="select nombrecategoria from categorias where idcategoria=?;";
    public String consultaidcat = "select idcategoria from categorias where nombrecategoria=?;";
    //metodo que retorna el nombre del id de la clave foranea
    public String RecuperarNombre(String consulta,int parametro){
        String nombre="";
        try{  ps = conexion.prepareStatement(consulta);
              ps.setInt(1, parametro);
              rs = ps.executeQuery();
             if(rs.next()){
                 nombre =  rs.getString(1);
             }
             conexion.close();
        }catch(Exception ex){
           Mensajes.M1("ERROR no se puede mostrar el nombre "+ex);
        }
        return nombre;
    }//fin del metodo
    //metodo que retorna el id de acuerdo al nombre de la clave
    public int RecuperarId(String consulta,String parametro){
        int id=0;
        try{ ps = conexion.prepareStatement(consulta);
             ps.setString(1, parametro);
            rs = ps.executeQuery();
            if(rs.next()){ id =  rs.getInt(1); }
            conexion.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede recuperar el ID.."+ex);
        }
        return id;
    }//fin del método    
}//fin de la clase
