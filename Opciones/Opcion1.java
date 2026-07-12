package Opciones;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.time.LocalDate;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        JPanel PanelForm = new JPanel(new BorderLayout());

        PanelT.setBorder(new EmptyBorder(15,15,15,15));
        PanelForm.setBackground(new Color(45,45,45));
        PanelT.setBackground(new Color(30, 30, 30));
        PanelT.setOpaque(true);

        JLabel label = new JLabel("Este es un panel personalizado Panel 1", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        PanelForm.add(label, BorderLayout.CENTER);

        PanelT.add(PanelForm, BorderLayout.CENTER);
        add(PanelT, BorderLayout.CENTER);
    }

    void creacion()
    {
        LocalDate Nombre = LocalDate.now();

        Archivos.Archivos archivo = new Archivos.Archivos();
        ObjectMapper mapper = new ObjectMapper();


        try {
            mapper.writeValue(new File(Nombre + ".json"), archivo);
            System.out.println("Archivo creado: " + Nombre + ".json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
