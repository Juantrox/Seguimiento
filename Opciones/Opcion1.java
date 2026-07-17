package Opciones;

import DB.Escritura;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * Panel que representa la primera opción del menú principal.
 */
public class Opcion1 extends JPanel implements ActionListener {

    private final JPanel panelTop = new JPanel(new BorderLayout());
    private final JPanel panelForm = new JPanel(new BorderLayout());

    private final JTextField txtCliente = new JTextField(20);
    private final JTextField txtCelular = new JTextField(20);
    private final JTextField txtMarca = new JTextField(20);
    private final JTextField txtModelo = new JTextField(20);
    private final JTextField txtDescripcion = new JTextField(20);
    private final JTextField txtEstado = new JTextField(20);
    private final JTextField txtFechaIn = new JTextField(20);
    private final JTextField txtFechaOut = new JTextField(20);
    private final JTextField txtFechaRep = new JTextField(20);
    private final JTextField txtAdquisicion = new JTextField(20);

    /**
     * Crea el contenido visual de la opción 1.
     */
    public Opcion1() {
        setLayout(new BorderLayout());

        panelTop.setBorder(new EmptyBorder(15, 15, 15, 15));
        panelTop.setBackground(new Color(30, 30, 30));
        panelTop.setOpaque(true);

        panelForm.setBackground(new Color(45, 45, 45));
        panelForm.add(crearPanelClientes(), BorderLayout.CENTER);

        panelTop.add(crearPanelNorte(), BorderLayout.NORTH);
        panelTop.add(panelForm, BorderLayout.CENTER);
        add(panelTop, BorderLayout.CENTER);
    }

    private JPanel crearPanelNorte() {

        JButton btnClientes = new JButton("Clientes");
        JButton btnInventario = new JButton("Inventario");

        btnClientes.setForeground(Color.WHITE);
        btnInventario.setForeground(Color.WHITE);

        JPanel panelNorte = new JPanel(new GridLayout(1, 2, 8, 0));
        panelNorte.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelNorte.setBackground(Color.GREEN.darker());

        estiloboton(btnClientes);
        estiloboton(btnInventario);

        btnClientes.setActionCommand("ClientesL");
        btnClientes.addActionListener(this);
        btnInventario.setActionCommand("InventarioL");
        btnInventario.addActionListener(this);

        panelNorte.add(btnClientes);
        panelNorte.add(btnInventario);

        return panelNorte;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "ClientesL":
                mostrarPanel(crearPanelClientes());
                break;
            case "InventarioL":
                mostrarPanel(crearPanelInventario());
                break;
        }
    }

    public void estiloboton(JButton boton) {
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setForeground(Color.WHITE);
        // boton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
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

    private void mostrarPanel(JPanel panel) {
        panelForm.removeAll();
        panelForm.add(panel, BorderLayout.CENTER);
        panelForm.revalidate();
        panelForm.repaint();
    }

    private JPanel crearPanelClientes() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(45, 45, 45));

        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        addCampo(formulario, c, "Cliente:", txtCliente);
        addCampo(formulario, c, "Celular:", txtCelular);
        addCampo(formulario, c, "Marca:", txtMarca);
        addCampo(formulario, c, "Modelo:", txtModelo);
        addCampo(formulario, c, "Descripcion:", txtDescripcion);
        addCampo(formulario, c, "Estado:", txtEstado);
        addCampo(formulario, c, "FechaIn:", txtFechaIn);
        addCampo(formulario, c, "fechaOut:", txtFechaOut);
        addCampo(formulario, c, "FechaRep:", txtFechaRep);
        addCampo(formulario, c, "Adquisicion:", txtAdquisicion);

        JButton btnGuardar = new JButton("Guardar Cliente");
        btnGuardar.setBackground(new Color(67, 160, 71));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(e -> guardarCliente());

        c.gridx = 0;
        c.gridy++;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        formulario.add(btnGuardar, c);

        panel.add(formulario, BorderLayout.NORTH);
        return panel;
    }

    private void addCampo(JPanel panel, GridBagConstraints c, String etiqueta, JTextField campo) {
        JLabel label = new JLabel(etiqueta);
        label.setForeground(Color.WHITE);

        c.gridx = 0;
        panel.add(label, c);

        c.gridx = 1;
        panel.add(campo, c);

        c.gridy++;
    }

    private void guardarCliente() {
        String cliente = txtCliente.getText().trim();
        String celular = txtCelular.getText().trim();
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String estado = txtEstado.getText().trim();
        String fechaIn = txtFechaIn.getText().trim();
        String fechaOut = txtFechaOut.getText().trim();
        String fechaRep = txtFechaRep.getText().trim();
        String adquisicion = txtAdquisicion.getText().trim();

        Escritura escritura = new Escritura();
        boolean ok = escritura.insertarCliente(cliente, celular, marca, modelo, descripcion, estado, fechaIn, fechaOut, fechaRep, adquisicion);

        JOptionPane.showMessageDialog(this,
                ok ? "Cliente guardado correctamente." : "No se pudo guardar el cliente.",
                "Guardar cliente",
                ok ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);

        if (ok) {
            txtCliente.setText("");
            txtCelular.setText("");
            txtMarca.setText("");
            txtModelo.setText("");
            txtDescripcion.setText("");
            txtEstado.setText("");
            txtFechaIn.setText("");
            txtFechaOut.setText("");
            txtFechaRep.setText("");
            txtAdquisicion.setText("");
        }
    }

    private JPanel crearPanelInventario() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(45, 45, 45));
        JLabel label = new JLabel("Contenido de Inventario", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

}
