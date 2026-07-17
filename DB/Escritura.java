package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Escritura {

    private final Conexion conexion = new Conexion();

    public boolean insertarCliente(
            String cliente,
            String celular,
            String marca,
            String modelo,
            String descripcion,
            String estado,
            String fechaIn,
            String fechaOut,
            String fechaRep,
            String adquisicion) {

        String sql = "INSERT INTO clientes (Cliente, Celular, Marca, Modelo, Descripcion, Estado, FechaIn, fechaOut, FechaRep, Adquisicion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente);
            pstmt.setString(2, celular);
            pstmt.setString(3, marca);
            pstmt.setString(4, modelo);
            pstmt.setString(5, descripcion);
            pstmt.setString(6, estado);
            pstmt.setString(7, fechaIn);
            pstmt.setString(8, fechaOut);
            pstmt.setString(9, fechaRep);
            pstmt.setString(10, adquisicion);

            int filasInsertadas = pstmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al escribir en la base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
}

