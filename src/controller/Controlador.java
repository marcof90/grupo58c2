package controller;

import java.util.ArrayList;

import model.Client;

public class Controlador {
    
    private ArrayList<Client> clientes;

    public Controlador() {
        super();
        clientes = new ArrayList<>();
    }

    public ArrayList<Client> getClientes() {
        return clientes;
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
