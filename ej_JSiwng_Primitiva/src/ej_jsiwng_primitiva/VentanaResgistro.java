package ej_jsiwng_primitiva;

import javax.swing.*;
import java.awt.*;

public class VentanaResgistro extends JFrame {

    public VentanaResgistro() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana

        JLabel label = new JLabel("Pantalla de Registro", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        add(label);
        setVisible(true);
    }
}
