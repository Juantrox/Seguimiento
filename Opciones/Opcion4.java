package Opciones;

import javax.swing.*;
import java.awt.*;

/**
 * Panel que representa la cuarta opción del menú principal.
 */
public class Opcion4 extends JPanel {

    /**
     * Crea el contenido visual de la opción 4.
     */
    public Opcion4() {
        setLayout(new BorderLayout());

        JPanel PanelT = new JPanel(new BorderLayout());
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        JLabel label = new JLabel("Este es un panel personalizado Panel 4", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        PanelT.add(label, BorderLayout.CENTER);

        add(PanelT, BorderLayout.CENTER);
    }
}
