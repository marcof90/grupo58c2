package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;
import model.Transaction;
import services.JavaMySQL;

public class Controlador {
    
    private ArrayList<Client> clientes;

    private JavaMySQL servicioDB;

    public Controlador() {
        super();
        clientes = new ArrayList<>();
        servicioDB = new JavaMySQL();
        checkConnection();
    }

    public ArrayList<Client> getClientes() {
        return clientes;
    }

    public void checkConnection() {
        try {
            if (servicioDB.getConnect().isValid(60)) {
                fillUsersData(servicioDB.getUsersDB());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillUsersData(ResultSet rs) {
        try {
            while (rs.next()) {
                Client cliente = new Client(rs.getString("name"));
                cliente.setId(rs.getInt("id"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void fillTransactionsData(int id) {
        ResultSet rs = servicioDB.getWalletTransactions(id);
        // clientes.get(id).getWallet().setMovimientos(new ArrayList<>());
        clientes.get(id).getWallet().getMovimientos().clear();
        try {
            while (rs.next()) {
                Transaction t = new Transaction(rs.getInt("saldo"),"", 
                rs.getInt("transaction_type"),"");
                clientes.get(id).getWallet().getMovimientos().add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] getClientsData() {
        String[] clientsData = new String[clientes.size()];
        for (int i = 0; i < clientsData.length; i++) {
            clientsData[i] = clientes.get(i).toString();
        }
        return clientsData;
    }
    
    public String[] getDataTransactions(int id) {
        String[] dataTransactions = new String[clientes.get(id).getWallet().getMovimientos().size()];
        for (int i = 0; i < dataTransactions.length; i++) {
            dataTransactions[i] = clientes.get(id).getWallet().getMovimientos().get(i).toString();
        }
        return dataTransactions;
    }

    public void addClient(String nombre) {
        Client cliente = new Client(nombre);
        clientes.add(cliente);
        servicioDB.insertUser(nombre);
    }

    public void insertTransaction(int id, int type, int value) {
        servicioDB.insertTransaction(id, type, value);
    }

    public String listarClientes() {
        String listado = "";
        for (Client client : clientes) {
            listado += "Nombre: "+client.getNombre()+"\n";
        }
        return listado;
    }

    public Client getWalletUser(int id) {
        ResultSet rs = servicioDB.getWalletUser(clientes.get(id).getId());
        try {
            while (rs.next()) {
                clientes.get(id).getWallet().setId(rs.getInt("id"));
                clientes.get(id).getWallet().setSaldo(rs.getInt("saldo"));
            }
            return clientes.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
