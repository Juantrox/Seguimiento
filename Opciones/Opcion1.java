package Opciones;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que representa la primera opción del menú principal.
 */
public class Opcion1 extends JPanel {

    /**
     * Crea el contenido visual de la opción 1.
     */
    public Opcion1() {
        setLayout(new BorderLayout());

        JPanel PanelT = new JPanel(new BorderLayout());
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        JLabel label = new JLabel("Este es un panel personalizado Panel 1", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        PanelT.add(label, BorderLayout.CENTER);

        add(PanelT, BorderLayout.CENTER);
    }
}
