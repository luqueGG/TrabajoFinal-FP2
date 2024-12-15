package gui;

import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
	private JPanel panelPadre = new JPanel(); // El panel padre
	// PANELES NIVEL 1
	private JPanel panelMenu = new JPanel(); // ESTARAN AQUI LAS OPCIONES DEL MENU PRINCIPAL
	private JPanel panelImagen = new JPanel(); // LA IMAGEN PARA RELLENAR LOS ESPACIOS
	// PANELES NIVEL 2
	private JPanel panelIngreso = new JPanel(); // JUGAR, OPCIONES, SALIR
	// BOTONES
	private JButton btnJugar = new JButton("JUGAR");
	private JButton btnOpciones = new JButton("OPCIONES");
	private JButton btnSalir = new JButton("SALIR");
	// TEXTO
	private JLabel titulo = new JLabel("Proyecto");
	private JLabel autor = new JLabel("por fernando");
	// IMAGEN
	private URL imagenUrl = MenuInterfaz.class.getResource("/assets/rosaMenu.png");
	private JLabel imagen = new JLabel();
	// Constructor
	public MenuInterfaz () {		
		setSize(WIDTH,HEIGHT);
		setTitle("Proyecto final");		
		setLayout(new BorderLayout()); // 1 row, 2 cols
		getContentPane().setBackground(FONDO); // Un tono grisaseo azulado
		renderizarBotones(); // Ahora los botones tienen un aspecto mas chico
		panelPadre.setLayout(new BorderLayout());
		panelPadre.setBackground(FONDO);		
		/**
		 * Implementacion de los paneles: panelMenu a la Izq | panelImagen a la Der
		 * - Dentro de panelMenu -> titulo
		 * - Dentro de panelMenu -> panelIngreso = (contiene) {jugar,opciones,salir}
		 * - Dentro de panelMenu -> autor
		 */
		establecerFondoMenu();
		establecerFondoImagen();
		add(panelPadre);
		// Distinas acciones (eventos)
		acciones();
		// Cerrar ventana, valores:
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	// Agregar los paneles a la ventana principal:
	private void establecerFondoMenu() {
		// LABELS FONTS Y COLORS
		titulo.setFont(new Font("Arial", Font.BOLD, 30));
		titulo.setForeground(Color.WHITE);
		autor.setFont(new Font("Arial", Font.BOLD, 30));
		autor.setForeground(Color.WHITE);
		// Inicio de los paneles
		panelMenu.setBackground(FONDO);
		panelMenu.setLayout(new BorderLayout()); // Para establecer SOUTH, CENTER y NORTH
		panelMenu.add(titulo, BorderLayout.NORTH);
		// Panel de ingreso con BoxLayout para los botones en columna
		panelIngreso.setLayout(new BoxLayout(panelIngreso, BoxLayout.Y_AXIS));
		panelIngreso.setBackground(FONDO); // Color del panel
		// Centrar el panel de botones verticalmente
		panelIngreso.add(Box.createVerticalGlue()); // Esto empuja los componentes hacia el centro verticalmente
		btnJugar.setAlignmentX(CENTER_ALIGNMENT);
		panelIngreso.add(btnJugar);
		panelIngreso.add(Box.createVerticalStrut(30)); // Espacio entre botones
		btnOpciones.setAlignmentX(CENTER_ALIGNMENT);
		panelIngreso.add(btnOpciones);
		panelIngreso.add(Box.createVerticalStrut(30)); // Espacio entre botones
		btnSalir.setAlignmentX(CENTER_ALIGNMENT);
		panelIngreso.add(btnSalir);
		panelIngreso.add(Box.createVerticalGlue()); // Esto empuja los componentes hacia el centro verticalmente
		// Agregado panel ingreso al MENU
		panelMenu.add(panelIngreso, BorderLayout.CENTER);
		panelMenu.add(autor, BorderLayout.SOUTH);
		// Agregado a la ventana MENU Interfaz
		panelPadre.add(panelMenu, BorderLayout.WEST);
	}
	// Botones, tamaño por defecto
	private void renderizarBotones() {
		// Size
		btnJugar.setPreferredSize(new Dimension(150, 40));
		btnOpciones.setPreferredSize(new Dimension(150, 40));
		btnSalir.setPreferredSize(new Dimension(150, 40));
		// Color
		btnJugar.setBackground(new Color(144,171,185));
		btnOpciones.setBackground(new Color(144,171,185));
		btnSalir.setBackground(new Color(144,171,185));
		// Focus desaparecido
		btnJugar.setFocusPainted(false);
		btnOpciones.setFocusPainted(false);
		btnSalir.setFocusPainted(false);	
	}
	// Agregar la imagen a la ventana principal
	private void establecerFondoImagen() {
		panelImagen.setBackground(FONDO); // Color 
		panelImagen.setLayout(new BorderLayout());
		imagen.setIcon(new ImageIcon(imagenUrl));
		panelImagen.add(imagen, BorderLayout.CENTER);
		panelPadre.add(panelImagen, BorderLayout.EAST);
	}
	// Acciones, conjunto de eventos que se podrian cumplir
	private void acciones() {
		actionBtnJugar(); // Jugar -play
		actionBtnOpciones(); // Para las opciones y edicion del juego
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
	private void actionBtnJugar () {
		btnJugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuEleccion();			
			}
		});
	}
	private void actionBtnOpciones () {
		btnOpciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}