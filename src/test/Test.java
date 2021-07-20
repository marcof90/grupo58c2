package test;

import model.Client;
import model.Wallet;

public class Test {

    public static void main(String[] args){
        Test iniciarPruebas = new Test();
        iniciarPruebas.escenarioClient();

    }

    public void escenarioClient(){
        Client cliente1 = new Client("Esteban");
        boolean test1 = assertEquals("Esteban", cliente1.getNombre());
        boolean test2 = assertNotNull(cliente1.getWallet());

        //(condition)? responseTrue: responseFalse
        System.out.println( (test1)? "Paso la prueba de nombre":"Error el nombre no es igual" );
        System.out.println( (test2)? "La wallet es valida":"Error, no existe la wallet no existe " );
        //responseTrue if condition
    }

    public boolean assertEquals ( String expected, String received){
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
