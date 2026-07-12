package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

/**
 * Ventana principal de la aplicación con barra de título, menú lateral y contenido central.
 */
public class Frame extends JFrame {

    private int mouseX, mouseY;
    private boolean maximized = false;
    private Rectangle normalBounds;

    /**
     * Construye la ventana principal, configura su apariencia y agrega los componentes visuales.
     */
    public Frame() {

        // Elimina decoraciones del sistema
        setUndecorated(true);

        Icono.applyToWindow(this);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // ===== BARRA DE TÍTULO =====
        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setPreferredSize(new Dimension(0, 40));
        titleBar.setBackground(new Color(45, 45, 45));

        JLabel title = new JLabel("  Mi Aplicación");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Panel de botones del menú de título
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        JButton btnMin = createButton("—");
        JButton btnMax = createButton("O");
        JButton btnClose = createButton("X");

        // Acción minimizar
        btnMin.addActionListener(e ->
                setState(JFrame.ICONIFIED));

        // Acción maximizar/restaurar
        btnMax.addActionListener(e -> {

            if (!maximized) {
                normalBounds = getBounds();

                GraphicsEnvironment ge =
                        GraphicsEnvironment.getLocalGraphicsEnvironment();

                Rectangle bounds =
                        ge.getMaximumWindowBounds();

                setBounds(bounds);

                maximized = true;
            } else {
                setBounds(normalBounds);
                maximized = false;
            }
        });

        // Acción cerrar
        btnClose.addActionListener(e ->
                System.exit(0));

        buttonPanel.add(btnMin);
        buttonPanel.add(btnMax);
        buttonPanel.add(btnClose);

        titleBar.add(title, BorderLayout.WEST);
        titleBar.add(buttonPanel, BorderLayout.EAST);
 
        // ===== ARRASTRAR VENTANA =====
        titleBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        titleBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                if (!maximized) {
                    int x = e.getXOnScreen();
                    int y = e.getYOnScreen();

                    setLocation(
                            x - mouseX,
                            y - mouseY
                    );
                }
            }
        });

        // ===== CONTENIDO CENTRAL =====
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(new Color(30, 30, 30));

        JLabel label = new JLabel("Contenido de la aplicación");
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(label, BorderLayout.CENTER);

        // ===== MENU LATERAL =====
        Menu menu = new Menu(content);
        menu.setBackground(new Color(30, 30, 30));


        mainPanel.add(titleBar, BorderLayout.NORTH);
        mainPanel.add(menu, BorderLayout.WEST);
        mainPanel.add(content, BorderLayout.CENTER);

        add(mainPanel);

        // Actualiza bordes redondeados al redimensionar
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                setShape(new RoundRectangle2D.Double(
                        0, 0,
                        getWidth(),
                        getHeight(),
                        15, 15));
            }
        });
    }

    /**
     * Crea y devuelve un botón estilizado para la barra de título.
     * @param text Texto que se mostrará dentro del botón.
     * @return Botón configurado con el estilo visual de la interfaz.
     */
    private JButton createButton(String text) {

        JButton button = new JButton(text);

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        button.setPreferredSize(new Dimension(50, 40));

        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setOpaque(true);
                button.setBackground(new Color(60, 60, 60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setOpaque(false);
                button.repaint();
            }
        });

        return button;
    }

}