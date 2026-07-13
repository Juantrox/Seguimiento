package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/gestion";
    private static final String usuario = "root";
    private static final String password = "0000";

    public String ConexionDB() {
        String mensaje = "";

        try (Connection conexion = getConnection()) {
            if (conexion != null && !conexion.isClosed()) {
                mensaje = "¡Conexión exitosa a la base de datos!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al conectar a la base de datos";
        }

        return mensaje;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC", e);
        }

        return DriverManager.getConnection(url, usuario, password);
    }

    public void cerrarConexion() {
        try (Connection conexion = getConnection()) {
            if (conexion != null) {
                System.out.println("Conexión cerrada correctamente.");
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión.");
            e.printStackTrace();
        }
    }
}
