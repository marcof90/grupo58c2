package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controlador;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Interfaz extends JFrame{

    private PanelOpciones panelOpciones;  
    private PanelClientes panelClientes; 
    private PanelWallet panelWallet;
    private PanelTransactions panelTransactions;

    private Controlador controlador;

    public Interfaz() {
        super();
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wallet");
        setLayout(new BorderLayout());

        controlador = new Controlador();

        panelOpciones = new PanelOpciones(this);
        panelClientes = new PanelClientes(this);
        panelWallet = new PanelWallet(this);
        panelTransactions = new PanelTransactions(this);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 3));
        panelCentral.add(panelClientes);
        panelCentral.add(panelWallet);
        panelCentral.add(panelTransactions);
        add(panelOpciones, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);
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

    public void getWalletUser(int id) {
        panelWallet.updateWallet(controlador.getWalletUser(id).getWallet());
        fillTransactionsData(id);
    }

    public void fillTransactionsData(int id) {
        controlador.fillTransactionsData(id, panelWallet.getActiveWallet());
        updateTranstactionsList(id);
    }

    public void updateTranstactionsList(int id) {
        panelTransactions.updateTranstactions(controlador.getDataTransactions(id));
    }

    public void updateSaldoWallet(int value) {
        controlador.updateSaldoWallet(controlador.getClientes().get(panelClientes.getActiveUser()).getWallet().getSaldo()+value, 
                                    controlador.getClientes().get(panelClientes.getActiveUser()).getWallet().getId());
    }

    public void insertTransaction(int type, int value) {
        if (panelClientes.getActiveUser()==-1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cliente primero");
        }else{
            int id = controlador.getClientes().get(panelClientes.getActiveUser()).getWallet().getId();
            controlador.insertTransaction(id, type, value);
            updateSaldoWallet(value);
            // updateTranstactionsList(panelClientes.getActiveUser());
            getWalletUser(panelClientes.getActiveUser());
        }
    }

    public static void main(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }

}
