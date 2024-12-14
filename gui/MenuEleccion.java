package gui;

import javax.swing.JFrame;

public class MenuEleccion extends JFrame{
    private boolean corr;
    public MenuEleccion() {
        setSize(600,480);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        corr = true;
        setVisible(corr);
    }
}
