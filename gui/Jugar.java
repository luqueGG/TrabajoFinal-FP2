package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import logic.*;
public class Jugar extends JFrame {
    private static final Color FONDO = new Color(93, 93, 110);
    private JPanel columna1, columna2, columna3;
    private JLabel titulo, labelNivelVida1, labelNivelVida2;

    private Personaje jugador1, jugador2; // Personajes
    private ControladorJuego controlador;

    public Jugar(URL imagen) {
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(new GridLayout(1, 3)); // Divide la ventana en 3 columnas

        // Inicializar personajes y controlador
        jugador1 = new Personaje(); // Ataque, Defensa, Nivel de Vida
        jugador2 = new Personaje();
        controlador = new ControladorJuego(jugador1, jugador2);

        // Crear paneles para cada columna
        columna1 = crearColumna(imagen, jugador1, jugador2, "Jugador 1");
        columna2 = new JPanel(); // Panel vacío para la columna central
        columna2.setBackground(Color.BLACK);
        columna3 = crearColumna(imagen, jugador2, jugador1, "Jugador 2");

        // Añadir paneles a la ventana
        add(columna1);
        add(columna2);
        add(columna3);

        setVisible(true);
    }

    private JPanel crearColumna(URL imagen, Personaje jugador, Personaje oponente, String nombreJugador) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);

        // Centro: JLabel con imagen
        titulo = new JLabel(nombreJugador, SwingConstants.CENTER);
        titulo.setIcon(new ImageIcon(imagen));
        panel.add(titulo, BorderLayout.CENTER);

        // Sur: Botones y JLabel (Nivel de vida)
        JPanel surPanel = new JPanel();
        surPanel.setLayout(new BoxLayout(surPanel, BoxLayout.Y_AXIS));
        surPanel.setBackground(FONDO);

        JButton btnAtaque = new JButton("Ataque");
        JButton btnDefensa = new JButton("Defensa");

        JLabel labelNivelVida = new JLabel("Vida: " + jugador.getNivelVida(), SwingConstants.CENTER);
        labelNivelVida.setForeground(Color.WHITE);

        // Configurar alineación
        btnAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNivelVida.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Asignar acciones a los botones
        btnAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.atacar(jugador, oponente);
                actualizarVida();
            }
        });

        btnDefensa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.defender(jugador);
                actualizarVida();
            }
        });

        // Guardar referencia a los JLabel de nivel de vida para actualización
        if (nombreJugador.equals("Jugador 1")) {
            labelNivelVida1 = labelNivelVida;
        } else {
            labelNivelVida2 = labelNivelVida;
        }

        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(btnAtaque);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(btnDefensa);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(labelNivelVida);

        panel.add(surPanel, BorderLayout.SOUTH);
        return panel;
    }

    private void actualizarVida() {
        labelNivelVida1.setText("Vida: " + jugador1.getNivelVida());
        labelNivelVida2.setText("Vida: " + jugador2.getNivelVida());
    }
}
