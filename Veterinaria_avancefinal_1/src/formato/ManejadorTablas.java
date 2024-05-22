
package formato;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
public class ManejadorTablas {
    
    //Metodo que especifica un ancho de las columnas de tabla    
    public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
    
    //metodo que justifica los datos de una columna
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   
   public static void FormatoTablaCategorias(JTable tabla){
       AnchoColumnas(tabla,0,0);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,100);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,250);
       AnchoColumnas(tabla,3,500);      
   }
   
   public static void FormatoTablaProductos(JTable tabla){
       AnchoColumnas(tabla,0,0);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,400);
       AnchoColumnas(tabla,3,250);  
       AnchoColumnas(tabla,4,250);  
       AnchoColumnas(tabla,5,250);  
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,120);
       JustificarCelda(tabla,6);
       AnchoColumnas(tabla,7,120);
       JustificarCelda(tabla,7);
   }
   public static void FormatoTablaClientes(JTable tabla){
       AnchoColumnas(tabla,0,0);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,50);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,150);
       AnchoColumnas(tabla,3,150);      
              AnchoColumnas(tabla,4,150);
       AnchoColumnas(tabla,5,150);  
              AnchoColumnas(tabla,6,200);

       
   }
   
   //metodo que da formato al JTable de la tabla Productos
   public static void FormatoTablaCitas(JTable tabla){
       AnchoColumnas(tabla,0,0);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,400);
       AnchoColumnas(tabla,3,250);  
       AnchoColumnas(tabla,4,250);  
       AnchoColumnas(tabla,5,250);  
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,120);
       JustificarCelda(tabla,6);
       AnchoColumnas(tabla,7,120);
       JustificarCelda(tabla,7);
   }
   
   
}
