package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Client;
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

    public String[] getClientsData() {
        String[] clientsData = new String[clientes.size()];
        for (int i = 0; i < clientsData.length; i++) {
            clientsData[i] = clientes.get(i).toString();
        }
        return clientsData;
    }

    public void addClient(String nombre) {
        Client cliente = new Client(nombre);
        clientes.add(cliente);
        servicioDB.insertUser(nombre);
    }

    public String listarClientes() {
        String listado = "";
        for (Client client : clientes) {
            listado += "Nombre: "+client.getNombre()+"\n";
        }
        return listado;
    }

    public void getWalletUser(int id) {
        ResultSet rs = servicioDB.getWalletUser(clientes.get(id).getId());
        try {
            while (rs.next()) {
                clientes.get(id).getWallet().setId(rs.getInt("id"));
                clientes.get(id).getWallet().setSaldo(rs.getInt("saldo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
