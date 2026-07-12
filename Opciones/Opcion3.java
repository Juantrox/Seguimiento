package Opciones;

import javax.swing.*;
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
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        JLabel label = new JLabel("Este es un panel personalizado Panel 3", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        PanelT.add(label, BorderLayout.CENTER);

        add(PanelT, BorderLayout.CENTER);
    }
}
