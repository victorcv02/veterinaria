package CapaDeInfraestructura;
import formato.*;
import javax.swing.JComboBox;
public class CompletarCombos extends ConectarBD{
    public String consultalistacat="select nombrecategoria from categorias"
                                  + " where indicador='S' order by 1;";
    public String consultalistacli="select dnicliente from clientes"
                                  + " where indicador='S' order by 1;";
    public String consultalistavet="select nombreveterinario from veterinarios"
                                  + " where indicador='S' order by 1;";

    //metodo que actualiza los combos
    public void CargarDatos(JComboBox combo,String consulta){
        try{ 
            rs =  st.executeQuery(consulta);
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            rs.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar combos.."+ex);
        }
    }//fin del metodo    
}//fin de la clase
