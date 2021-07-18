package test;
import model.Client;
import model.Wallet;
public class Test {
    public static void main(String[] args) {
        Test startTest = new Test();
        startTest.clientScenario();
    }
    public void clientScenario(){
        Client cliente1 = new Client("Esteban");
        Wallet wallet1 = new Wallet();
        boolean test1 = assertEquals("Esteban", cliente1.getName());
        boolean test2 = assertNotNull(cliente1.getWallet());
        boolean test3 = assertEquals1(wallet1.getBalance());
        // (Condition)? responseTrue: responseFalse
        System.out.println((test1)? "Pasó la prueba de nombre": "Error, el nombre no es igual");
        System.out.println((test2)? "El objeto no es nulo": "Error, el objeto es nulo");
        System.out.println((test3)? "La Wallet sí comienza en 0": "La Wallet no comienza en 0");

    }
    public boolean assertEquals(String expected, String received){
        if(expected.equalsIgnoreCase(received)){
            return true;
        }
        return false;
    }
    public boolean assertNotNull(Object objeto){
        if(objeto != null){
            return true;
        }
        return false;
    }
    public boolean assertEquals1(float number){
        if(number == 0){
            return true;
        }
        return false;
    }
}
