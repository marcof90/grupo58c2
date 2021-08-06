package views;

import javax.swing.JFrame;

import controller.Controlador;
import model.Client;

import java.awt.BorderLayout;

public class Interfaz extends JFrame{

    private PanelOpciones panelOpciones;  
    private PanelClientes panelClientes; 
    
    private Controlador controlador;

    public Interfaz() {
        super();
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        controlador = new Controlador();

        panelOpciones = new PanelOpciones(this);
        panelClientes = new PanelClientes(this);
        add(panelOpciones, BorderLayout.SOUTH);
        add(panelClientes, BorderLayout.CENTER);
        updateList();
    }
    
    public void addClient(String nombre) {
        controlador.addClient(nombre);
    }

    public String listarClientes() {
        return controlador.listarClientes();
    }

    public void updateList(){
        panelClientes.updateList(controlador.getClientsData());
    }

    public static void main(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }

}
