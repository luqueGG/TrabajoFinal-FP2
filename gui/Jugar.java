package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Jugar extends JFrame {
    private static final Color FONDO = new Color(93, 93, 110);
    private JPanel columna1;
    private JPanel columna2;
    private JPanel columna3;
    private JPanel panel;
    private JLabel titulo;
    public Jugar (URL imagen) {
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(new GridLayout(1, 3)); // Divide la ventana en 3 columnas

        // Crear paneles para cada columna
        columna1 = crearColumna(imagen);
        columna2 = new JPanel(); // Panel vacío para la columna central
        columna2.setBackground(FONDO); // Mantener el color de fondo
        columna3 = crearColumna(imagen);

        // Añadir paneles a la ventana
        add(columna1);
        add(columna2);
        add(columna3);

        setVisible(true);
    }

    private JPanel crearColumna(URL imagen) {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);
    
        // Centro: JLabel con imagen
        titulo = new JLabel("", SwingConstants.CENTER);
        titulo.setIcon(new ImageIcon(imagen));
        panel.add(titulo, BorderLayout.CENTER); // Cambiado a CENTER
    
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
