package views;
import model.Client;;
public class VistaUser {
    public static void main(String[] args) {
        Client customer1 = new Client("Marco");
        
        String response = customer1.getName();
        System.out.println(response);
    }
}
