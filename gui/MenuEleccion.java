package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.*;

public class MenuEleccion extends JFrame{
    private static final Color FONDO = new Color(93,93,110);
    private JButton btnAtras = new JButton("Atras");
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
    // Imagenes
    private URL imagenUrlPers1 = MenuInterfaz.class.getResource("/assets/cangrejo.png");
    private URL imagenUrlPers2 = MenuInterfaz.class.getResource("/assets/eye.png");
    private URL imagenUrlPers3 = MenuInterfaz.class.getResource("/assets/victor.png");
    private URL imagenUrlPers4 = MenuInterfaz.class.getResource("/assets/rosa.png");
    // Paneles
    private JPanel gridPanel ;
    public MenuEleccion() {
        setSize(600,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(null);

        // Crear el boton pequeño en la esquina superior izquierda        
        btnAtras.setBounds(10, 10, 80, 30); // Botón pequeño
        add(btnAtras);

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
        lblPers1 = new JLabel("", SwingConstants.CENTER);
        lblPers1.setIcon(new ImageIcon(imagenUrlPers1));
        btnPers1 = new JButton("Jugar con" );
        
        lblPers2 = new JLabel("", SwingConstants.CENTER);
        lblPers2.setIcon(new ImageIcon(imagenUrlPers2));
        btnPers2 = new JButton("Jugar con");
        
        lblPers3 = new JLabel("", SwingConstants.CENTER);
        lblPers3.setIcon(new ImageIcon(imagenUrlPers3));
        btnPers3 = new JButton("Jugar con");
        
        lblPers4 = new JLabel("", SwingConstants.CENTER);
        lblPers4.setIcon(new ImageIcon(imagenUrlPers4));
        btnPers4 = new JButton("Jugar con");
        
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
        actionBtnAtras();
        actionBtnJugar1();
    }
    private void actionBtnAtras () {
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
	}
    private void actionBtnJugar1() {
        btnPers1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new Jugar();
            }
        });
    }
}
