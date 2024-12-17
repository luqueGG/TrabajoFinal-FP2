package gui;

import javax.swing.*;
import java.awt.*;

public class MenuOpciones extends JFrame {
    private static final Color FONDO = new Color(93,93,110);
    public MenuOpciones () {
        setSize(600,480);
        getContentPane().setBackground(FONDO);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
