package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class MenuOpciones extends JFrame {
    private static final Color FONDO = new Color(93, 93, 110);
    private JButton btnFacil, btnMedio, btnDificil, btnAtras;

    public MenuOpciones() {
        setTitle("Opciones de Dificultad");
        setSize(600, 480);
        getContentPane().setBackground(FONDO);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Botón "Atrás" en la esquina superior izquierda
        btnAtras = new JButton("Atrás");
        btnAtras.setPreferredSize(new Dimension(80, 30)); // Tamaño reducido
        btnAtras.addActionListener(e -> dispose()); // Cierra la ventana
        JPanel panelAtras = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelAtras.setBackground(FONDO);
        panelAtras.add(btnAtras);
        add(panelAtras, BorderLayout.WEST);

        // Título
        JLabel titulo = new JLabel("Selecciona la dificultad", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);
        add(titulo, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1, 10, 10));
        panelBotones.setBackground(FONDO);

        btnFacil = crearBoton("Fácil");
        btnMedio = crearBoton("Medio");
        btnDificil = crearBoton("Difícil");

        // Agregar botones al panel
        panelBotones.add(btnFacil);
        panelBotones.add(btnMedio);
        panelBotones.add(btnDificil);

        // Centrar los botones y reducir el tamaño
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(FONDO);
        panelCentral.add(panelBotones);
        add(panelCentral, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(150, 40)); // Reducir tamaño
        boton.setFont(new Font("Arial", Font.PLAIN, 16));
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDificultad(texto);
            }
        });
        return boton;
    }

    private void guardarDificultad(String dificultad) {
        try (FileWriter writer = new FileWriter("configuracion.txt")) {
            writer.write("Dificultad seleccionada: " + dificultad);
            JOptionPane.showMessageDialog(this, "Dificultad " + dificultad + " guardada correctamente.",
                    "Configuración Guardada", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la configuración.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
