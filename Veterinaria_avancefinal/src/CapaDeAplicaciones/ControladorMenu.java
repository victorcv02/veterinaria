    package CapaDeAplicaciones;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vistas.*;
import formato.*;
import Principal.*;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
    import java.awt.Dimension;
    import javax.swing.JInternalFrame;

public class ControladorMenu implements ActionListener {
    FormularioMenu  vista;
    public ControladorMenu(FormularioMenu fm){
        vista = fm;
        vista.itemcatprod.addActionListener(this);
        vista.itemprod.addActionListener(this);
        vista.itemprodstock.addActionListener(this);
        vista.mitemRegistroCliente.addActionListener(this);
        vista.mitemRegistroCita.addActionListener(this);
        vista.mitemlistacita.addActionListener(this);
        fm.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
        fm.setVisible(true);
        fm.setTitle("Aplicación para el registro de citas y productos en stock");  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== vista.itemcatprod){
          Main.f1 = new Categorias();
          Main.controlfcat = new ControladorCategorias(Main.f1);          
          vista.jdpnContenedor.add(Main.f1);          
          CentrarForma.CPanel(vista.jdpnContenedor,Main.f1);
      }
      
      if(e.getSource()== vista.itemprod){
          FrmProductos f2 = new FrmProductos();
          ControladorProductos controlf2 =  new ControladorProductos(f2);
          vista.jdpnContenedor.add(f2);
          CentrarForma.CPanel(vista.jdpnContenedor,f2);
      }
      
      if(e.getSource()== vista.itemprodstock){
          ListaProd f3 =  new ListaProd();
          ControladorListaProductos controlf3 = new ControladorListaProductos(f3);
          vista.jdpnContenedor.add(f3);
          CentrarForma.CPanel(vista.jdpnContenedor,f3);
      }
      if(e.getSource()== vista.mitemRegistroCliente){
          Main.f4 = new FrmClientes();
          Main.controlf4 = new ControladorClientes(Main.f4);          
          vista.jdpnContenedor.add(Main.f4);          
          CentrarForma.CPanel(vista.jdpnContenedor,Main.f4);
      }
      
      if(e.getSource()== vista.mitemRegistroCita){
          FrmCitas f5 = new FrmCitas();
          ControladorCita controlf5 =  new ControladorCita(f5);
          vista.jdpnContenedor.add(f5);
          CentrarForma.CPanel(vista.jdpnContenedor,f5);
      }
      
      if(e.getSource()== vista.mitemlistacita){
          FrmListaCitas f6 =  new FrmListaCitas();
          ControladorListaCita controlf6 = new ControladorListaCita(f6);
          vista.jdpnContenedor.add(f6);
          CentrarForma.CPanel(vista.jdpnContenedor,f6);
      }
      
           
      }    
}
       