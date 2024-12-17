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
    private URL kash = MenuInterfaz.class.getResource("/assets/kash.png");
    private Personaje jugador1, jugador2;
    private ControladorJuego controlador;

    private boolean turnoJugador1 = true;

    private JButton btnAtaque1, btnDefensa1; // Botones Jugador 1
    private JButton btnAtaque2, btnDefensa2; // Botones Jugador 2

    public Jugar(URL imagen) {
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(FONDO);
        setLayout(new GridLayout(1, 3));

        // Inicializar personajes y controlador
        jugador1 = new Personaje();
        jugador2 = new Personaje();
        controlador = new ControladorJuego(jugador1, jugador2);

        // Crear paneles para cada columna
        columna1 = crearColumna(kash, jugador1, jugador2, "Jugador 1");
        columna2 = crearPanelCentral();
        columna3 = crearColumna(imagen, jugador2, jugador1, "Jugador 2");

        add(columna1);
        add(columna2);
        add(columna3);

        setVisible(true);
    }

    private JPanel crearColumna(URL imagen, Personaje jugador, Personaje oponente, String nombreJugador) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(FONDO);

        titulo = new JLabel(nombreJugador, SwingConstants.CENTER);
        titulo.setIcon(new ImageIcon(imagen));
        panel.add(titulo, BorderLayout.CENTER);

        JPanel surPanel = new JPanel();
        surPanel.setLayout(new BoxLayout(surPanel, BoxLayout.Y_AXIS));
        surPanel.setBackground(FONDO);

        JButton btnAtaque = new JButton("Ataque");
        JButton btnDefensa = new JButton("Defensa");

        JLabel labelNivelVida = new JLabel("Vida: " + jugador.getNivelVida(), SwingConstants.CENTER);
        labelNivelVida.setForeground(Color.WHITE);

        btnAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDefensa.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNivelVida.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Guardar referencias a los botones
        if (nombreJugador.equals("Jugador 1")) {
            btnAtaque1 = btnAtaque;
            btnDefensa1 = btnDefensa;
            labelNivelVida1 = labelNivelVida;
        } else {
            btnAtaque2 = btnAtaque;
            btnDefensa2 = btnDefensa;
            labelNivelVida2 = labelNivelVida;
        }

        // Asignar acciones con verificación de vida
        btnAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarTurno(nombreJugador)) {
                    controlador.atacar(jugador, oponente);
                    cambiarTurno();
                    actualizarVida();
                    verificarGanador();
                }
            }
        });

        btnDefensa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarTurno(nombreJugador)) {
                    controlador.defender(jugador);
                    cambiarTurno();
                    actualizarVida();
                    verificarGanador();
                }
            }
        });

        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(btnAtaque);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(btnDefensa);
        surPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        surPanel.add(labelNivelVida);

        panel.add(surPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel crearPanelCentral() {
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBackground(Color.BLACK);

        JLabel vsLabel = new JLabel("VS", SwingConstants.CENTER);
        vsLabel.setForeground(Color.WHITE);
        vsLabel.setFont(new Font("Arial", Font.BOLD, 48));

        panelCentral.add(vsLabel, BorderLayout.CENTER);
        return panelCentral;
    }

    private void actualizarVida() {
        labelNivelVida1.setText("Vida: " + jugador1.getNivelVida());
        labelNivelVida2.setText("Vida: " + jugador2.getNivelVida());
    }

    private void verificarGanador() {
        if (jugador1.getNivelVida() <= 0) {
            JOptionPane.showMessageDialog(this, "¡Jugador 2 ha ganado!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
            desactivarBotones();
        } else if (jugador2.getNivelVida() <= 0) {
            JOptionPane.showMessageDialog(this, "¡Jugador 1 ha ganado!", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
            desactivarBotones();
        }
    }

    private void desactivarBotones() {
        btnAtaque1.setEnabled(false);
        btnDefensa1.setEnabled(false);
        btnAtaque2.setEnabled(false);
        btnDefensa2.setEnabled(false);
    }

    private boolean validarTurno(String nombreJugador) {
        if ((turnoJugador1 && nombreJugador.equals("Jugador 1")) ||
            (!turnoJugador1 && nombreJugador.equals("Jugador 2"))) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "¡No es tu turno!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void cambiarTurno() {
        turnoJugador1 = !turnoJugador1;
    }
}
