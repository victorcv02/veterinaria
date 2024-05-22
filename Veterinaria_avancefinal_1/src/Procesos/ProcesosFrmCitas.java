
package Procesos;
//libreria
import CapaDeDominio.*;
import Vistas.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import CapaDeInfraestructura.*;
public class ProcesosFrmCitas {   
     public static void Presentacion(FrmCitas f4){
        f4.setVisible(true);
        f4.setTitle("Registro de Citas");
        CompletarCombos ac = new CompletarCombos();
        ac.CargarDatos(f4.jcbxdnicli,ac.consultalistacli);
        ac.CargarDatos(f4.jcbxveterinario,ac.consultalistavet);
        Calendar cal = new GregorianCalendar();
        f4.jdchFechaReservacion.setCalendar(cal);
        f4.jdchFechaProgramada.setCalendar(cal);
     }     
     public static void LimpiarEntradas(FrmCitas f4){
         f4.jtxtdetalleperro.setText("");
         f4.jtxtPrecio.setText("");
         f4.jcbxdnicli.setSelectedIndex(0);
         f4.jcbxveterinario.setSelectedIndex(0);
         Calendar cal = new GregorianCalendar();
         f4.jdchFechaReservacion.setCalendar(cal);
         f4.jdchFechaProgramada.setCalendar(cal);
         f4.jtxtdetalleperro.requestFocus();         
     }


     public static RegistroCitas LeerCita(FrmCitas f4){
         RegistroCitas cit = new RegistroCitas();
         cit.setDetalleperro(f4.jtxtdetalleperro.getText());
         cit.setPreciocita(Double.parseDouble(f4.jtxtPrecio.getText()));
         cit.setFechareg(f4.jdchFechaReservacion.getDate()); 
         cit.setFechapro(f4.jdchFechaProgramada.getDate()); 
         
         AdministrarClaves ac1 =  new AdministrarClaves();
         cit.setIdvet(ac1.RecuperarId(ac1.consultaidvet,f4.jcbxveterinario.getSelectedItem().toString()));
         
         AdministrarClaves ac2 =  new AdministrarClaves();
         cit.setIdcli(ac2.RecuperarId(ac2.consultaidcli,f4.jcbxdnicli.getSelectedItem().toString()));                
         return cit;
     }    
}
