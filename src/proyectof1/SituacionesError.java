
package proyectof1;

import javax.swing.JOptionPane;


public class SituacionesError {
    
    public void ErrorDatos(String nombre, String cantidad, String id)
    {
        if (cantidad.equals("")&& id.equals("")&&!nombre.equals(""))
         JOptionPane.showMessageDialog(null,"Ingrese la cantidad y La ID del producto");
                             
        else if (id.equals("") && nombre.equals("")&&!cantidad.equals(""))
        JOptionPane.showMessageDialog(null,"Ingrese el ID del producto y Nombre");
                             
        else if (nombre.equals("") && cantidad.equals("")&&!id.equals(""))
        JOptionPane.showMessageDialog(null,"Ingresar nombre del articulo y Cantidad de activos");
        
        else if (nombre.equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese el nombre del articulo");
        
        else if (cantidad.equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad del articulo");
        
        else if (id.equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese el ID del producto");
            
        else 
         JOptionPane.showMessageDialog(null,"Debe llenar todos los campos");
        
        
    }
    
    
    
    
    
    
}
