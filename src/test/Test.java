package test;

import model.Client;
import model.Wallet;

public class Test {

    public static void main(String[] args) {
        Test iniciarPruebas = new Test();
        iniciarPruebas.escenarioClient();
        //iniciarPruebas.escenarioWallet();
    }

    public void escenarioClient(){ 
        Client cliente1 = new Client("Luisk");
        boolean test1 = assertEquals("Luisk",cliente1.getNombre());
        boolean test2 = assertNotNull(cliente1.getWallet());
        //boolean test3 = assertEquals());
    
        //...
        System.out.println((test1)? "Paso la prueba de nombre":"Error el nombre no es igual");
        System.out.println((test2)? "Paso la prueba de Wallet":"Error el Wallet esta vacio");
    }

    //public void escenarioWallet(){ 
        Wallet wallet1 = new Wallet();
        //
    //}

    public boolean assertEquals(String expected, String received){
        if (expected.equalsIgnoreCase(received)){
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
}
