package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;

public class MenuEleccion extends JFrame{
    private static final Color FONDO = new Color(93,93,110);
    // Labels para el ICON
    private JLabel lblPers1;
    private JLabel lblPers2;
    private JLabel lblPers3;
    private JLabel lblPers4;
    // Botones
    private JButton btnPers1;
    private JButton btnPers2;
    private JButton btnPers3;
    private JButton btnPers4;
    // Paneles
    private JPanel gridPanel ;
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
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas
        gridPanel.setBounds(150, 100, 300, 300); // Tamaño y posición del panel
        gridPanel.setBackground(Color.LIGHT_GRAY); // Fondo del panel

        // Crear JLabels y JButtons y añadirlos al panel
        agregarContenido();
        // Acciones de los controles
        acciones();
        // Añadir el panel al JFrame
        add(gridPanel);    
        setVisible(true);
    }
    private void agregarContenido(){
        lblPers1 = new JLabel("Label 1", SwingConstants.CENTER);
        lblPers1.setForeground(Color.BLACK);
        btnPers1 = new JButton("Button 1" );
        
        lblPers2 = new JLabel("Label 2", SwingConstants.CENTER);
        lblPers2.setForeground(Color.BLACK);
        btnPers2 = new JButton("Button 2");
        
        lblPers3 = new JLabel("Label 3", SwingConstants.CENTER);
        lblPers3.setForeground(Color.BLACK);
        btnPers3 = new JButton("Button 3");
        
        lblPers4 = new JLabel("Label 4", SwingConstants.CENTER);
        lblPers4.setForeground(Color.BLACK);
        btnPers4 = new JButton("Button 4");
        
        gridPanel.add(lblPers1);
        gridPanel.add(btnPers1);                
        gridPanel.add(lblPers2);
        gridPanel.add(btnPers2);
        gridPanel.add(lblPers3);
        gridPanel.add(btnPers3);
        gridPanel.add(lblPers4);
        gridPanel.add(btnPers4);
    }
    private void acciones(){

    }
}
