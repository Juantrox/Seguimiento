package GUI;

import DB.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel lateral que contiene las opciones del menú principal y cambia el contenido mostrado.
 */
public class Menu extends javax.swing.JPanel implements ActionListener {

    private JPanel mainPanel;
    private final List<JButton> botonesMenu = new ArrayList<>();

    private static final String[][] OPCIONES_MENU = {
            {"opcion1", "Iconos/I1.png"},
            {"opcion2", "Iconos/I2.png"},
            {"opcion3", "Iconos/I3.png"},
            {"Guardar", "Iconos/I6.png"}
    };

    /**
     * Crea el menú y lo enlaza con el panel principal donde se mostrarán las opciones seleccionadas.
     * @param contentPanel Panel principal que se actualizará al pulsar una opción.
     */
    public Menu(JPanel contentPanel) {
        this.mainPanel = contentPanel;

        // Establecer el layout del Menu como BorderLayout
        this.setLayout(new BorderLayout());

        // Panel para las opciones del menú en la parte izquierda
        JPanel panel = new JPanel(new GridLayout(OPCIONES_MENU.length, 1));
        panel.setBackground(new Color(45, 45, 45));

        List<String> rutasImagenes = new ArrayList<>();
        for (String[] opcion : OPCIONES_MENU) {
            JButton boton = new JButton("");
            boton.setActionCommand(opcion[0]);
            boton.addActionListener(this);
            if ("Guardar".equals(opcion[0])) {
                boton.setBackground(Color.GREEN.darker());
            } else {
                PintarBoton(boton);
            }
            panel.add(boton);
            botonesMenu.add(boton);
            rutasImagenes.add(opcion[1]);
        }

        Icono.IconosMenu(rutasImagenes.toArray(new String[0]), botonesMenu.toArray(new JButton[0]));

        // Agregar el panel del menú al panel principal en la parte izquierda
        this.add(panel);
    }

    /**
     * Maneja los clics en los botones del menú y muestra la opción correspondiente.
     * @param e Evento generado al pulsar un botón.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "opcion1":
                MPAdd(new Opciones.Opcion1());
                break;
            case "opcion2":
                MPAdd(new Opciones.Opcion2());
                break;
            case "opcion3":
                MPAdd(new Opciones.Opcion3());
                break;
            case "Guardar":
                Conexion conexion = new Conexion();
                conexion.cerrarConexion(null);
                //System.exit(0);
                break;
            default:
                break;
        }
    }

    /**
     * Reemplaza el contenido mostrado en el panel principal por el panel indicado.
     * @param panel Nuevo panel que se mostrará en el área central.
     */
    public void MPAdd(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * Aplica estilos visuales a un botón del menú.
     * @param miBoton Botón al que se le aplicarán los estilos.
     */
    public void PintarBoton(JButton miBoton) {
        miBoton.setContentAreaFilled(true);
        miBoton.setBorderPainted(false);
        miBoton.setFocusPainted(false);
        miBoton.setOpaque(false);
        miBoton.setBackground(new Color(45, 45, 45));
        miBoton.setForeground(Color.WHITE);
    }
}

