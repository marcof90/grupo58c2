package controller;

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
    }

    public ArrayList<Client> getClientes() {
        return clientes;
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
    }

    public String listarClientes() {
        String listado = "";
        for (Client client : clientes) {
            listado += "Nombre: "+client.getNombre()+"\n";
        }
        return listado;
    }
}
