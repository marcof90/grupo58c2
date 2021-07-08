package views;

import model.Client;

public class VistaUser {
    public static void main(String[] args) {
        Client customer1 = new Client("Marco");
        Client customer2 = new Client("Raul");        
        String response = customer1.getNombre();
        String response1 = customer2.getNombre();
        System.out.println(response);
        System.out.println(response1);
        System.out.println(customer1.getWallet().saveMoney(10000));
        System.out.println(customer1.getWallet().getSaldo());
        System.out.println(customer2.getWallet().getSaldo());
        String response2 = customer1.getWallet().compararCuenta(customer2.getWallet());
        System.out.println(response2);
    }
}
