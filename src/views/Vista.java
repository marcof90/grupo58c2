package views;
import model.Wallet;
public class Vista {
    public static void main2(String[] args) {
        Wallet wallet1 = new Wallet(); // Instanciando
        System.out.println(wallet1.getBalance());
        System.out.println(wallet1.saveMoney(200000));
        System.out.println(wallet1.saveMoney(300000));
        System.out.println(wallet1.breakLimit());
        System.out.println(wallet1.saveMoney(600000));
    }
}
