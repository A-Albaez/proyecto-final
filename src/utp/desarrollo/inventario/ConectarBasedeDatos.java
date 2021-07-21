package utp.desarrollo.inventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectarBasedeDatos {
    public Connection conexion;
    
    public void conectarDB() throws SQLException{  
        final String controlador ="com.mysql.jdbc.Driver";
        try {
            Class.forName(controlador);
            final String url_db= "jdbc:mysql://localhost:8042/farmaciaegph";
            conexion=DriverManager.getConnection(url_db, "Aaron", "50l1d5n4k323");
            JOptionPane.showMessageDialog(null, "Conexion Establecida Correctamente");
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(ConectarBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error en la conexion",JOptionPane.ERROR_MESSAGE);    
        }
    }
    public void desconectarDB(){
        
        if (conexion!=null){
            try {
                conexion.close();
            } catch (SQLException ex) {
               // Logger.getLogger(ConectarBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(),"no es posible la desconexion",JOptionPane.ERROR_MESSAGE); 
            }
        }
    }
    
}
