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

    // crear relaciones o atributos
    private JButton btnSaldo;
    private JButton btnCargar;    
    
    private Interfaz interfaz;

    public PanelOpciones(Interfaz inter) {
        super();
        setLayout(new GridLayout(1, 2));
        setBorder(new TitledBorder("Opciones"));

        interfaz = inter;

        //inicializar las relaciones o atributos
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);

        //modificar las propiedades (opcional)
        btnSaldo.setActionCommand(BTN_SALDO);
        btnCargar.setActionCommand(BTN_CARGAR);

        btnSaldo.addActionListener(this);
        btnCargar.addActionListener(this);

        //agregar las relaciones o atributos
        add(btnSaldo);
        add(btnCargar);
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
        }
    }

}
