package Opciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import java.awt.*;

/**
 * Panel que representa la tercera opción del menú principal.
 */
public class Opcion3 extends JPanel {

    /**
     * Crea el contenido visual de la opción 3.
     */
    public Opcion3() {
        setLayout(new BorderLayout());

        JPanel PanelT = new JPanel(new BorderLayout());
        JPanel PanelForm = new JPanel(new BorderLayout());

        PanelForm.setBackground(new Color(45, 45, 45));
        PanelForm.add(PanelNorte(), BorderLayout.NORTH);
        PanelForm.add(PanelTabla(), BorderLayout.CENTER);

        // PanelT.setBorder(new EmptyBorder(2,2,2,2));
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        PanelT.add(PanelForm, BorderLayout.CENTER);
        add(PanelT, BorderLayout.CENTER);
    }

    public JPanel PanelNorte() {

        JLabel label = new JLabel("Este es un panel personalizado Panel 3", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);

        JPanel panelNorte = new JPanel(new BorderLayout());

        panelNorte.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelNorte.setBackground(new Color(100, 255, 10));
        panelNorte.add(label, BorderLayout.CENTER);

        add(panelNorte, BorderLayout.CENTER);

        return panelNorte;
    }

    public JScrollPane PanelTabla() {

        String[] columnas = { "ID", "Nombre", "Apellido", "Email" };
        Object[][] datos = {
                { 1, "Juan", "Pérez", "juan.perez@example.com" },
                { 2, "María", "Gómez", "maria.gomez@example.com" }
        };

        JTable Clientes = new JTable(datos, columnas);
        estilotabla(Clientes);

        JScrollPane PanelTabla = new JScrollPane(Clientes);

        PanelTabla.setBackground(new Color(45, 45, 45));

        add(PanelTabla, BorderLayout.CENTER);

        return PanelTabla;
    }

    public void estilotabla(JTable tabla) {
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(new Color(45, 45, 45)); // Azul oscuro
        header.setForeground(Color.WHITE);
        // header.setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabla.setBackground(new Color(45, 45, 45));
        tabla.setForeground(Color.WHITE);
        tabla.setShowGrid(false);
    }
}
