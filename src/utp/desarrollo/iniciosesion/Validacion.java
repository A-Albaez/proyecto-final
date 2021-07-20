package utp.desarrollo.iniciosesion;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utp.desarrollo.ConectarBaseDeDatos;

/**
 *
 * @author Adrian Albaez
 */
public class Validacion {

    boolean validarUsuario(String correo, String contra) throws IOException {

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

    }

}