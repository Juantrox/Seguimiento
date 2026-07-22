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
public class Opcion3 extends JPanel implements ActionListener {

    private final JPanel panelForm = new JPanel(new BorderLayout());

    /**
     * Crea el contenido visual de la opción 3.
     */
    public Opcion3() {
        setLayout(new BorderLayout());

        JPanel PanelT = new JPanel(new BorderLayout());

        panelForm.setBackground(new Color(45, 45, 45));
        panelForm.add(PanelNorte(), BorderLayout.NORTH);
        panelForm.add(PanelTablaC(), BorderLayout.CENTER);
        panelForm.add(PanelSur(), BorderLayout.SOUTH);

        // PanelT.setBorder(new EmptyBorder(2,2,2,2));
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        PanelT.add(panelForm, BorderLayout.CENTER);
        add(PanelT, BorderLayout.CENTER);
    }


    //Usar panel norte para revisar las tablas de clientes e inventario

    public JPanel PanelNorte() {

        JButton ClintesL = new JButton("Clientes");
        JButton InventarioL = new JButton("Inventario");

        ClintesL.setForeground(Color.WHITE);
        InventarioL.setForeground(Color.WHITE);

        JPanel panelNorte = new JPanel(new GridLayout(1, 2));

        panelNorte.setBackground(Color.GREEN.darker());

        estiloboton(ClintesL);
        estiloboton(InventarioL);

        ClintesL.setActionCommand("ClientesL");
        ClintesL.addActionListener(this);
        InventarioL.setActionCommand("InventarioL");
        InventarioL.addActionListener(this);

        panelNorte.add(ClintesL);
        panelNorte.add(InventarioL);

        return panelNorte;
    }

        public void estiloboton(JButton boton) {
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setForeground(Color.WHITE);
        boton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setOpaque(true);
                boton.setBackground(new Color(60, 60, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setOpaque(false);
                boton.repaint();
            }
        });
    }

    //Limpiar y acoplar tabla a la base de datos de clientes (Crear otra tabla para la base de datos de inventario)

    public JScrollPane PanelTablaC() {

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

        PanelSur.add(label);
        PanelSur.add(label2);
        PanelSur.add(label3);

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

    // Gestionar eventos para los botones del panel norte

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "ClientesL":
                panelForm.removeAll();
                panelForm.add(PanelNorte(), BorderLayout.NORTH);
                panelForm.add(PanelTablaC(), BorderLayout.CENTER);
                panelForm.add(PanelSur(), BorderLayout.SOUTH);
                panelForm.revalidate();
                panelForm.repaint();
                break;
            case "InventarioL":
                panelForm.removeAll();
                panelForm.add(PanelNorte(), BorderLayout.NORTH);
                panelForm.add(PanelInventario(), BorderLayout.CENTER);
                panelForm.add(PanelSur(), BorderLayout.SOUTH);
                panelForm.revalidate();
                panelForm.repaint();
                break;
        }
    }

    private JPanel PanelInventario() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(45, 45, 45));
        JLabel label = new JLabel("Contenido de Inventario", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
