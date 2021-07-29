package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Interfaz extends JFrame{

    private PanelOpciones panelOpciones;    

    public Interfaz() {
        super();
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        panelOpciones = new PanelOpciones(this);

        add(panelOpciones, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }

}
