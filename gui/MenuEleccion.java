package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

public class MenuEleccion extends JFrame{
    private static final Color FONDO = new Color(93,93,110);

    public MenuEleccion() {
        setSize(600,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(null);

        // Crear el botón pequeño en la esquina superior izquierda
        JButton smallButton = new JButton("Small");
        smallButton.setBounds(10, 10, 80, 30); // Botón pequeño
        add(smallButton);

        // Panel principal para los JLabels y JButtons (centrado)
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas
        gridPanel.setBounds(150, 100, 300, 300); // Tamaño y posición del panel
        gridPanel.setBackground(Color.LIGHT_GRAY); // Fondo del panel

        // Crear JLabels y JButtons y añadirlos al panel
        for (int i = 1; i <= 4; i++) {
            JLabel label = new JLabel("Label " + i, SwingConstants.CENTER);
            label.setForeground(Color.BLACK);
            JButton button = new JButton("Button " + i);
            gridPanel.add(label);
            gridPanel.add(button);
        }

        // Añadir el panel al JFrame
        add(gridPanel);    
        setVisible(true);
    }

}
