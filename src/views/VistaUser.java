package views;

// import model.Company;
import model.Client;

public class VistaUser {

    public static void main(String[] args) {
        Client Customer1 = new Client("Marco");
        Client Customer2 = new Client("Raul");
        String response = Customer1.getNombre();
        String response1 = Customer2.getNombre();
        System.out.println(response);
        System.out.println(response1);
        System.out.println(Customer1.getWallet().saveMoney(10000));
        String response2 = Customer1.getWallet().compararCuenta(Customer2.getWallet());
        System.out.println(response2);

        // Company empresa = new Company("Nestle");
        // String response = empresa.myWallet().putSaldo(1000000);
        // System.out.println(response);

    }
    
}