package ej_jsiwng_primitiva;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBaseDatos {
    private static final String URL="jdbc:mysql://158.179.217.53:3306/bd_primitiva";
    private static final String USER="root";
    private static final String PASSWORD="Contraseña#1234";
    
    public static Connection getConnection(){
        Connection conexion=null;
        
        try {
            conexion=DriverManager.getConnection(URL,USER,PASSWORD);

        } catch (SQLException e) {
            System.out.println("Error en la conexion: "+e.getMessage());
        }
        return conexion;
    }
}
