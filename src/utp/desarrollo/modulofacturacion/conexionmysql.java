/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utp.desarrollo.modulofacturacion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexionmysql {
    public Connection conexion;
    
    public void conectarDB() throws SQLException{  
        final String controlador ="com.mysql.jdbc.Driver";
        try {
            Class.forName(controlador);
            //final String url_db= "jdbc:mysql://localhost:3306/farmaciaEGPH";
            final String url_db= "jdbc:mysql://localhost:8036/farmaciaEGPH";
            conexion=DriverManager.getConnection(url_db, "Bairon Santos", "@Panama089");
            //JOptionPane.showMessageDialog(null, "Conexion Establecida Correctamente");
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
