
package utp.desarrollo.producto;

import javax.swing.JOptionPane;


public class SituacionesError {
    
    public void ErrorDatos(String nombre, String cantidad, String id, String precio)
    {
        if (cantidad.equals("")&& id.equals("")&& precio.equals("")&&!nombre.equals(""))
         JOptionPane.showMessageDialog(null,"Ingrese la cantidad , La ID y precio del producto");
                             
        else if (id.equals("") && nombre.equals("")&& precio.equals("")&&!cantidad.equals(""))
        JOptionPane.showMessageDialog(null,"Ingrese el ID , Nombre y precio del producto");
                             
        else if (nombre.equals("") && cantidad.equals("")&& precio.equals("")&&!id.equals(""))
        JOptionPane.showMessageDialog(null,"Ingresar Nombre , Cantidad y Precio del producto");
        
        else if (nombre.equals("") && cantidad.equals("")&& precio.equals("")&&!precio.equals(""))
        JOptionPane.showMessageDialog(null,"Ingresar Nombre , Cantidad y ID del producto");
        
        
        else if (!nombre.equals("") && !cantidad.equals("")&& !id.equals("")&&precio.equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese precio");
            
           else if (nombre.equals("") && cantidad.equals("")&& id.equals("")&& precio.equals(""))   
               JOptionPane.showMessageDialog(null,"Debe llenar todos los campos");
           
           
          else if (nombre.equals(""))
            JOptionPane.showMessageDialog(null,"Debe Introducir un nombre");
        
        else if (cantidad.equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese la cantidad del articulo");
        
        else if (id.equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese el ID del producto");
        
        else if (id.equals(""))
        JOptionPane.showMessageDialog(null,"Debe Introducir el precio");
            
        
        
    }                    
}