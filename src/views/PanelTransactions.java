package views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class PanelTransactions extends JPanel {
    
    private JList<String> listaTransacciones;

    private Interfaz interfaz;

    public PanelTransactions(Interfaz i) {
        super();
        setLayout(new GridLayout());
        setBorder(new TitledBorder("Transacciones Wallet"));
        interfaz = i;

        listaTransacciones = new JList<>();

        add(listaTransacciones);
    }

    public void updateTranstactions(String[] listadoTransactions) {
        listaTransacciones.setListData(listadoTransactions);
    }

}
