package ej_jsiwng_primitiva;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ej_JSiwng_Primitiva {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame login = new JFrame("Primitiva");
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            login.setSize(500, 400);
            login.setResizable(false);

            // Crear el panel con imagen de fondo
            JPanel panel = new BackgroundPanel();

            // Crear y configurar el JLabel (título)
            JLabel titulo = new JLabel("Bienvenido foking pobre", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            titulo.setForeground(Color.WHITE);
            titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
            panel.add(titulo, BorderLayout.NORTH);

            // Panel inferior para "Registrar" e "Iniciar Sesión"
            JButton btnRegistrar = new JButton("Registrar");
            JButton btnLogIn = new JButton("Iniciar Sesión");

            JPanel surPanel = new JPanel();
            surPanel.setOpaque(false);
            surPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

            Font fuenteBoton = new Font("Ubuntu Mono", Font.BOLD, 18);

            for (JButton btn : new JButton[]{btnRegistrar, btnLogIn}) {
                btn.setFont(fuenteBoton);
                btn.setPreferredSize(new Dimension(160, 40));
                surPanel.add(btn);
            }

            // Acciones de los botones
            btnRegistrar.addActionListener(e -> {
                new Registrar().setVisible(true);
                login.dispose(); // cierra la ventana actual
            });
            
            btnLogIn.addActionListener(e -> {
                new LogIn().setVisible(true);
                login.dispose(); // cierra la ventana actual
            });

            panel.add(surPanel, BorderLayout.SOUTH);

            login.setContentPane(panel);
            login.setLocationRelativeTo(null); // Centrar la ventana
            login.setVisible(true);
        });
    }

    // Clase interna para el panel de fondo
    static class BackgroundPanel extends JPanel {

        private BufferedImage backgroundImage;

        public BackgroundPanel() {
            try {
                backgroundImage = ImageIO.read(getClass().getResource("/ej_jsiwng_primitiva/fondo_login.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
