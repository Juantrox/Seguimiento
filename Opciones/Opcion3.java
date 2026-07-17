package Opciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.*;

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
        PanelForm.add(PanelSur(), BorderLayout.SOUTH);

        // PanelT.setBorder(new EmptyBorder(2,2,2,2));
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        PanelT.add(PanelForm, BorderLayout.CENTER);
        add(PanelT, BorderLayout.CENTER);
    }


    //Usar panel norte para revisar las tablas de clientes e inventario

    public JPanel PanelNorte() {

        JLabel label = new JLabel("Este es un panel personalizado Panel 3", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);

        JPanel panelNorte = new JPanel(new BorderLayout());

        panelNorte.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelNorte.setBackground(new Color(100, 255, 10));
        panelNorte.add(label, BorderLayout.CENTER);

        return panelNorte;
    }

    //Limpiar y acoplar tabla a la base de datos de clientes (Crear otra tabla para la base de datos de inventario)

    public JScrollPane PanelTabla() {

        String[] columnas = { "Id", "Cliente", "Celular", "Marca", "Modelo", "Descripcion", "Estado", "FechaIn", "fechaOut", "FechaRep", "Adquisicion" };
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        DB.Lectura lectura = new DB.Lectura();
        java.util.List<String[]> datos = lectura.leerClientes();

        for (String[] fila : datos) {
            model.addRow(fila);
        }

        JTable Clientes = new JTable(model);
        estilotabla(Clientes);

        JScrollPane PanelTabla = new JScrollPane(Clientes);
        PanelTabla.setBackground(new Color(45, 45, 45));

        return PanelTabla;
    }

    public JPanel PanelSur()
    {

        //Crear opciones de la barra y reestilizar

        JLabel label = new JLabel("Filtro (Lista desplegable)",SwingConstants.CENTER);
        JLabel label2 = new JLabel("Busqueda(JTexfild)",SwingConstants.CENTER);
        JLabel label3 = new JLabel("Boton buscar",SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label2.setForeground(Color.WHITE);
        label3.setForeground(Color.WHITE);

        JPanel PanelSur = new JPanel(new GridLayout(1,3));

        PanelSur.setBorder(new EmptyBorder(2,2,2,2));

        PanelSur.setBackground(new Color(45,45,45));

        PanelSur.add(label, BorderLayout.CENTER);
        PanelSur.add(label2, BorderLayout.CENTER);
        PanelSur.add(label3, BorderLayout.CENTER);

        add(PanelSur,BorderLayout.CENTER);

        return PanelSur;
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

        //Gestionar eventos para los filtros de la barra sur

        public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "x":
             //   MPAdd();
                break;
            case "y":
            //    MPAdd();
                break;
        }
    }

        public void MPAdd(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        }
}
