package views;

import model.Client;

public class VistaUser {
    public static void main(String[] args) {
        Client customer1 = new Client("Luis K Hernandez"); 
        Client customer2 = new Client("Jhon Carvajal"); 
        String response = customer1.getNombre();
        String response1 = customer2.getNombre();
        //System.out.println(response);
        //System.out.println(response1);
        System.out.println( customer1.getWallet().saveMoney(15000));
        System.out.println(customer1.getWallet().breakLimit());
        System.out.println(customer1.getWallet().saveMoney(15000));
        System.out.println(customer1.getWallet().takeMoney(20000));
        //String response2 = customer1.getWallet().compararCuenta(customer2.getWallet());
        //System.out.println(response2);

        customer1.getWallet().displayMovimientos();
        System.out.println(customer1.getWallet());
        System.out.println( customer1.toString());


    }
    
}
