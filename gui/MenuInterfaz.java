package gui;

import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuInterfaz extends JFrame {
	private static final long serialVersionUID = 1L;
	// atributos y colores
	private static final int WIDTH = 600;
	private static final int HEIGHT = 480;
	private static final Color FONDO = new Color(93,93,110);
	// PANELES NIVEL 0
	private JPanel panelMenu = new JPanel(); // ESTARAN AQUI LAS OPCIONES DEL MENU PRINCIPAL
	private JPanel panelImagen = new JPanel(); // LA IMAGEN PARA RELLENAR LOS ESPACIOS
	// PANELES NIVEL 1
	private JPanel panelIngreso = new JPanel(); // JUGAR, OPCIONES, SALIR
	// BOTONES
	private JButton btnJugar = new JButton("JUGAR");
	private JButton btnOpciones = new JButton("OPCIONES");
	private JButton btnSalir = new JButton("SALIR");
	// TEXTO
	private JLabel titulo = new JLabel("Proyecto");
	private JLabel autor = new JLabel("POR LUQUE GUEVARA FERNANDO GERSON");
	// IMAGEN
	private URL imagenUrl = MenuInterfaz.class.getResource("/assets/rosaMenu.png");
	private JLabel imagen = new JLabel();
	
	// Constructor
	public MenuInterfaz () {		
		setSize(WIDTH,HEIGHT);
		setTitle("Proyecto final");		
		setLayout(new BorderLayout()); // 1 row, 2 cols
		getContentPane().setBackground(FONDO); // Un tono grisaseo azulado		
		/**
		 * Implementacion de los paneles: panelMenu a la Izq | panelImagen a la Der
		 * - Dentro de panelMenu -> titulo
		 * - Dentro de panelMenu -> panelIngreso = (contiene) {jugar,opciones,salir}
		 * - Dentro de panelMenu -> autor
		 */
		establecerFondoMenu();
		establecerFondoImagen();
		// Distinas acciones (eventos)
		acciones();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// Agregar los paneles a la ventana principal:
	private void establecerFondoMenu() {
		panelMenu.setLayout(new BorderLayout()); // Para establecer SOUTH, CENTER y NORTH
		panelMenu.add(titulo, BorderLayout.NORTH);
		// Panel derecha: menu ingreso
		panelIngreso.setLayout(new BorderLayout()); // Para botones en SOUTH, CENTER y NORTH
		panelIngreso.add(btnJugar, BorderLayout.NORTH);
		panelIngreso.add(btnOpciones, BorderLayout.CENTER);
		panelIngreso.add(btnSalir, BorderLayout.SOUTH);
		// Agregado panel derecha al MENU
		panelMenu.add(panelIngreso, BorderLayout.CENTER);
		panelMenu.add(autor, BorderLayout.SOUTH);
		// Agregado a la ventana MENU Interfaz
		add(panelMenu, BorderLayout.WEST);
		
	}
	// Agregar la imagen a la ventana principal
	private void establecerFondoImagen() {
		panelImagen.setLayout(new BorderLayout());
		imagen.setIcon(new ImageIcon(imagenUrl));
		panelImagen.add(imagen, BorderLayout.CENTER);
		add(panelImagen, BorderLayout.EAST);
	}
	// Acciones, conjunto de eventos que se podrian cumplir
	private void acciones() {
		actionBtnSalir(); // Por si se quiere salir
	}
	// ACCION: SI se presiona SALIR, el programa muere
	private void actionBtnSalir () {
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
	}
}