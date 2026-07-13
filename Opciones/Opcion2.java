package Opciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

/**
 * Panel que representa la segunda opción del menú principal.
 */
public class Opcion2 extends JPanel implements ActionListener {

    private final JPanel PanelT = new JPanel(new BorderLayout());
    private final JPanel PanelForm = new JPanel(new BorderLayout());

    /**
     * Crea el contenido visual de la opción 2.
     */
    public Opcion2() {
        setLayout(new BorderLayout());

        PanelT.setBorder(new EmptyBorder(15, 15, 15, 15));
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        PanelForm.setBackground(new Color(45, 45, 45));

        JLabel label = new JLabel("Este es un panel personalizado Panel 2", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        PanelForm.add(label, BorderLayout.CENTER);

        PanelT.add(PanelNorte(), BorderLayout.NORTH);
        PanelT.add(PanelForm, BorderLayout.CENTER);
        add(PanelT, BorderLayout.CENTER);
    }

    public JPanel PanelNorte() {

        JButton ClintesL = new JButton("Clientes");
        JButton InventarioL = new JButton("Inventario");

        ClintesL.setForeground(Color.WHITE);
        InventarioL.setForeground(Color.WHITE);

        JPanel panelNorte = new JPanel(new GridLayout(1, 2));

        // panelNorte.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelNorte.setBackground(Color.GREEN.darker());

        estiloboton(ClintesL);
        estiloboton(InventarioL);

        ClintesL.setActionCommand("ClientesL");
        ClintesL.addActionListener(this);
        InventarioL.setActionCommand("InventarioL");
        InventarioL.addActionListener(this);

        panelNorte.add(ClintesL, BorderLayout.CENTER);
        panelNorte.add(InventarioL, BorderLayout.CENTER);

        return panelNorte;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case "ClientesL":
                MPAdd(CLientes());
                break;
            case "InventarioL":
                MPAdd(Inventario());
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

    public void MPAdd(JPanel panel) {
        PanelForm.removeAll();
        PanelForm.add(panel, BorderLayout.CENTER);
        PanelForm.revalidate();
        PanelForm.repaint();
    }

    public JPanel CLientes() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(45, 45, 45));
        JLabel label = new JLabel("Contenido de Clientes", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public JPanel Inventario() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(45, 45, 45));
        JLabel label = new JLabel("Contenido de Inventario", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
}
