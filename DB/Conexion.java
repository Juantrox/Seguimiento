package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {



    public void ConexionDB() {
        String url = "jdbc:mysql://127.0.0.1:3306/gestion";
        String usuario = "root";
        String password = "0000";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("¡Conexión exitosa a la base de datos!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC");
            e.printStackTrace();
        }

    }

    public void cerrarConexion(Connection conexion) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        
    }
}
