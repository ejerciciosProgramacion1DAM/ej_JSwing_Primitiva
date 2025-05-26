package ej_jsiwng_primitiva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControlErrores {

    public static String introducirDNI(String dni) {
        String codigo;
        codigo = dni.toUpperCase();
        if (codigo.matches("\\d{8}+[A-Z]")) {
            return codigo;
        }
        return "error";
    }

    //devuelve true si lo encuentra
    public static boolean SQLComprobarCliente(String codigo) throws SQLException {
        try (Connection conexion = ConexionBaseDatos.getConnection()) {
            if (conexion != null) {
                try {
                    PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM tb_datos_usuarios WHERE nif=?");
                    stmt.setString(1, codigo);
                    ResultSet resultado = stmt.executeQuery();
                    while (resultado.next()) {
                        String dni = resultado.getString(1);
                        if (dni.equals(codigo)) {
                            return true;
                        }
                    }
                } catch (SQLException e) {
                    System.out.println("Error. Debe introducir un numero.\n");
                }
            }
        }
        return false;
    }



}
