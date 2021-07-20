package utp.desarrollo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adrian Albaez
 */
public class Validacion {

    int validarUsuario(String correo, String contra) throws IOException {
        int flag = 0;
        try {
            ConectarBaseDeDatos Con = new ConectarBaseDeDatos();
            Con.conectarDB();
            String sql, correo2 = "", contra2 = "";
            sql = "SELECT correo_electronico,contrasena FROM credenciales";
            PreparedStatement st;
            st = Con.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()) {
                correo2 = resultado.getString(1);
                contra2 = resultado.getString(2);
            }
            resultado.last();
            resultado.close();
            Con.desconectarDB();
            if(!correo.equals(correo2)){
                return 1;
            }
            if (correo.equals(correo2) && contra.equals(contra2)) {
                flag = 2;
            } else {
                flag = 3;
            }
            return flag;
            
        } catch (SQLException ex) {
            return 3;
        }

    }
    
    /*boolean validarUsuario(String correo, String contra) throws IOException {

        try {
            ConectarBaseDeDatos Con = new ConectarBaseDeDatos();
            Con.conectarDB();
            String sql;
            sql = "SELECT * FROM credenciales WHERE correo_electronico = '" + correo + "' AND contrasena = '" + contra + "'=?";
            PreparedStatement st;
            st = Con.conexion.prepareStatement(sql);
            st.setString(1, correo);
            st.setString(2, contra);
            ResultSet resultado = st.executeQuery();
            resultado.last();
            resultado.close();
            Con.desconectarDB();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }*/

}