package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class PanelWallet extends JPanel {
    
    private JLabel lblSaldo;
    private JLabel lblId;
    private JLabel lblEstado;

    private Interfaz interfaz;

    public PanelWallet(Interfaz i) {
        super();
        setBorder(new TitledBorder("Detalle Wallet"));

        JPanel panelAux = new JPanel();
        panelAux.setLayout(new GridLayout(3, 1));
        panelAux.setBorder(new EmptyBorder(20, 20, 10, 10));
        interfaz = i;

        lblEstado = new JLabel();
        lblSaldo = new JLabel();
        lblId = new JLabel();

        panelAux.add(lblSaldo);
        panelAux.add(lblEstado);
        panelAux.add(lblId);

        add(panelAux);
    }

}
