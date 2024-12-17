package gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import logic.Personaje;

public class Jugar extends JFrame {
    private static final Color FONDO = new Color(93, 93, 110);
    private JPanel columna1, columna2, columna3;
    private JLabel titulo, labelNivelVida1, labelNivelVida2;

    private Personaje jugador1, jugador2; // Personajes

    public Jugar(URL imagen) {
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(new GridLayout(1, 3)); // Divide la ventana en 3 columnas

        // Inicializar personajes
        jugador1 = new Personaje(); // Ataque, Defensa, Nivel de Vida
        jugador2 = new Personaje();

        // Crear paneles para cada columna
        columna1 = crearColumna(imagen, jugador1, "Jugador 1");
        columna2 = new JPanel(); // Panel vacío para la columna central
        columna2.setBackground(FONDO); // Mantener el color de fondo
        columna3 = crearColumna(imagen, jugador2, "Jugador 2");

        // Añadir paneles a la ventana
        add(columna1);
        add(columna2);
        add(columna3);

        setVisible(true);
    }

    private JPanel crearColumna(URL imagen, Personaje personaje, String nombreJugador) {
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

        JLabel labelNivelVida = new JLabel("Vida: " + personaje.getNivelVida(), SwingConstants.CENTER);
        labelNivelVida.setForeground(Color.WHITE);

        // Configurar alineación
        btnAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNivelVida.setAlignmentX(Component.CENTER_ALIGNMENT);

        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(btnAtaque);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(btnDefensa);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(labelNivelVida);

        // Guardar referencia a los JLabel de nivel de vida para actualización
        if (nombreJugador.equals("Jugador 1")) {
            labelNivelVida1 = labelNivelVida;
        } else {
            labelNivelVida2 = labelNivelVida;
        }

        panel.add(surPanel, BorderLayout.SOUTH);
        return panel;
    }

}
