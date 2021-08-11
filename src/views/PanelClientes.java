package views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Client;

import java.awt.GridLayout;

public class PanelClientes extends JPanel implements ListSelectionListener {
    
    private Interfaz interfaz;
    private JList<String> listaClientes;

    public PanelClientes(Interfaz inter) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Clientes"));
        interfaz = inter;

        // String[] nombres = {"Nombre 1", "Nombre 2", "Otro nombre"};

        listaClientes = new JList<>();
        listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaClientes.addListSelectionListener(this);
        listaClientes.setSize(50, 100);

        add(listaClientes);
    }

    public void updateList(String[] lista) {
        listaClientes.setListData(lista);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()){
            interfaz.getWalletUser(listaClientes.getSelectedIndex());
        }
    }

}
