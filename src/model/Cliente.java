package model;

public class Client extends User {
    private Wallet wallet;

    public Client(String pNombre) {
        super();
        wallet = new Wallet();
        setNombre(pNombre);
    }

    public Wallet getWallet() {
        return wallet;
    }
    
    public String toString(){
        return "soy un cliente";
    }
}
