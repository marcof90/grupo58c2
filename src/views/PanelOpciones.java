package views;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel implements ActionListener {

    public final static String BTN_SALDO = "Ver Saldo";
    public final static String BTN_CARGAR = "Cargar";
    public final static String BTN_CREAR = "Crear clientes";
    public final static String BTN_LISTAR = "Listar clientes";

    // crear relaciones o atributos
    private JButton btnSaldo;
    private JButton btnCargar;    
    private JButton btnCrear;
    private JButton btnListar;
    
    private Interfaz interfaz;

    public PanelOpciones(Interfaz inter) {
        super();
        setLayout(new GridLayout(1, 4));
        setBorder(new TitledBorder("Opciones"));

        interfaz = inter;

        //inicializar las relaciones o atributos
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);
        btnCrear = new JButton(BTN_CREAR);
        btnListar = new JButton(BTN_LISTAR);
        //modificar las propiedades (opcional)
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);
        btnCrear.setActionCommand(BTN_CREAR);
        btnListar.setActionCommand(BTN_LISTAR);

        btnSaldo.addActionListener(this);
        btnCargar.addActionListener(this);
        btnCrear.addActionListener(this);
        btnListar.addActionListener(this);
        //agregar las relaciones o atributos
        add(btnCrear);
        add(btnListar);
        add(btnSaldo);
        add(btnCargar);
    }

    public void addClient() {
        String nombre = JOptionPane.showInputDialog(interfaz, "Digita el nombre del cliente");
        if (nombre!=null && !nombre.equals("")) {            
            interfaz.addClient(nombre);
            interfaz.updateList();
        }else if(nombre != null){
            JOptionPane.showMessageDialog(interfaz, "Revisa los datos");
        }
    }

    public void listarClientes(){
        JOptionPane.showMessageDialog(interfaz, interfaz.listarClientes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals(BTN_SALDO)) {
            JOptionPane.showMessageDialog(interfaz, "Estas viendo el saldo");
            // System.out.println("estas viendo el saldo");
        }else if(e.getActionCommand().equals(btnCargar.getActionCommand())){
            JOptionPane.showMessageDialog(interfaz, "Vas a recargar", "Recarga Wallet", JOptionPane.WARNING_MESSAGE);
            // System.out.println("Vas a recargar");
        }else if(e.getActionCommand().equals(BTN_CREAR)){
            addClient();
        }else if(e.getActionCommand().equals(BTN_LISTAR)){
            listarClientes();
        }
    }

}
