package views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Wallet;

import java.awt.GridLayout;

public class PanelWallet extends JPanel implements ActionListener {
    
    private JLabel lblSaldo;
    private JLabel lblId;
    private JLabel lblEstado;
    private JButton btnCargar;

    private Interfaz interfaz;

    public PanelWallet(Interfaz i) {
        super();
        setBorder(new TitledBorder("Detalle Wallet"));
        setLayout(new GridLayout());
        JPanel panelAux = new JPanel();
        panelAux.setLayout(new GridLayout(4, 1));
        panelAux.setBorder(new EmptyBorder(20, 20, 10, 10));
        interfaz = i;

        lblSaldo = new JLabel("Saldo:");
        lblEstado = new JLabel("Estado:");
        lblId = new JLabel("ID:");

        btnCargar = new JButton("Cargar");
        btnCargar.addActionListener(this);
        panelAux.add(lblSaldo);
        panelAux.add(lblEstado);
        panelAux.add(lblId);
        panelAux.add(btnCargar);
        add(panelAux);
    }

    public void updateWallet(Wallet w) {
        lblSaldo.setText("Saldo: "+ w.getSaldo());
        lblEstado.setText("Estado: "+ w.getTieneLimite());
        lblId.setText("ID: "+w.getId());
    }

    public void cargarWallet() {
        String valor = JOptionPane.showInputDialog(interfaz, "Digite la cantidad a guardar");
        try {            
            int value = Integer.parseInt(valor);
            interfaz.insertTransaction(1, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(btnCargar.getActionCommand())) {
            cargarWallet();
        }
    }

}
