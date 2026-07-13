import GUI.Frame;
import DB.Conexion;

/**
 * Clase principal que inicia la aplicación.
 */
public class Main {
    /**
     * Punto de entrada de la aplicación.
     * Crea la ventana principal y la muestra al usuario.
     */
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.ConexionDB();

        Frame frame = new Frame();
        frame.setVisible(true);

        
    }
}