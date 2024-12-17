package gui;

import javax.swing.*;
import java.awt.*;

public class Jugar extends JFrame {
    private static final Color FONDO = new Color(93, 93, 110);

    public Jugar() {
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(new GridLayout(1, 3)); // Divide la ventana en 3 columnas

        // Crear paneles para cada columna
        JPanel columna1 = crearColumna("Jugador 1");
        JPanel columna2 = new JPanel(); // Panel vacío para la columna central
        columna2.setBackground(FONDO); // Mantener el color de fondo
        JPanel columna3 = crearColumna("Jugador 2");

        // Añadir paneles a la ventana
        add(columna1);
        add(columna2);
        add(columna3);

        setVisible(true);
    }

    private JPanel crearColumna(String nombre) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);

        // Norte: JLabel grande
        JLabel titulo = new JLabel(nombre, SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(100, 80)); // Altura controlada
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titulo, BorderLayout.NORTH);

        // Sur: Botones y JLabel
        JPanel surPanel = new JPanel();
        surPanel.setLayout(new BoxLayout(surPanel, BoxLayout.Y_AXIS));
        surPanel.setBackground(FONDO);

        JButton btnAtaque = new JButton("Ataque");
        JButton btnDefensa = new JButton("Defensa");
        JLabel labelInfo = new JLabel("Información", SwingConstants.CENTER);
        labelInfo.setForeground(Color.WHITE);

        // Espaciado entre componentes
        btnAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        surPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio arriba
        surPanel.add(btnAtaque);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
        surPanel.add(btnDefensa);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio antes del JLabel
        surPanel.add(labelInfo);

        panel.add(surPanel, BorderLayout.SOUTH);
        return panel;
    }
}
