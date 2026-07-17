package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lectura {

    private final Conexion conexion = new Conexion();

    public List<String[]> ejecutarConsulta(String sql, Object... params) {
        List<String[]> filas = new ArrayList<>();

        try (Connection conn = conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                ResultSetMetaData meta = rs.getMetaData();
                int columnas = meta.getColumnCount();

                while (rs.next()) {
                    String[] fila = new String[columnas];
                    for (int i = 0; i < columnas; i++) {
                        fila[i] = rs.getString(i + 1);
                    }
                    filas.add(fila);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de lectura de datos: " + e.getMessage());
            e.printStackTrace();
        }

        return filas;
    }

    public List<String[]> leerClientes() {
        String sql = "SELECT Id, Cliente, Celular, Marca, Modelo, Descripcion, Estado, FechaIn, fechaOut, FechaRep, Adquisicion FROM clientes";
        return ejecutarConsulta(sql);
    }

    public List<String[]> leerInventario() {
        String sql = "SELECT id, nombre, cantidad, fecha_ingreso FROM inventario";
        return ejecutarConsulta(sql);
    }

}
