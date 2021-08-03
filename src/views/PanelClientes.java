package views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Client;

import java.awt.GridLayout;

public class PanelClientes extends JPanel {
    
    private Interfaz interfaz;
    private JList<String> listaClientes;

    public PanelClientes(Interfaz inter) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Clientes"));
        interfaz = inter;

        // String[] nombres = {"Nombre 1", "Nombre 2", "Otro nombre"};

        listaClientes = new JList<>();

        listaClientes.setSize(50, 100);

        add(listaClientes);
    }

    public void updateList(String[] lista) {
        listaClientes.setListData(lista);
    }
}
