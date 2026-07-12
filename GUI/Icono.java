package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

/**
 * Utilidad para asignar el icono de la aplicación a ventanas y barra de tareas.
 */
public class Icono {

    private static final String DEFAULT_ICON_PATH = "/Logo.png";
    private static final String FALLBACK_ICON_PATH = "/GUI/Logo.png";

    /**
     * Aplica el icono predeterminado a una ventana.
     * @param window Ventana a la que se asignará el icono.
     */
    public static void applyToWindow(Window window) {
        setIcon(window, DEFAULT_ICON_PATH, FALLBACK_ICON_PATH);
    }

    /**
     * Busca un icono en las rutas indicadas y lo asigna a la ventana si existe.
     * @param window Ventana a la que se le aplicará el icono.
     * @param resourcePaths Rutas de recursos donde buscar la imagen del icono.
     */
    public static void setIcon(Window window, String... resourcePaths) {
        if (window == null || resourcePaths == null) {
            return;
        }

        for (String resourcePath : resourcePaths) {
            if (resourcePath == null) {
                continue;
            }

            try (InputStream stream = Icono.class.getResourceAsStream(resourcePath)) {
                if (stream == null) {
                    continue;
                }

                Image icon = ImageIO.read(stream);
                if (icon == null) {
                    continue;
                }

                window.setIconImage(icon);

                if (Taskbar.isTaskbarSupported()) {
                    try {
                        Taskbar.getTaskbar().setIconImage(icon);
                    } catch (UnsupportedOperationException ignored) {
                    }
                }

                return;
            } catch (Exception ignored) {
            }
        }
    }

    public static void IconosMenu(String[] rutasImagenes, JButton... botones) {
        if (botones == null) {
            return;
        }

        for (int i = 0; i < botones.length; i++) {
            JButton boton = botones[i];
            if (boton == null) {
                continue;
            }

            String rutaImagen = (rutasImagenes != null && i < rutasImagenes.length) ? rutasImagenes[i] : null;
            ImageIcon icono = cargarIcono(rutaImagen);

            boton.setText("");
            boton.setIcon(icono);
            boton.setHorizontalAlignment(SwingConstants.CENTER);
            boton.setVerticalAlignment(SwingConstants.CENTER);
            boton.setHorizontalTextPosition(SwingConstants.CENTER);
            boton.setVerticalTextPosition(SwingConstants.CENTER);
            boton.setIconTextGap(0);
            boton.setPreferredSize(new Dimension(32, 32));
            boton.setMinimumSize(new Dimension(32, 32));
            boton.setMaximumSize(new Dimension(32, 32));
            boton.setMargin(new Insets(4, 4, 4, 4));
            boton.setToolTipText("Opción " + (i + 1));
        }
    }

    private static ImageIcon cargarIcono(String... resourcePaths) {
        if (resourcePaths == null) {
            return null;
        }

        for (String resourcePath : resourcePaths) {
            if (resourcePath == null || resourcePath.trim().isEmpty()) {
                continue;
            }

            try {
                BufferedImage image = null;

                String normalizedPath = resourcePath.replace('\\', '/');

                try (InputStream stream = Icono.class.getResourceAsStream(normalizedPath)) {
                    if (stream != null) {
                        image = ImageIO.read(stream);
                    }
                }

                if (image == null) {
                    File file = new File(normalizedPath);
                    if (!file.isAbsolute()) {
                        file = new File(System.getProperty("user.dir"), normalizedPath);
                    }
                    if (file.exists()) {
                        image = ImageIO.read(file);
                    }
                }

                if (image == null) {
                    continue;
                }

                Image scaled = image.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
                return new ImageIcon(scaled);
            } catch (Exception ignored) {
            }
        }

        return null;
    }
}
